package net.scriptgate.pi.p1.adapter;

import net.scriptgate.pi.p1.Telegram;
import net.scriptgate.pi.p1.model.DatabaseTelegramBuilder;
import net.scriptgate.pi.p1.ports.TelegramRepository;
import net.scriptgate.pi.p1.repository.DatabaseTelegramRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelegramRepositoryUsingH2 implements TelegramRepository {

    private final DatabaseTelegramRepository repository;

    public TelegramRepositoryUsingH2(DatabaseTelegramRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<? extends Telegram> list() {
        return repository.findAll();
    }

    @Override
    public Telegram save(Telegram telegram) {
        return repository.save(DatabaseTelegramBuilder.build(telegram));
    }
}
