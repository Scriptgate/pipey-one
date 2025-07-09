package net.scriptgate.pi.p1.config;

import net.scriptgate.pi.p1.ports.TelegramService;
import net.scriptgate.pi.p1.ports.P1;
import net.scriptgate.pi.p1.adapter.P1UsingSerialPort;
import net.scriptgate.pi.p1.adapter.P1UsingSimulator;
import net.scriptgate.pi.p1.parser.service.TelegramParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class P1Config {


    private final TelegramParser parser;
    private final TelegramService service;

    public P1Config(
            TelegramParser parser,
            TelegramService service
    ) {
        this.parser = parser;
        this.service = service;
    }

    @Bean
    @Profile("production")
    public P1 p1UsingSerialPort() {
        return new P1UsingSerialPort(parser, service);
    }

    @Bean
    @Profile("test")
    public P1 p1UsingSimulator() {
        return new P1UsingSimulator(parser, service);
    }

}