package net.scriptgate.pi.p1.model;

import net.scriptgate.pi.p1.Telegram;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TelegramTOBuilder {

    public static TelegramTO telegramTO(Telegram telegram) {
        TelegramTO to = new TelegramTO();
        to.setTimestamp(dateAsString(telegram.getTimestamp()));
        to.setTotalConsumptionDayRate(telegram.getTotalProductionDayRate().getValue());
        to.setTotalConsumptionNightRate(telegram.getTotalConsumptionNightRate().getValue());
        to.setL1Consumption(telegram.getL1Consumption().getValue());
        to.setL1Voltage(telegram.getL1Voltage().getValue());
        to.setL1Current(telegram.getL1Current().getValue());
        to.setGasConsumption(telegram.getGasConsumption().getValue());
        return to;
    }

    private static String dateAsString(Date timestamp) {
        return new SimpleDateFormat("dd/MM HH:mm").format(timestamp);
    }

}
