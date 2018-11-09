package com.noetic.siteminder.config.production;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.noetic.siteminder.config.AbstractCommonConfig;

/**
 * Created by hurman on 29/06/2017.
 */
@PropertySource("classpath:production.application.properties")
@ConfigurationProperties(ignoreUnknownFields = true, prefix = "production")
@Component("PRODUCTION")
public class CommonConfig extends AbstractCommonConfig {

    String apiPassword;

    public String getApiPassword() {
        return this.apiPassword;
    }

    public void setApiPassword(String apiPassword) {
        this.apiPassword = apiPassword;
    }
}
