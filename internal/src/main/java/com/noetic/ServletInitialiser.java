package com.noetic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.noetic.siteminder.config.DeployProfile;
import com.noetic.siteminder.util.SiteminderUtil;

/**
 *
 * Created by Ruwan on 29/08/2018.
 *
 * Application initialise, where Deployed environment get passed in to as runtime parameter
 */
public class ServletInitialiser extends SpringBootServletInitializer {

    private static Logger log = LoggerFactory.getLogger(ServletInitialiser.class);

    @Value("${runtime.parameter.production}")
    private String productionParameter = "/etc/siteminderAPI/production";

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

        String deployProfileValue = System.getProperty("deployProfile");

        if (deployProfileValue != null) {
            log.info("Initialising application deployProfile {}", deployProfileValue);
        } else {
            boolean isProduction = false;
            if (productionParameter != null) {
                log.info("Runtime parameter setting {}", productionParameter);
                isProduction = SiteminderUtil.isFileExist(productionParameter);
            }

            if (isProduction) {
                deployProfileValue = DeployProfile.PRODUCTION.name();
            } else {
                deployProfileValue = DeployProfile.LOCAL.name();
            }
            log.warn("Initialising application runtime parameter for Internal  {}",
                    deployProfileValue);
        }

        return application.sources(SiteminderServiceInternalApp.class).profiles(deployProfileValue);
    }

}
