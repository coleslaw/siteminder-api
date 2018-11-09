package com.noetic.siteminder.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hurman on 29/06/2017.
 */
@RestController
public class IndexResource {

    private static Logger log = LoggerFactory.getLogger(IndexResource.class);

    @RequestMapping("/siteminder/info")
    public String hello() {
        log.info("Welcome to Siteminder Channel Manager Service -internal");
        return " Welcome to Siteminder Channel Manager Service -internal";
    }

}
