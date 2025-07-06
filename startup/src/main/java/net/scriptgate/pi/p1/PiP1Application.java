package net.scriptgate.pi.p1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"net.scriptgate.pi.p1"})
public class PiP1Application {

    public static void main(String[] args) {
        SpringApplication.run(PiP1Application.class, args);
    }

}
