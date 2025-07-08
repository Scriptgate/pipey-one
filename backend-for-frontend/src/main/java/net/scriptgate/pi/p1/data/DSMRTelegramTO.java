package net.scriptgate.pi.p1.data;

import java.util.Date;

public class DSMRTelegramTO {

    boolean valid;
    boolean validCRC;
    String ident;
    String crc;

    String p1Version;
    Date timestamp;
    String equipmentId;

    Long electricityTariffIndicator;
    Double electricityReceivedLowTariff;
    Double electricityReceivedNormalTariff;
    Double electricityPowerReceived;

    Double electricityReturnedLowTariff;
    Double electricityReturnedNormalTariff;
    Double electricityPowerReturned;

    Long powerFailures;
    Long longPowerFailures;

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public boolean isValidCRC() {
        return validCRC;
    }

    public void setValidCRC(boolean validCRC) {
        this.validCRC = validCRC;
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public String getCrc() {
        return crc;
    }

    public void setCrc(String crc) {
        this.crc = crc;
    }

    public String getP1Version() {
        return p1Version;
    }

    public void setP1Version(String p1Version) {
        this.p1Version = p1Version;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Long getElectricityTariffIndicator() {
        return electricityTariffIndicator;
    }

    public void setElectricityTariffIndicator(Long electricityTariffIndicator) {
        this.electricityTariffIndicator = electricityTariffIndicator;
    }

    public Double getElectricityReceivedLowTariff() {
        return electricityReceivedLowTariff;
    }

    public void setElectricityReceivedLowTariff(Double electricityReceivedLowTariff) {
        this.electricityReceivedLowTariff = electricityReceivedLowTariff;
    }

    public Double getElectricityReceivedNormalTariff() {
        return electricityReceivedNormalTariff;
    }

    public void setElectricityReceivedNormalTariff(Double electricityReceivedNormalTariff) {
        this.electricityReceivedNormalTariff = electricityReceivedNormalTariff;
    }

    public Double getElectricityPowerReceived() {
        return electricityPowerReceived;
    }

    public void setElectricityPowerReceived(Double electricityPowerReceived) {
        this.electricityPowerReceived = electricityPowerReceived;
    }

    public Double getElectricityReturnedLowTariff() {
        return electricityReturnedLowTariff;
    }

    public void setElectricityReturnedLowTariff(Double electricityReturnedLowTariff) {
        this.electricityReturnedLowTariff = electricityReturnedLowTariff;
    }

    public Double getElectricityReturnedNormalTariff() {
        return electricityReturnedNormalTariff;
    }

    public void setElectricityReturnedNormalTariff(Double electricityReturnedNormalTariff) {
        this.electricityReturnedNormalTariff = electricityReturnedNormalTariff;
    }

    public Double getElectricityPowerReturned() {
        return electricityPowerReturned;
    }

    public void setElectricityPowerReturned(Double electricityPowerReturned) {
        this.electricityPowerReturned = electricityPowerReturned;
    }

    public Long getPowerFailures() {
        return powerFailures;
    }

    public void setPowerFailures(Long powerFailures) {
        this.powerFailures = powerFailures;
    }

    public Long getLongPowerFailures() {
        return longPowerFailures;
    }

    public void setLongPowerFailures(Long longPowerFailures) {
        this.longPowerFailures = longPowerFailures;
    }
}
