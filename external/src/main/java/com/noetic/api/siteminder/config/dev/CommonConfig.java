package com.noetic.api.siteminder.config.dev;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.noetic.api.siteminder.config.AbstractCommonConfig;

/**
 * Created by Prageeth Sudesh on 09/11/2018.
 */
@PropertySource("classpath:dev.application.properties")
@ConfigurationProperties(ignoreUnknownFields = true, prefix = "dev")
@Component(value = "DEV")
public class CommonConfig extends AbstractCommonConfig {

    String internalApiPassword;
    String externalApiPassword;

    @Override
    public String getInternalApiPassword() {
        return this.internalApiPassword;
    }

    @Override
    public void setInternalApiPassword(String internalApiPassword) {
        this.internalApiPassword = internalApiPassword;
    }

    @Override
    public String getExternalApiPassword() {
        return this.externalApiPassword;
    }

    @Override
    public void setExternalApiPassword(String externalApiPassword) {
        this.externalApiPassword = externalApiPassword;
    }
}
