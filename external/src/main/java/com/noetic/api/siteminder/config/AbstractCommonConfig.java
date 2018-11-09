package com.noetic.api.siteminder.config;

/**
 * Created by Prageeth Sudesh on 09/11/2018.
 */
abstract public class AbstractCommonConfig {

    String internalApiUsername;
    String internalApiPassword;
    String internalBaseUrl;
    String externalApiUsername;
    String externalApiPassword;

    public String getInternalApiUsername() {
        return internalApiUsername;
    }

    public void setInternalApiUsername(String internalApiUsername) {
        this.internalApiUsername = internalApiUsername;
    }

    abstract public String getInternalApiPassword();

    abstract public void setInternalApiPassword(String internalApiPassword);

    public String getInternalBaseUrl() {
        return internalBaseUrl;
    }

    public void setInternalBaseUrl(String internalBaseUrl) {
        this.internalBaseUrl = internalBaseUrl;
    }

    public String getExternalApiUsername() {
        return externalApiUsername;
    }

    public void setExternalApiUsername(String externalApiUsername) {
        this.externalApiUsername = externalApiUsername;
    }

    abstract public String getExternalApiPassword();

    abstract public void setExternalApiPassword(String externalApiPassword);
}
