package brum.nicolas.api.onepiece.configs;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

import java.util.TimeZone;

@Configuration
public class AppConfig {

    @PostConstruct
    public void timeZoneConfig(){
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }
}
