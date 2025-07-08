package net.scriptgate.pi.p1.data;

import nl.basjes.dsmr.DSMRTelegram;

import java.time.ZonedDateTime;
import java.util.Date;

public class DSMRTelegramTOBuilder {

    public static DSMRTelegramTO build(DSMRTelegram telegram) {
        DSMRTelegramTO to = new DSMRTelegramTO();
        to.setValid(telegram.isValid());
        to.setValidCRC(telegram.isValidCRC());
        to.setIdent(telegram.getIdent());
        to.setCrc(telegram.getCrc());

        to.setP1Version(telegram.getP1Version());
        to.setTimestamp(toDate(telegram.getTimestamp()));
        to.setEquipmentId(telegram.getEquipmentId());

        to.setElectricityTariffIndicator(telegram.getElectricityTariffIndicator());
        to.setElectricityReceivedLowTariff(telegram.getElectricityReceivedLowTariff());
        to.setElectricityReceivedNormalTariff(telegram.getElectricityReceivedNormalTariff());
        to.setElectricityPowerReceived(telegram.getElectricityPowerReceived());

        to.setElectricityReturnedLowTariff(telegram.getElectricityReturnedLowTariff());
        to.setElectricityReturnedNormalTariff(telegram.getElectricityReturnedNormalTariff());
        to.setElectricityPowerReturned(telegram.getElectricityPowerReturned());

        to.setPowerFailures(telegram.getPowerFailures());
        to.setLongPowerFailures(telegram.getLongPowerFailures());

        return to;
    }

    private static Date toDate(ZonedDateTime timestamp) {
        if(timestamp == null) {
            return null;
        }
        return Date.from(timestamp.toInstant());
    }

}
