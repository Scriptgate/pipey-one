package net.scriptgate.pi.p1;

public class Quantity {

    Double value;
    Unit unit;

    public Quantity(Double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public static Quantity of(Double value, Unit unit) {
        return new Quantity(value, unit);
    }

    public Double getValue() {
        return value;
    }

    public Unit getUnit() {
        return unit;
    }
}
