package net.scriptgate.pi.p1;

public enum Rate {

    DAY(1),
    NIGHT(2),
    NULL(-1);

    private final int value;

    Rate(int value) {
        this.value = value;
    }

    public static Rate from(int rate) {
        switch(rate) {
            case 1: return DAY;
            case 2: return NIGHT;
            default: return NULL;
        }
    }

    public int getValue() {
        return value;
    }
}
