package net.scriptgate.pi.p1;

import nl.basjes.dsmr.DSMRTelegram;

public interface DsmrService {

    void send(DSMRTelegram data);

}
