package net.scriptgate.pi.p1.service;

import net.scriptgate.pi.p1.Telegram;
import net.scriptgate.pi.p1.ports.TelegramRepository;
import net.scriptgate.pi.p1.ports.TelegramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TelegramServiceUsingMessagingTemplate implements TelegramService {

    private SimpMessagingTemplate template;
    private TelegramRepository repository;

    public TelegramServiceUsingMessagingTemplate(
            SimpMessagingTemplate template,
            TelegramRepository repository
    ) {
        this.template = template;
        this.repository = repository;
    }

    @Override
    public void broadcast(Telegram data) {
        repository.save(data);
        template.convertAndSend("/p1/telegram", repository.list());
    }

}
