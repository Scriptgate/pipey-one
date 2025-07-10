package net.scriptgate.pi.p1.model;

import java.util.Date;

public class TelegramTO {

    private String timestamp;
    private Double totalConsumptionDayRate;
    private Double totalConsumptionNightRate;
    private Double l1Consumption;
    private Double l1Voltage;
    private Double l1Current;
    private Double gasConsumption;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Double getTotalConsumptionDayRate() {
        return totalConsumptionDayRate;
    }

    public void setTotalConsumptionDayRate(Double totalConsumptionDayRate) {
        this.totalConsumptionDayRate = totalConsumptionDayRate;
    }

    public Double getTotalConsumptionNightRate() {
        return totalConsumptionNightRate;
    }

    public void setTotalConsumptionNightRate(Double totalConsumptionNightRate) {
        this.totalConsumptionNightRate = totalConsumptionNightRate;
    }

    public Double getL1Consumption() {
        return l1Consumption;
    }

    public void setL1Consumption(Double l1Consumption) {
        this.l1Consumption = l1Consumption;
    }

    public Double getL1Voltage() {
        return l1Voltage;
    }

    public void setL1Voltage(Double l1Voltage) {
        this.l1Voltage = l1Voltage;
    }

    public Double getL1Current() {
        return l1Current;
    }

    public void setL1Current(Double l1Current) {
        this.l1Current = l1Current;
    }

    public Double getGasConsumption() {
        return gasConsumption;
    }

    public void setGasConsumption(Double gasConsumption) {
        this.gasConsumption = gasConsumption;
    }
}
