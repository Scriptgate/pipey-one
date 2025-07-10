package net.scriptgate.pi.p1;

import java.util.Arrays;

public enum Unit {

    KWH("kWh"),
    KW("kW"),
    A("A"),
    V("V"),
    M3("m3"),
    NULL("");

    private final String unit;

    Unit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

    public static Unit from(String unit) {
        return Arrays.stream(values()).filter(u -> u.unit.equals(unit)).findFirst().orElse(NULL);
    }
}
