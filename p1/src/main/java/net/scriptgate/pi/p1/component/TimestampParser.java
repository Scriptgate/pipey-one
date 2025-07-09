package net.scriptgate.pi.p1.component;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimestampParser {
    // YYMMDDhhmmssX ASCII presentation of Time stamp
    // Year, Month, Day, Hour, Minute, Second, and an indication whether
    // DST is active (X=S ... SummerTime) or DST is not active (X=W ... WinterTime).

    // IMPORTANT ASSUMPTION:
    // This is for the DSMR = Dutch Smart Meter Requirements.
    // Dutch ! means Netherlands which assumes timezone "Europe/Amsterdam"

    // Format                                     Y    Y     M   M      D    D      h    h      m    m      s    s      S or W
    private static final String TIME_FORMAT = "([0-9][0-9])([01][0-9])([0-3][0-9])([0-2][0-9])([0-5][0-9])([0-5][0-9])([SsWw]?)";

    private static final Pattern DATE_TIME_PATTERN = Pattern.compile(TIME_FORMAT);

    public static Date parse(String dsmrTimestamp) {
        if (dsmrTimestamp == null || dsmrTimestamp.isEmpty()) {
            return null;
        }

        Matcher matcher = DATE_TIME_PATTERN.matcher(dsmrTimestamp);

        if (!matcher.find()) {
            return null;
        }
        // CHECKSTYLE.OFF: ParenPad
        Instant baseInstant = Instant.ofEpochSecond(0);
        ZonedDateTime zonedDateTime = ZonedDateTime
                .ofInstant(baseInstant, ZoneOffset.UTC)
                .withYear(2000 +  Integer.parseInt(matcher.group(1)) )
                .withMonth(       Integer.parseInt(matcher.group(2)) )
                .withDayOfMonth(  Integer.parseInt(matcher.group(3)) )
                .withHour(        Integer.parseInt(matcher.group(4)) )
                .withMinute(      Integer.parseInt(matcher.group(5)) )
                .withSecond(      Integer.parseInt(matcher.group(6)) );

        ZoneId zoneId;

        switch(matcher.group(7)) {
            case "S": // Dutch Summertime
            case "s":
                zoneId = ZoneOffset.of("+02:00");
                break;

            case "W": // Dutch Wintertime
            case "w":
                zoneId = ZoneOffset.of("+01:00");
                break;

            default:
                zoneId = ZoneId.of("Europe/Amsterdam");
                break;
        }
        zonedDateTime = zonedDateTime.withZoneSameLocal(zoneId);

        return Date.from(zonedDateTime.toInstant());
    }

}
