package net.scriptgate.pi.p1.parser.service;

import net.scriptgate.pi.p1.Telegram;
import net.scriptgate.pi.p1.parser.Obis;
import net.scriptgate.pi.p1.parser.TelegramFromMap;
import net.scriptgate.pi.p1.parser.TimestampParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class TelegramParser {

    public static final Logger LOG = LoggerFactory.getLogger(TelegramParser.class);

    public Telegram parse(List<String> telegram) {
        Map<Obis, Object> values = new HashMap<>();
        for (String line : telegram) {
            parseLine(line, values);
        }
        return new TelegramFromMap(values);
    }

    private void parseLine(String line, Map<Obis, Object> telegram) {
        LOG.debug("Parsing: {}", line);
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
                    LOG.debug("Error parsing line: {}", e.getMessage(), e);
                }
            }
        }
    }

}
