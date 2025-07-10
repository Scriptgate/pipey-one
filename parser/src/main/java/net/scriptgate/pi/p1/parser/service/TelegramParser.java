package net.scriptgate.pi.p1.parser.service;

import net.scriptgate.pi.p1.Quantity;
import net.scriptgate.pi.p1.Rate;
import net.scriptgate.pi.p1.Telegram;
import net.scriptgate.pi.p1.Unit;
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
        Obis obis = Obis.byCode(line.contains("(") ? line.substring(0, line.indexOf('(')) : "");

        if (obis.exists()) {
            Matcher matcher = Pattern.compile("\\((.*?)\\)").matcher(line);
            List<String> values = new ArrayList<>();
            while (matcher.find()) {
                values.add(matcher.group(1));
            }

            if (!values.isEmpty()) {
                String rawValue = values.get(values.size() - 1);
                String unit = "";
                double value;

                try {
                    if (obis.containsHex()) {
                        StringBuilder ascii = new StringBuilder();
                        for (int i = 0; i < rawValue.length(); i += 2) {
                            ascii.append((char) Integer.parseInt(rawValue.substring(i, i + 2), 16));
                        }
                        telegram.put(obis, ascii.toString());
                    } else if (rawValue.contains("*")) {
                        String[] parts = rawValue.split("\\*");
                        value = Double.parseDouble(parts[0]);
                        unit = parts.length > 1 ? parts[1] : "";
                        telegram.put(obis, new Quantity(value, Unit.from(unit)));
                    } else if(rawValue.endsWith("S") || rawValue.endsWith("W")) {
                        telegram.put(obis, TimestampParser.parse(rawValue));
                    } else if(obis.isRate()) {
                        telegram.put(obis, Rate.from(Integer.parseInt(rawValue)));
                    } else {
                        value = Double.parseDouble(rawValue);
                        telegram.put(obis, new Quantity(value, Unit.from(unit)));
                    }

                } catch (Exception e) {
                    LOG.debug("Error parsing line: {}", e.getMessage(), e);
                }
            }
        }
    }

}
