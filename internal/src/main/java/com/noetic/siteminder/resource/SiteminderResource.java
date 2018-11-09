package com.noetic.siteminder.resource;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Prageeth Sudesh on 09/11/2018.
 */
@RequestMapping(value = "/internal",
        produces = "application/xml; charset=UTF-8",
        consumes = "application/xml")
public interface SiteminderResource {

}
