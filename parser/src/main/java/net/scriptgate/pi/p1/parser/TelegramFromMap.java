package net.scriptgate.pi.p1.parser;

import net.scriptgate.pi.p1.Telegram;

import java.util.Date;
import java.util.Map;


public class TelegramFromMap implements Telegram {

    private final Map<Obis, Object> values;

    public TelegramFromMap(Map<Obis, Object> values) {
        this.values = values;
    }

    @Override
    public Date getTimestamp() {
        return (Date) values.get(Obis.TIMESTAMP);
    }

    @Override
    public String getSwitchElectricity() {
        return (String) values.get(Obis.SWITCH_ELECTRICITY);
    }

    @Override
    public String getSwitchGas() {
        return (String) values.get(Obis.SWITCH_GAS);
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
    public String getCurrentRate() {
        return (String) values.get(Obis.CURRENT_RATE);
    }

    @Override
    public String getTotalConsumptionDayRate() {
        return (String) values.get(Obis.RATE_DAY_TOTAL_CONSUMPTION);
    }

    @Override
    public String getTotalConsumptionNightRate() {
        return (String) values.get(Obis.RATE_NIGHT_TOTAL_CONSUMPTION);
    }

    @Override
    public String getTotalProductionDayRate() {
        return (String) values.get(Obis.RATE_DAY_TOTAL_PRODUCTION);
    }

    @Override
    public String getTotalProductionNightRate() {
        return (String) values.get(Obis.RATE_NIGHT_TOTAL_PRODUCTION);
    }

    @Override
    public String getL1Consumption() {
        return (String) values.get(Obis.L1_CONSUMPTION);
    }

    @Override
    public String getL2Consumption() {
        return (String) values.get(Obis.L2_CONSUMPTION);
    }

    @Override
    public String getL3Consumption() {
        return (String) values.get(Obis.L3_CONSUMPTION);
    }

    @Override
    public String getAllPhasesConsumption() {
        return (String) values.get(Obis.ALL_PHASE_CONSUMPTION);
    }

    @Override
    public String getL1Production() {
        return (String) values.get(Obis.L1_PRODUCTION);
    }

    @Override
    public String getL2Production() {
        return (String) values.get(Obis.L2_PRODUCTION);
    }

    @Override
    public String getL3Production() {
        return (String) values.get(Obis.L3_PRODUCTION);
    }

    @Override
    public String getAllPhasesProduction() {
        return (String) values.get(Obis.ALL_PHASES_PRODUCTION);
    }

    @Override
    public String getL1Voltage() {
        return (String) values.get(Obis.L1_VOLTAGE);
    }

    @Override
    public String getL2Voltage() {
        return (String) values.get(Obis.L2_VOLTAGE);
    }

    @Override
    public String getL3Voltage() {
        return (String) values.get(Obis.L3_VOLTAGE);
    }

    @Override
    public String getL1Current() {
        return (String) values.get(Obis.L1_CURRENT);
    }

    @Override
    public String getL2Current() {
        return (String) values.get(Obis.L2_CURRENT);
    }

    @Override
    public String getL3Current() {
        return (String) values.get(Obis.L3_CURRENT);
    }

    @Override
    public String getGasConsumption() {
        return (String) values.get(Obis.GAS_CONSUMPTION);
    }
}
