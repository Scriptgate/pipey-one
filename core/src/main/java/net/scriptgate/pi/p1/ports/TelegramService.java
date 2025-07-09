package net.scriptgate.pi.p1.ports;

import net.scriptgate.pi.p1.Telegram;

public interface TelegramService {

    void broadcast(Telegram data);

}
