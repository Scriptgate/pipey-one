package net.scriptgate.pi.p1;

import java.util.Date;

public interface Telegram {
    Date getTimestamp();
    String getSwitchElectricity();
    String getSwitchGas();
    String getMeterSerialElectricity();
    String getMeterSerialGas();
    String getCurrentRate();
    String getTotalConsumptionDayRate();
    String getTotalConsumptionNightRate();
    String getTotalProductionDayRate();
    String getTotalProductionNightRate();
    String getL1Consumption();
    String getL2Consumption();
    String getL3Consumption();
    String getAllPhasesConsumption();
    String getL1Production();
    String getL2Production();
    String getL3Production();
    String getAllPhasesProduction();
    String getL1Voltage();
    String getL2Voltage();
    String getL3Voltage();
    String getL1Current();
    String getL2Current();
    String getL3Current();
    String getGasConsumption();
}
