package com.noetic.api.siteminder.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Prageeth Sudesh on 09/11/2018.
 */
@RestController
public class IndexResource {

    private static Logger log = LoggerFactory.getLogger(IndexResource.class);

    @RequestMapping("/siteminder/info")
    public String hello() {

        log.info("Welcome to Siteminder Channel Manager Service-external");
        return " Welcome to Siteminder Channel Manager Service-external";
    }


}
