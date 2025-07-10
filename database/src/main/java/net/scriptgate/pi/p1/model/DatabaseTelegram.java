package net.scriptgate.pi.p1.model;

import net.scriptgate.pi.p1.Quantity;
import net.scriptgate.pi.p1.Rate;
import net.scriptgate.pi.p1.Telegram;
import net.scriptgate.pi.p1.Unit;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

import static net.scriptgate.pi.p1.Quantity.of;

@Entity
@Table(name="telegram")
public class DatabaseTelegram implements Telegram {

    @Id
    private Date timestamp;
    private Boolean switchElectricity;
    private Boolean switchGas;
    private String meterSerialElectricity;
    private String meterSerialGas;
    private int currentRate;
    private Double totalConsumptionDayRate;
    private Double totalConsumptionNightRate;
    private Double totalProductionDayRate;
    private Double totalProductionNightRate;
    private Double l1Consumption;
    private Double l2Consumption;
    private Double l3Consumption;
    private Double allPhasesConsumption;
    private Double l1Production;
    private Double l2Production;
    private Double l3Production;
    private Double allPhasesProduction;
    private Double l1Voltage;
    private Double l2Voltage;
    private Double l3Voltage;
    private Double l1Current;
    private Double l2Current;
    private Double l3Current;
    private Double gasConsumption;

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public void setSwitchElectricity(Boolean switchElectricity) {
        this.switchElectricity = switchElectricity;
    }

    public void setSwitchGas(Boolean switchGas) {
        this.switchGas = switchGas;
    }

    public void setMeterSerialElectricity(String meterSerialElectricity) {
        this.meterSerialElectricity = meterSerialElectricity;
    }

    public void setMeterSerialGas(String meterSerialGas) {
        this.meterSerialGas = meterSerialGas;
    }

    public void setCurrentRate(int currentRate) {
        this.currentRate = currentRate;
    }

    public void setTotalConsumptionDayRate(Double totalConsumptionDayRate) {
        this.totalConsumptionDayRate = totalConsumptionDayRate;
    }

    public void setTotalConsumptionNightRate(Double totalConsumptionNightRate) {
        this.totalConsumptionNightRate = totalConsumptionNightRate;
    }

    public void setTotalProductionDayRate(Double totalProductionDayRate) {
        this.totalProductionDayRate = totalProductionDayRate;
    }

    public void setTotalProductionNightRate(Double totalProductionNightRate) {
        this.totalProductionNightRate = totalProductionNightRate;
    }

    public void setL1Consumption(Double l1Consumption) {
        this.l1Consumption = l1Consumption;
    }

    public void setL2Consumption(Double l2Consumption) {
        this.l2Consumption = l2Consumption;
    }

    public void setL3Consumption(Double l3Consumption) {
        this.l3Consumption = l3Consumption;
    }

    public void setAllPhasesConsumption(Double allPhasesConsumption) {
        this.allPhasesConsumption = allPhasesConsumption;
    }

    public void setL1Production(Double l1Production) {
        this.l1Production = l1Production;
    }

    public void setL2Production(Double l2Production) {
        this.l2Production = l2Production;
    }

    public void setL3Production(Double l3Production) {
        this.l3Production = l3Production;
    }

    public void setAllPhasesProduction(Double allPhasesProduction) {
        this.allPhasesProduction = allPhasesProduction;
    }

    public void setL1Voltage(Double l1Voltage) {
        this.l1Voltage = l1Voltage;
    }

    public void setL2Voltage(Double l2Voltage) {
        this.l2Voltage = l2Voltage;
    }

    public void setL3Voltage(Double l3Voltage) {
        this.l3Voltage = l3Voltage;
    }

    public void setL1Current(Double l1Current) {
        this.l1Current = l1Current;
    }

    public void setL2Current(Double l2Current) {
        this.l2Current = l2Current;
    }

    public void setL3Current(Double l3Current) {
        this.l3Current = l3Current;
    }

    public void setGasConsumption(Double gasConsumption) {
        this.gasConsumption = gasConsumption;
    }

    @Override
    public Date getTimestamp() {
        return timestamp;
    }

    @Override
    public Boolean getSwitchElectricity() {
        return switchElectricity;
    }

    @Override
    public Boolean getSwitchGas() {
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
    public Rate getCurrentRate() {
        return Rate.from(currentRate);
    }

    @Override
    public Quantity getTotalConsumptionDayRate() {
        return of(totalConsumptionDayRate, Unit.KWH);
    }

    @Override
    public Quantity getTotalConsumptionNightRate() {
        return of(totalConsumptionNightRate, Unit.KWH);
    }

    @Override
    public Quantity getTotalProductionDayRate() {
        return of(totalProductionDayRate, Unit.KWH);
    }

    @Override
    public Quantity getTotalProductionNightRate() {
        return of(totalProductionNightRate, Unit.KWH);
    }

    @Override
    public Quantity getL1Consumption() {
        return of(l1Consumption, Unit.KW);
    }

    @Override
    public Quantity getL2Consumption() {
        return of(l2Consumption, Unit.KW);
    }

    @Override
    public Quantity getL3Consumption() {
        return of(l3Consumption, Unit.KW);
    }

    @Override
    public Quantity getAllPhasesConsumption() {
        return of(allPhasesConsumption, Unit.KW);
    }

    @Override
    public Quantity getL1Production() {
        return of(l1Production, Unit.KW);
    }

    @Override
    public Quantity getL2Production() {
        return of(l2Production, Unit.KW);
    }

    @Override
    public Quantity getL3Production() {
        return of(l3Production, Unit.KW);
    }

    @Override
    public Quantity getAllPhasesProduction() {
        return of(allPhasesProduction, Unit.KW);
    }

    @Override
    public Quantity getL1Voltage() {
        return of(l1Voltage, Unit.V);
    }

    @Override
    public Quantity getL2Voltage() {
        return of(l2Voltage, Unit.V);
    }

    @Override
    public Quantity getL3Voltage() {
        return of(l3Voltage, Unit.V);
    }

    @Override
    public Quantity getL1Current() {
        return of(l1Current, Unit.A);
    }

    @Override
    public Quantity getL2Current() {
        return of(l2Current, Unit.A);
    }

    @Override
    public Quantity getL3Current() {
        return of(l3Current, Unit.A);
    }

    @Override
    public Quantity getGasConsumption() {
        return of(gasConsumption, Unit.M3);
    }
}
