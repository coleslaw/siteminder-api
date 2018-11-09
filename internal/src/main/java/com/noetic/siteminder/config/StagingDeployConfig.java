package com.noetic.siteminder.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.noetic.siteminder.config.staging.CommonConfig;
import com.noetic.siteminder.config.staging.MySQLExternalConfig;
import com.noetic.siteminder.config.staging.MySQLInternalConfig;

/**
 * Created by Ruwan on 29/06/2018.
 */
@Profile("STAGING")
@Configuration
@EnableCaching
@EnableConfigurationProperties({MySQLInternalConfig.class, MySQLExternalConfig.class, CommonConfig.class})
@ComponentScan("com.noetic.siteminder.config")
@Component(value = "StagingDeployConfig")
public class StagingDeployConfig extends AbstractDeployConfig {

    @Autowired
    @Qualifier(value = "STAGING")
    CommonConfig commonConfig;

    public StagingDeployConfig() {
        super(DeployProfile.STAGING);
    }

    public StagingDeployConfig(DeployProfile deployProfile) {
        super(deployProfile);
    }

    @Override
    public String getApiUsername() {
        return commonConfig.getApiUsername();
    }

    @Override
    public String getApiPassword() {
        return commonConfig.getApiPassword();
    }

    @Override
    public String getBaseUrl() {
        return commonConfig.getBaseUrl();
    }

    @Override
    public String getIdentityUrl() {
        return commonConfig.getIdentityUrl();
    }

    @Override
    public String getEmailBaseUrl() {
        return commonConfig.getEmailBaseUrl();
    }

    @Override
    public String getEmailUsername() {
        return commonConfig.getEmailUsername();
    }

    @Override
    public String getEmailPassword() {
        return commonConfig.getEmailPassword();
    }

    @Override
    public String getEmailLinkBaseUrl() {
        return commonConfig.getEmailLinkBaseUrl();
    }

    @Override
    public String getSchedulerSecond() {
        return commonConfig.getSchedulerSecond();
    }

    @Override
    public String getSchedulerMinute() {
        return commonConfig.getSchedulerMinute();
    }

    @Override
    public String getSchedulerHour() {
        return commonConfig.getSchedulerHour();
    }

    @Override
    public String getSchedulerDayOfMonth() {
        return commonConfig.getSchedulerDayOfMonth();
    }

    @Override
    public String getSchedulerMonth() {
        return commonConfig.getSchedulerMonth();
    }

    @Override
    public String getSchedulerDayOfWeek() {
        return commonConfig.getSchedulerDayOfWeek();
    }

    @Override
    public String getSchedulerRunning() {
        return commonConfig.getSchedulerRunning();
    }

}
