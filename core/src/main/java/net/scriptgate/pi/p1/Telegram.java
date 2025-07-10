package net.scriptgate.pi.p1;

import java.util.Date;

public interface Telegram {
    Date getTimestamp();
    Boolean getSwitchElectricity();
    Boolean getSwitchGas();
    String getMeterSerialElectricity();
    String getMeterSerialGas();
    Rate getCurrentRate();
    Quantity getTotalConsumptionDayRate();
    Quantity getTotalConsumptionNightRate();
    Quantity getTotalProductionDayRate();
    Quantity getTotalProductionNightRate();
    Quantity getL1Consumption();
    Quantity getL2Consumption();
    Quantity getL3Consumption();
    Quantity getAllPhasesConsumption();
    Quantity getL1Production();
    Quantity getL2Production();
    Quantity getL3Production();
    Quantity getAllPhasesProduction();
    Quantity getL1Voltage();
    Quantity getL2Voltage();
    Quantity getL3Voltage();
    Quantity getL1Current();
    Quantity getL2Current();
    Quantity getL3Current();
    Quantity getGasConsumption();
}
