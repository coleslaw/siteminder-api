package com.noetic.siteminder.config;


import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.dialect.Dialect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

/**
 * Created by Ruwan on 31/07/2018.
 */
@EnableSpringDataWebSupport
public abstract class JpaCommonConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(JpaCommonConfig.class);

    public abstract DataSource dataSource();

    public abstract JpaVendorAdapter getJpaVendorAdapter();

    protected abstract Class<? extends Dialect> getDatabaseDialect();

    protected abstract String getEntityPackage();

    public abstract JpaTransactionManager transactionManager(EntityManagerFactory emf);
    
	public abstract LocalContainerEntityManagerFactoryBean entityManagerFactory();

    protected Properties getJpaProperties() {
        return null;
    }

}