export interface Telegram {

  valid: boolean;
  validCRC: boolean;
  ident: string;
  crc: string;

  p1Version: string;
  timestamp: Date;
  equipmentId: string;

  electricityTariffIndicator: number;
  electricityReceivedLowTariff: number;
  electricityReceivedNormalTariff: number;
  electricityPowerReceived: number;

  electricityReturnedLowTariff: number;
  electricityReturnedNormalTariff: number;
  electricityPowerReturned: number;

  powerFailures: number;
  longPowerFailures: number;
}