package it.aesys.courses.springboot.lesson1.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("brandolini.config")//prefisso che va a selezionare dentro il nostro application.yml
public class BrandoliniConfig {


    public BrandoliniConfig() {
    }

    private String version;
    private String appName;
    private String description;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
