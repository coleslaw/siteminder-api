package com.noetic.siteminder.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by Ruwan on 29/06/2018.
 */
public abstract class AbstractDeployConfig implements DeployProfileConfig {

    protected DeployProfile deployProfile;

    public AbstractDeployConfig(DeployProfile deployProfile) {
        this.deployProfile = deployProfile;
    }

    public DeployProfile getDeployProfile() {
        return deployProfile;
    }

    public void setDeployProfile(DeployProfile deployProfile) {
        this.deployProfile = deployProfile;
    }

    public abstract String getApiUsername();

    public abstract String getApiPassword();


    @Bean
    public CacheManager cacheManager() {

        return new EhCacheCacheManager(ehCacheCacheManager().getObject());
    }

    @Bean
    public EhCacheManagerFactoryBean ehCacheCacheManager() {
        EhCacheManagerFactoryBean cmfb = new EhCacheManagerFactoryBean();
        cmfb.setConfigLocation(new ClassPathResource("ehcache.xml"));
        cmfb.setShared(true);
        return cmfb;
    }


}
