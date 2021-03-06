package com.noetic.api.siteminder.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.noetic.api.siteminder.config.production.CommonConfig;

/**
 * Created by Prageeth Sudesh on 09/11/2018.
 */
@Profile("PRODUCTION")
@Configuration
@EnableConfigurationProperties({CommonConfig.class})
@ComponentScan("com.noetic.api.siteminder")
@Component(value = "ProductionDeployConfig")
public class ProductionDeployConfig extends AbstractDeployConfig {

    @Autowired(required = true)
    @Qualifier(value = "PRODUCTION")
    CommonConfig commonConfig;

    public ProductionDeployConfig() {
        super(DeployProfile.PRODUCTION);
    }

    public ProductionDeployConfig(DeployProfile deployProfile) {
        super(deployProfile);
    }

    @Override
    public String getInternalApiUsername() {
        return commonConfig.getInternalApiUsername();
    }

    @Override
    public String getInternalApiPassword() {
        return commonConfig.getInternalApiPassword();
    }

    @Override
    public String getInternalBaseUrl() {
        return commonConfig.getInternalBaseUrl();
    }

    @Override
    public String getExternalApiUsername() {
        return commonConfig.getExternalApiUsername();
    }

    @Override
    public String getExternalApiPassword() {
        return commonConfig.getExternalApiPassword();
    }

}
