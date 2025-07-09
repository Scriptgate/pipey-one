package net.scriptgate.pi.p1.component;

import com.fazecast.jSerialComm.SerialPort;
import net.scriptgate.pi.p1.Telegram;
import net.scriptgate.pi.p1.TelegramService;
import net.scriptgate.pi.p1.P1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Map.entry;

public class P1UsingSerialPort implements P1, ApplicationRunner {

    static final String SERIAL_PORT = "/dev/ttyUSB0";
    static final boolean DEBUG = false;

    private final TelegramService service;

    public P1UsingSerialPort(TelegramService service) {
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
                if (DEBUG) {
                    LOG.info("Reading: {}", line);
                }
                if (line.startsWith("/")) {
                    telegram.clear();
                }

                telegram.add(line);

                if (line.contains("!")) {
                    if (checkCRC(telegram)) {
                        service.send(parseTelegram(telegram));
                    } else if (DEBUG) {
                        LOG.info("CRC check failed.");
                    }
                }
            }
            port.closePort();
        } catch (Exception e) {
            LOG.error("Something went wrong...", e);
        }
    }

    private boolean checkCRC(List<String> telegramLines) {
        boolean crcValid = CheckCRC.crcIsValid(String.join("\r\n", telegramLines));
        if (!crcValid) {
            LOG.warn("CRC not valid");
        }
        return crcValid;
    }

    private Telegram parseTelegram(List<String> telegram) {
        Map<Obis, Object> values = new HashMap<>();
        for (String line : telegram) {
            parseLine(line, values);
        }
        return new TelegramFromMap(values);
    }

    private void parseLine(String line, Map<Obis, Object> telegram) {
        if (DEBUG) {
            LOG.info("Parsing: {}", line);
        }
        String obis = line.contains("(") ? line.substring(0, line.indexOf('(')) : "";

        if (Obis.hasCode(obis)) {
            Matcher matcher = Pattern.compile("\\((.*?)\\)").matcher(line);
            List<String> values = new ArrayList<>();
            while (matcher.find()) values.add(matcher.group(1));

            if (!values.isEmpty()) {
                String rawValue = values.get(values.size() - 1);
                String unit = "";
                double value;

                try {
                    if (obis.contains("96.1.1")) {
                        // Decode hexadecimal serial number
                        StringBuilder ascii = new StringBuilder();
                        for (int i = 0; i < rawValue.length(); i += 2) {
                            ascii.append((char) Integer.parseInt(rawValue.substring(i, i + 2), 16));
                        }
                        telegram.put(Obis.byCode(obis), ascii.toString());
                        return;
                    } else if (rawValue.contains("*")) {
                        String[] parts = rawValue.split("\\*");
                        value = Double.parseDouble(parts[0]);
                        unit = parts.length > 1 ? parts[1] : "";
                    } else if(rawValue.endsWith("S")) {
                        // Decode timestamp
                        telegram.put(Obis.byCode(obis), TimestampParser.parse(rawValue));
                        return;
                    } else {
                        value = Double.parseDouble(rawValue);
                    }
                    //todo: use unit
                    telegram.put(Obis.byCode(obis), String.valueOf(value));
                } catch (Exception e) {
                    if (DEBUG) {
                        LOG.info("Error parsing line: {}", e.getMessage());
                    }
                }
            }
        }
    }
}
