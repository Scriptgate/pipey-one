export interface Telegram {

  timestamp : Date;
  switchElectricity : string;
  switchGas : string;
  meterSerialElectricity : string;
  meterSerialGas : string;
  currentRate : string;
  totalConsumptionDayRate : string;
  totalConsumptionNightRate : string;
  totalProductionDayRate : string;
  totalProductionNightRate : string;
  l1Consumption : string;
  l2Consumption : string;
  l3Consumption : string;
  allPhasesConsumption : string;
  l1Production : string;
  l2Production : string;
  l3Production : string;
  allPhasesProduction : string;
  l1Voltage : string;
  l2Voltage : string;
  l3Voltage : string;
  l1Current : string;
  l2Current : string;
  l3Current : string;
  gasConsumption : string;
}