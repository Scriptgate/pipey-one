package net.scriptgate.pi.p1.component;

import net.scriptgate.pi.p1.DsmrService;
import net.scriptgate.pi.p1.P1;
import net.scriptgate.pi.p1.service.DsmrServiceUsingMessagingTemplate;
import nl.basjes.dsmr.DSMRTelegram;
import nl.basjes.dsmr.ParseDsmrTelegram;
import nl.basjes.parse.ReadUTF8RecordStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.io.FileInputStream;

import static nl.basjes.dsmr.CheckCRC.crcIsValid;

public class P1UsingSerialPort implements P1, ApplicationRunner {


    private final DsmrService service;

    public P1UsingSerialPort(DsmrService service) {
        this.service = service;
    }

    public static final Logger LOG = LoggerFactory.getLogger(P1UsingSerialPort.class);


    @Override
    public void run(ApplicationArguments args) throws Exception {
        LOG.info("Opening stream /dev/ttyUSB0");
        FileInputStream inputStream = new FileInputStream("/dev/ttyUSB0");

        ReadUTF8RecordStream reader = new ReadUTF8RecordStream(inputStream, "\r\n![0-9A-F]{4}\r\n");

        String value;
        int count = 0;
        while ((value = reader.read())!= null) {
            if (value.length() < 8) {
                continue;
            }

            DSMRTelegram dsmrTelegram = ParseDsmrTelegram.parse(value);

            count++;
            boolean valid = crcIsValid(value);
            LOG.info("{}: {} {} --> {}",
                    count,
                    dsmrTelegram.getTimestamp(),
                    value.substring(value.length()-7, value.length()-2),
                    dsmrTelegram.isValidCRC() ? "Ok" : "BAD");
            if (value.startsWith("/")) {
                if (!valid) {
                    crcIsValid(value);
                }
            }

            service.send(dsmrTelegram);
        }
        LOG.info("---------------------- Done ----------------------");
    }


}
