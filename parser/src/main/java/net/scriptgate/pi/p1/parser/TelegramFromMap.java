package net.scriptgate.pi.p1.parser;

import net.scriptgate.pi.p1.Quantity;
import net.scriptgate.pi.p1.Rate;
import net.scriptgate.pi.p1.Telegram;
import net.scriptgate.pi.p1.Unit;

import java.util.Date;
import java.util.Map;


public class TelegramFromMap implements Telegram {

    private final Map<Obis, Object> values;

    public TelegramFromMap(Map<Obis, Object> values) {
        this.values = values;
    }

    private Boolean toBoolean(Object value) {
        if(value == null) {
            return null;
        } else {
            return "1".equals(value);
        }
    }

    @Override
    public Date getTimestamp() {
        return (Date) values.get(Obis.TIMESTAMP);
    }

    @Override
    public Boolean getSwitchElectricity() {
        return toBoolean(values.get(Obis.SWITCH_ELECTRICITY));
    }

    @Override
    public Boolean getSwitchGas() {
        return toBoolean(values.get(Obis.SWITCH_GAS));
    }

    @Override
    public String getMeterSerialElectricity() {
        return (String) values.get(Obis.METER_SERIAL_ELECTRICITY);
    }

    @Override
    public String getMeterSerialGas() {
        return (String) values.get(Obis.METER_SERIAL_GAS);
    }

    @Override
    public Rate getCurrentRate() {
        return (Rate) values.get(Obis.CURRENT_RATE);
    }

    @Override
    public Quantity getTotalConsumptionDayRate() {
        return get(Obis.RATE_DAY_TOTAL_CONSUMPTION, Unit.KWH);
    }

    @Override
    public Quantity getTotalConsumptionNightRate() {
        return get(Obis.RATE_NIGHT_TOTAL_CONSUMPTION, Unit.KWH);
    }

    @Override
    public Quantity getTotalProductionDayRate() {
        return get(Obis.RATE_DAY_TOTAL_PRODUCTION, Unit.KWH);
    }

    @Override
    public Quantity getTotalProductionNightRate() {
        return get(Obis.RATE_NIGHT_TOTAL_PRODUCTION, Unit.KWH);
    }

    @Override
    public Quantity getL1Consumption() {
        return get(Obis.L1_CONSUMPTION, Unit.KW);
    }

    @Override
    public Quantity getL2Consumption() {
        return get(Obis.L2_CONSUMPTION, Unit.KW);
    }

    @Override
    public Quantity getL3Consumption() {
        return get(Obis.L3_CONSUMPTION, Unit.KW);
    }

    @Override
    public Quantity getAllPhasesConsumption() {
        return get(Obis.ALL_PHASE_CONSUMPTION, Unit.KW);
    }

    @Override
    public Quantity getL1Production() {
        return get(Obis.L1_PRODUCTION, Unit.KW);
    }

    @Override
    public Quantity getL2Production() {
        return get(Obis.L2_PRODUCTION, Unit.KW);
    }

    @Override
    public Quantity getL3Production() {
        return get(Obis.L3_PRODUCTION, Unit.KW);
    }

    @Override
    public Quantity getAllPhasesProduction() {
        return get(Obis.ALL_PHASES_PRODUCTION, Unit.KW);
    }

    @Override
    public Quantity getL1Voltage() {
        return get(Obis.L1_VOLTAGE, Unit.V);
    }

    @Override
    public Quantity getL2Voltage() {
        return get(Obis.L2_VOLTAGE, Unit.V);
    }

    @Override
    public Quantity getL3Voltage() {
        return get(Obis.L3_VOLTAGE, Unit.V);
    }

    @Override
    public Quantity getL1Current() {
        return get(Obis.L1_CURRENT, Unit.A);
    }

    @Override
    public Quantity getL2Current() {
        return get(Obis.L2_CURRENT, Unit.A);
    }

    @Override
    public Quantity getL3Current() {
        return get(Obis.L3_CURRENT, Unit.A);
    }

    @Override
    public Quantity getGasConsumption() {
        return get(Obis.GAS_CONSUMPTION, Unit.M3);
    }

    private Quantity get(Obis obis, Unit unit) {
        Object value = values.get(obis);
        if(value == null) {
            return new Quantity(-1d, unit);
        }
        return (Quantity) value;
    }
}
