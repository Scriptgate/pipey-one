package net.scriptgate.pi.p1.component;

import java.util.Arrays;

public enum Obis {

    TIMESTAMP("0-0:1.0.0"),
    SWITCH_ELECTRICITY("0-0:96.3.10"),
    SWITCH_GAS("0-1:24.4.0"),
    METER_SERIAL_ELECTRICITY("0-0:96.1.1"),
    METER_SERIAL_GAS("0-1:96.1.1"),
    CURRENT_RATE("0-0:96.14.0"),//(1=day,2=night)
    RATE_DAY_TOTAL_CONSUMPTION("1-0:1.8.1"),
    RATE_NIGHT_TOTAL_CONSUMPTION("1-0:1.8.2"),
    RATE_DAY_TOTAL_PRODUCTION("1-0:2.8.1"),
    RATE_NIGHT_TOTAL_PRODUCTION("1-0:2.8.2"),
    L1_CONSUMPTION("1-0:21.7.0"),
    L2_CONSUMPTION("1-0:41.7.0"),
    L3_CONSUMPTION("1-0:61.7.0"),
    ALL_PHASE_CONSUMPTION("1-0:1.7.0"),
    L1_PRODUCTION("1-0:22.7.0"),
    L2_PRODUCTION("1-0:42.7.0"),
    L3_PRODUCTION("1-0:62.7.0"),
    ALL_PHASES_PRODUCTION("1-0:2.7.0"),
    L1_VOLTAGE("1-0:32.7.0"),
    L2_VOLTAGE("1-0:52.7.0"),
    L3_VOLTAGE("1-0:72.7.0"),
    L1_CURRENT("1-0:31.7.0"),
    L2_CURRENT("1-0:51.7.0"),
    L3_CURRENT("1-0:71.7.0"),
    GAS_CONSUMPTION("0-1:24.2.3");

    private String code;

    Obis(String code) {
        this.code = code;
    }

    public static boolean hasCode(String code) {
        return byCode(code) != null;
    }

    static Obis byCode(String obisCode) {
        return Arrays.stream(values()).filter(obis -> obis.code.equals(obisCode)).findFirst().orElse(null);
    }
}
