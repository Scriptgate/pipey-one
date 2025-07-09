package net.scriptgate.pi.p1.model;

import net.scriptgate.pi.p1.Telegram;

public class DatabaseTelegramBuilder {

    public static DatabaseTelegram build(Telegram telegram) {
        DatabaseTelegram databaseTelegram = new DatabaseTelegram();
        databaseTelegram.setTimestamp(telegram.getTimestamp());
        databaseTelegram.setSwitchElectricity(telegram.getSwitchElectricity());
        databaseTelegram.setSwitchGas(telegram.getSwitchGas());
        databaseTelegram.setMeterSerialElectricity(telegram.getMeterSerialElectricity());
        databaseTelegram.setMeterSerialGas(telegram.getMeterSerialGas());
        databaseTelegram.setCurrentRate(telegram.getCurrentRate());
        databaseTelegram.setTotalConsumptionDayRate(telegram.getTotalConsumptionDayRate());
        databaseTelegram.setTotalConsumptionNightRate(telegram.getTotalConsumptionNightRate());
        databaseTelegram.setTotalProductionDayRate(telegram.getTotalProductionDayRate());
        databaseTelegram.setTotalProductionNightRate(telegram.getTotalProductionNightRate());
        databaseTelegram.setL1Consumption(telegram.getL1Consumption());
        databaseTelegram.setL2Consumption(telegram.getL2Consumption());
        databaseTelegram.setL3Consumption(telegram.getL3Consumption());
        databaseTelegram.setAllPhasesConsumption(telegram.getAllPhasesConsumption());
        databaseTelegram.setL1Production(telegram.getL1Production());
        databaseTelegram.setL2Production(telegram.getL2Production());
        databaseTelegram.setL3Production(telegram.getL3Production());
        databaseTelegram.setAllPhasesProduction(telegram.getAllPhasesProduction());
        databaseTelegram.setL1Voltage(telegram.getL1Voltage());
        databaseTelegram.setL2Voltage(telegram.getL2Voltage());
        databaseTelegram.setL3Voltage(telegram.getL3Voltage());
        databaseTelegram.setL1Current(telegram.getL1Current());
        databaseTelegram.setL2Current(telegram.getL2Current());
        databaseTelegram.setL3Current(telegram.getL3Current());
        databaseTelegram.setGasConsumption(telegram.getGasConsumption());
        return databaseTelegram;
    }

}
