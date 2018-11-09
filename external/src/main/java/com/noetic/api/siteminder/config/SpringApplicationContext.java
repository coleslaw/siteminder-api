package com.noetic.api.siteminder.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

/**
 * Created by Prageeth Sudesh on 09/11/2018.
 *
 * Wrapper for access to Spring Application Context from within non-Spring enabled beans. This bean should be
 * initialized during application startup.
 */
@Component
public class SpringApplicationContext implements ApplicationContextAware {

    private static ApplicationContext context;

    /**
     * This method is called from within the ApplicationContext once it is done starting up, it will stick a reference
     * to itself into this bean.
     *
     * @param context a reference to the ApplicationContext.
     */
    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        SpringApplicationContext.context = context;
    }

    public static Object getBean(String beanName) {
        return context.getBean(beanName);
    }

    public static <T> T getBean(String beanName, Class<T> requiredType) {
        return context.getBean(beanName, requiredType);
    }

    public static <T> T getBean(Class<T> requiredType) {
        return context.getBean(requiredType);
    }

    public static Resource getResource(String location) {
        return context.getResource(location);
    }
}