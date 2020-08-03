package pl.sotomski.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "application")
@Data
public class ApplicationProperties {
    private RandomOrg randomOrg;

    @Data
    public static class RandomOrg {
        private String apiKey;
        private String url;
    }
}
