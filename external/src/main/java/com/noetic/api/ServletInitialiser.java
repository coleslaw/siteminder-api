package com.noetic.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Component;

import com.noetic.api.siteminder.config.DeployProfile;
import com.noetic.api.siteminder.util.SiteminderUtil;

/**
 * Created by Prageeth Sudesh on 09/11/2018.
 */
@Component
public class ServletInitialiser extends SpringBootServletInitializer {

    @Value("${runtime.parameter.production}")
    private String productionParameter = "/etc/siteminderAPI/production";

    private static Logger log = LoggerFactory.getLogger(ServletInitialiser.class);

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
            log.warn("Initialising application runtime parameter for External {}",
                    deployProfileValue);
        }

        return application.sources(SiteminderServiceExternalApp.class).profiles(deployProfileValue);
    }

}
