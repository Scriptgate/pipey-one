package net.scriptgate.pi.p1.service;

import net.scriptgate.pi.p1.DsmrService;
import net.scriptgate.pi.p1.data.DSMRTelegramTO;
import net.scriptgate.pi.p1.data.DSMRTelegramTOBuilder;
import nl.basjes.dsmr.DSMRTelegram;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DsmrServiceUsingMessagingTemplate implements DsmrService {

    @Autowired private SimpMessagingTemplate template;

    private List<DSMRTelegramTO> cache = new ArrayList<>();

    @Override
    public void send(DSMRTelegram data) {
        cache.add(DSMRTelegramTOBuilder.build(data));
        template.convertAndSend("/dsrm/telegram", cache);
    }

}
