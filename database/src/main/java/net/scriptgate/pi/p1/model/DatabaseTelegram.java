package net.scriptgate.pi.p1.model;

import net.scriptgate.pi.p1.Telegram;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="telegram")
public class DatabaseTelegram implements Telegram {

    @Id
    private Date timestamp;
    private String switchElectricity;
    private String switchGas;
    private String meterSerialElectricity;
    private String meterSerialGas;
    private String currentRate;
    private String totalConsumptionDayRate;
    private String totalConsumptionNightRate;
    private String totalProductionDayRate;
    private String totalProductionNightRate;
    private String l1Consumption;
    private String l2Consumption;
    private String l3Consumption;
    private String allPhasesConsumption;
    private String l1Production;
    private String l2Production;
    private String l3Production;
    private String allPhasesProduction;
    private String l1Voltage;
    private String l2Voltage;
    private String l3Voltage;
    private String l1Current;
    private String l2Current;
    private String l3Current;
    private String gasConsumption;

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public void setSwitchElectricity(String switchElectricity) {
        this.switchElectricity = switchElectricity;
    }

    public void setSwitchGas(String switchGas) {
        this.switchGas = switchGas;
    }

    public void setMeterSerialElectricity(String meterSerialElectricity) {
        this.meterSerialElectricity = meterSerialElectricity;
    }

    public void setMeterSerialGas(String meterSerialGas) {
        this.meterSerialGas = meterSerialGas;
    }

    public void setCurrentRate(String currentRate) {
        this.currentRate = currentRate;
    }

    public void setTotalConsumptionDayRate(String totalConsumptionDayRate) {
        this.totalConsumptionDayRate = totalConsumptionDayRate;
    }

    public void setTotalConsumptionNightRate(String totalConsumptionNightRate) {
        this.totalConsumptionNightRate = totalConsumptionNightRate;
    }

    public void setTotalProductionDayRate(String totalProductionDayRate) {
        this.totalProductionDayRate = totalProductionDayRate;
    }

    public void setTotalProductionNightRate(String totalProductionNightRate) {
        this.totalProductionNightRate = totalProductionNightRate;
    }

    public void setL1Consumption(String l1Consumption) {
        this.l1Consumption = l1Consumption;
    }

    public void setL2Consumption(String l2Consumption) {
        this.l2Consumption = l2Consumption;
    }

    public void setL3Consumption(String l3Consumption) {
        this.l3Consumption = l3Consumption;
    }

    public void setAllPhasesConsumption(String allPhasesConsumption) {
        this.allPhasesConsumption = allPhasesConsumption;
    }

    public void setL1Production(String l1Production) {
        this.l1Production = l1Production;
    }

    public void setL2Production(String l2Production) {
        this.l2Production = l2Production;
    }

    public void setL3Production(String l3Production) {
        this.l3Production = l3Production;
    }

    public void setAllPhasesProduction(String allPhasesProduction) {
        this.allPhasesProduction = allPhasesProduction;
    }

    public void setL1Voltage(String l1Voltage) {
        this.l1Voltage = l1Voltage;
    }

    public void setL2Voltage(String l2Voltage) {
        this.l2Voltage = l2Voltage;
    }

    public void setL3Voltage(String l3Voltage) {
        this.l3Voltage = l3Voltage;
    }

    public void setL1Current(String l1Current) {
        this.l1Current = l1Current;
    }

    public void setL2Current(String l2Current) {
        this.l2Current = l2Current;
    }

    public void setL3Current(String l3Current) {
        this.l3Current = l3Current;
    }

    public void setGasConsumption(String gasConsumption) {
        this.gasConsumption = gasConsumption;
    }

    @Override
    public Date getTimestamp() {
        return timestamp;
    }

    @Override
    public String getSwitchElectricity() {
        return switchElectricity;
    }

    @Override
    public String getSwitchGas() {
        return switchGas;
    }

    @Override
    public String getMeterSerialElectricity() {
        return meterSerialElectricity;
    }

    @Override
    public String getMeterSerialGas() {
        return meterSerialGas;
    }

    @Override
    public String getCurrentRate() {
        return currentRate;
    }

    @Override
    public String getTotalConsumptionDayRate() {
        return totalConsumptionDayRate;
    }

    @Override
    public String getTotalConsumptionNightRate() {
        return totalConsumptionNightRate;
    }

    @Override
    public String getTotalProductionDayRate() {
        return totalProductionDayRate;
    }

    @Override
    public String getTotalProductionNightRate() {
        return totalProductionNightRate;
    }

    @Override
    public String getL1Consumption() {
        return l1Consumption;
    }

    @Override
    public String getL2Consumption() {
        return l2Consumption;
    }

    @Override
    public String getL3Consumption() {
        return l3Consumption;
    }

    @Override
    public String getAllPhasesConsumption() {
        return allPhasesConsumption;
    }

    @Override
    public String getL1Production() {
        return l1Production;
    }

    @Override
    public String getL2Production() {
        return l2Production;
    }

    @Override
    public String getL3Production() {
        return l3Production;
    }

    @Override
    public String getAllPhasesProduction() {
        return allPhasesProduction;
    }

    @Override
    public String getL1Voltage() {
        return l1Voltage;
    }

    @Override
    public String getL2Voltage() {
        return l2Voltage;
    }

    @Override
    public String getL3Voltage() {
        return l3Voltage;
    }

    @Override
    public String getL1Current() {
        return l1Current;
    }

    @Override
    public String getL2Current() {
        return l2Current;
    }

    @Override
    public String getL3Current() {
        return l3Current;
    }

    @Override
    public String getGasConsumption() {
        return gasConsumption;
    }
}
