package igdxserv.TechLabo4SpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TechLabo4SpringBootApplication{

    public static void main(String[] args) {
        SpringApplication.run(TechLabo4SpringBootApplication.class, args);
    }

}
