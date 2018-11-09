package com.noetic.siteminder.config;

/**
 * Created by Ruwan on 29/06/2018.
 */
abstract public class AbstractCommonConfig {

    String apiUsername;
    String apiPassword;
    String baseUrl;
    String identityUrl;
    String emailBaseUrl;
    String emailUsername;
    String emailPassword;
    String emailLinkBaseUrl;
    String schedulerSecond;
    String schedulerMinute;
    String schedulerHour;
    String schedulerDayOfMonth;
    String schedulerMonth;
    String schedulerDayOfWeek;
    String schedulerRunning;

    public String getApiUsername() {
        return apiUsername;
    }

    public void setApiUsername(String apiUsername) {
        this.apiUsername = apiUsername;
    }

    abstract public String getApiPassword();

    abstract public void setApiPassword(String apiPassword);

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getIdentityUrl() {
        return identityUrl;
    }

    public void setIdentityUrl(String identityUrl) {
        this.identityUrl = identityUrl;
    }

    public String getEmailBaseUrl() {
        return emailBaseUrl;
    }

    public void setEmailBaseUrl(String emailBaseUrl) {
        this.emailBaseUrl = emailBaseUrl;
    }

    public String getEmailUsername() {
        return emailUsername;
    }

    public void setEmailUsername(String emailUsername) {
        this.emailUsername = emailUsername;
    }

    public String getEmailPassword() {
        return emailPassword;
    }

    public void setEmailPassword(String emailPassword) {
        this.emailPassword = emailPassword;
    }

    public String getEmailLinkBaseUrl() {
        return emailLinkBaseUrl;
    }

    public void setEmailLinkBaseUrl(String emailLinkBaseUrl) {
        this.emailLinkBaseUrl = emailLinkBaseUrl;
    }

    public String getSchedulerSecond() {
        return schedulerSecond;
    }

    public void setSchedulerSecond(String schedulerSecond) {
        this.schedulerSecond = schedulerSecond;
    }

    public String getSchedulerMinute() {
        return schedulerMinute;
    }

    public void setSchedulerMinute(String schedulerMinute) {
        this.schedulerMinute = schedulerMinute;
    }

    public String getSchedulerHour() {
        return schedulerHour;
    }

    public void setSchedulerHour(String schedulerHour) {
        this.schedulerHour = schedulerHour;
    }

    public String getSchedulerDayOfMonth() {
        return schedulerDayOfMonth;
    }

    public void setSchedulerDayOfMonth(String schedulerDayOfMonth) {
        this.schedulerDayOfMonth = schedulerDayOfMonth;
    }

    public String getSchedulerMonth() {
        return schedulerMonth;
    }

    public void setSchedulerMonth(String schedulerMonth) {
        this.schedulerMonth = schedulerMonth;
    }

    public String getSchedulerDayOfWeek() {
        return schedulerDayOfWeek;
    }

    public void setSchedulerDayOfWeek(String schedulerDayOfWeek) {
        this.schedulerDayOfWeek = schedulerDayOfWeek;
    }

    public String getSchedulerRunning() {
        return schedulerRunning;
    }

    public void setSchedulerRunning(String schedulerRunning) {
        this.schedulerRunning = schedulerRunning;
    }

}
