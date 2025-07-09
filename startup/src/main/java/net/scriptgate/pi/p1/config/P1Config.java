package net.scriptgate.pi.p1.config;

import net.scriptgate.pi.p1.TelegramService;
import net.scriptgate.pi.p1.P1;
import net.scriptgate.pi.p1.component.P1UsingSerialPort;
import net.scriptgate.pi.p1.component.P1UsingSimulator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class P1Config {

    private final TelegramService dsrmService;

    public P1Config(TelegramService dsrmService) {
        this.dsrmService = dsrmService;
    }

    @Bean
    @Profile("production")
    public P1 p1UsingSerialPort() {
        return new P1UsingSerialPort(dsrmService);
    }

    @Bean
    @Profile("test")
    public P1 p1UsingSimulator() {
        return new P1UsingSimulator(dsrmService);
    }

}