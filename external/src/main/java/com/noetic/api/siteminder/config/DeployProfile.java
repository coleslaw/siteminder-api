package com.noetic.api.siteminder.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  Possible permutations of runtime configuration.
 *
 *  Select by passing JVM arg -DdeployProfile=DEV
 */
public enum DeployProfile {
    LOCAL, DEV, STAGING, PRELIVE, PRODUCTION;

    private static Logger log = LoggerFactory.getLogger(DeployProfile.class);

    public static DeployProfile getDeployProfile(String value) {
        if (value != null) {
            for (DeployProfile deployProfile : DeployProfile.values()) {
                if (deployProfile.toString().equals(value)) {
                    return deployProfile;
                }
            }
        }

        log.warn("No deployProfile matched for value: " + value);
        log.warn("Safety mode {} mode", LOCAL.name());
        return LOCAL;
    }
}
