package com.noetic.siteminder.config;

/**
 * Created by Ruwan on 29/06/2018.
 *
 * Possible configuration options for a deployment
 */
public interface DeployProfileConfig {

    DeployProfile getDeployProfile();

    void setDeployProfile(DeployProfile deployProfile);

    String getApiUsername();

    String getApiPassword();

    String getBaseUrl();

    String getIdentityUrl();

    String getEmailBaseUrl();

    String getEmailUsername();

    String getEmailPassword();

    String getEmailLinkBaseUrl();

    String getSchedulerSecond();

    String getSchedulerMinute();

    String getSchedulerHour();

    String getSchedulerDayOfMonth();

    String getSchedulerMonth();

    String getSchedulerDayOfWeek();

    String getSchedulerRunning();

}
