package net.scriptgate.pi.p1.component;

import com.fazecast.jSerialComm.SerialPort;
import net.scriptgate.pi.p1.TelegramService;
import net.scriptgate.pi.p1.P1;
import net.scriptgate.pi.p1.parser.CheckCRC;
import net.scriptgate.pi.p1.parser.service.TelegramParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P1UsingSerialPort implements P1, ApplicationRunner {

    static final String SERIAL_PORT = "/dev/ttyUSB0";

    private final TelegramParser parser;
    private final TelegramService service;

    public P1UsingSerialPort(
            TelegramParser parser,
            TelegramService service
    ) {
        this.parser = parser;
        this.service = service;
    }

    public static final Logger LOG = LoggerFactory.getLogger(P1UsingSerialPort.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            SerialPort port = SerialPort.getCommPort(SERIAL_PORT);
            port.setBaudRate(115200);
            port.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);

            if (!port.openPort()) {
                LOG.info("Failed to open serial port.");
                return;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(port.getInputStream()));
            List<String> telegram = new ArrayList<>();

            String line;
            while ((line = reader.readLine()) != null) {
                LOG.debug("Reading: {}", line);
                if (line.startsWith("/")) {
                    telegram.clear();
                }

                telegram.add(line);

                if (line.contains("!")) {
                    if (CheckCRC.crcIsValid(telegram)) {
                        service.send(parser.parse(telegram));
                    } else {
                        LOG.warn("CRC check failed.");
                    }
                }
            }
            port.closePort();
        } catch (Exception e) {
            LOG.error("Something went wrong...", e);
        }
    }
}
