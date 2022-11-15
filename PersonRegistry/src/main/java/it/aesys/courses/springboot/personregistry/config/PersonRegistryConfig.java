package it.aesys.courses.springboot.personregistry.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("PersonRegistry.config")
public class PersonRegistryConfig {

    private String appName;
    private String version;
    private String description;

    public PersonRegistryConfig() {
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}

