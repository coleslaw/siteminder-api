package com.noetic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by Ruwan on 29/08/2018.
 */
@SpringBootApplication
@EnableScheduling
public class SiteminderServiceInternalApp {

    public static void main(String[] args) {
        SpringApplication.run(SiteminderServiceInternalApp.class, args);
    }
}
