package net.scriptgate.pi.p1.ports;

import net.scriptgate.pi.p1.Telegram;

import java.util.List;

public interface TelegramRepository {

    List<? extends Telegram> list();

    Telegram save(Telegram telegram);

}
