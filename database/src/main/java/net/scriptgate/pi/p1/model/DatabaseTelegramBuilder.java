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
        databaseTelegram.setCurrentRate(telegram.getCurrentRate().getValue());
        databaseTelegram.setTotalConsumptionDayRate(telegram.getTotalConsumptionDayRate().getValue());
        databaseTelegram.setTotalConsumptionNightRate(telegram.getTotalConsumptionNightRate().getValue());
        databaseTelegram.setTotalProductionDayRate(telegram.getTotalProductionDayRate().getValue());
        databaseTelegram.setTotalProductionNightRate(telegram.getTotalProductionNightRate().getValue());
        databaseTelegram.setL1Consumption(telegram.getL1Consumption().getValue());
        databaseTelegram.setL2Consumption(telegram.getL2Consumption().getValue());
        databaseTelegram.setL3Consumption(telegram.getL3Consumption().getValue());
        databaseTelegram.setAllPhasesConsumption(telegram.getAllPhasesConsumption().getValue());
        databaseTelegram.setL1Production(telegram.getL1Production().getValue());
        databaseTelegram.setL2Production(telegram.getL2Production().getValue());
        databaseTelegram.setL3Production(telegram.getL3Production().getValue());
        databaseTelegram.setAllPhasesProduction(telegram.getAllPhasesProduction().getValue());
        databaseTelegram.setL1Voltage(telegram.getL1Voltage().getValue());
        databaseTelegram.setL2Voltage(telegram.getL2Voltage().getValue());
        databaseTelegram.setL3Voltage(telegram.getL3Voltage().getValue());
        databaseTelegram.setL1Current(telegram.getL1Current().getValue());
        databaseTelegram.setL2Current(telegram.getL2Current().getValue());
        databaseTelegram.setL3Current(telegram.getL3Current().getValue());
        databaseTelegram.setGasConsumption(telegram.getGasConsumption().getValue());
        return databaseTelegram;
    }

}
