package net.scriptgate.pi.p1.service;

import net.scriptgate.pi.p1.Telegram;
import net.scriptgate.pi.p1.TelegramService;
import net.scriptgate.pi.p1.data.DSMRTelegramTO;
import net.scriptgate.pi.p1.data.DSMRTelegramTOBuilder;
import nl.basjes.dsmr.DSMRTelegram;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TelegramServiceUsingMessagingTemplate implements TelegramService {

    @Autowired private SimpMessagingTemplate template;

    private List<Telegram> cache = new ArrayList<>();

    @Override
    public void send(Telegram data) {
        cache.add(data);
        template.convertAndSend("/dsrm/telegram", cache);
    }

}
