package com.noetic.siteminder.config.dev;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.MySQL5InnoDBDialect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.noetic.siteminder.config.JpaCommonConfig;
import com.noetic.siteminder.util.SiteminderUtil;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * Created by Ruwan on 09/04/2018.
 */
@PropertySource("classpath:dev.application.properties")
@ConfigurationProperties(ignoreUnknownFields = true, prefix = "dev.external.mysql")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {
		"com.noetic.siteminder.domain.external.repository" }, entityManagerFactoryRef = "entityManagerFactory")
public class MySQLExternalConfig extends JpaCommonConfig {

    private String driverClassName;
    private String dbName;
    private String dbServer;
    private String dbPort;
    private String dbUser;
    private String dbPassword;
    private String dbURL;
    private String dbAutoReconnect;
    private String dbAutoReconnectForPool;
    private String dbDialect;
    private String dbEntityPackage;
    private String dbShowSQL;

    private String cpMaxPoolSize;
    private String cpMinPoolSize;
    private String cpInteractiveTimeout;
    private String cpWaitTimeout;
    private String cpMaxIdleTime;
    private String cpAcquireRetryAttempts;
    private String cpAcquireRetryDelay;
    private String cpName;

    private static final Logger LOGGER = LoggerFactory.getLogger(MySQLExternalConfig.class);

    @Override
    @Primary
    @Bean(name = "siteminderAPI" + "DataSource" + "Dev" + "External")
    public DataSource dataSource() {
        try {
            final HikariConfig dataSourceConfig = new HikariConfig();
            dataSourceConfig.setJdbcUrl(getDbURL());
            dataSourceConfig.setDriverClassName(getDriverClassName());
            dataSourceConfig.setUsername(getDbUser());
            dataSourceConfig.setPassword(getDbPassword());

            dataSourceConfig.setPoolName(getCpName() +
                    SiteminderUtil.urnGenerator());

            dataSourceConfig.setMaxLifetime(Integer.parseInt(getCpMaxIdleTime()));
            dataSourceConfig.setMaximumPoolSize(Integer.parseInt(getCpMaxPoolSize()));
            dataSourceConfig.setIdleTimeout(Integer.parseInt(getCpWaitTimeout()));
            dataSourceConfig.setMinimumIdle(Integer.parseInt(getCpMinPoolSize()));


            dataSourceConfig.setAutoCommit(true);

            return new HikariDataSource(dataSourceConfig);

        } catch (Exception e) {
            LOGGER.error("MySQLConfig error", e);
        }

        return null;
    }

    @Override
    public JpaVendorAdapter getJpaVendorAdapter() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        // if TRUE, generate from objects along with relationships.
        vendorAdapter.setGenerateDdl(false);
        vendorAdapter.setDatabasePlatform(getDatabaseDialect().getName());
        vendorAdapter.setShowSql(Boolean.getBoolean(getDbShowSQL()));
        return vendorAdapter;
    }

	@Override
	protected Properties getJpaProperties() {
		Properties properties = new Properties();
		properties.setProperty("GENERATE_STATISTICS", Boolean.TRUE.toString());
		properties.setProperty("FORMAT_SQL", Boolean.TRUE.toString());
		return properties;
	}

    @Override
    @Primary
	@Bean
	@Qualifier(value = "jpaTransactionManager")
	public JpaTransactionManager transactionManager(@Qualifier("entityManagerFactory") EntityManagerFactory emf) {

		return new JpaTransactionManager(emf);
	}
    
    
    
    @Override
    @Primary
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LOGGER.debug("\n\n************ {} ************\n\n",
                getDatabaseDialect().getCanonicalName());

        LocalContainerEntityManagerFactoryBean factory =
                new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(getJpaVendorAdapter());
        LOGGER.debug("\n\n****** Scanning '{}' Packages for Entities ******\n\n", getEntityPackage());
        factory.setPackagesToScan(getEntityPackage());
        factory.setDataSource(dataSource());
        factory.setPersistenceUnitName("domain.external");
        if (getJpaProperties() != null) {
            factory.setJpaProperties(getJpaProperties());
        }
        return factory;
    }
	
	
    @Override
    protected Class<? extends Dialect> getDatabaseDialect() {
        return MySQL5InnoDBDialect.class;
    }

    @Override
    protected String getEntityPackage() {
        return getDbEntityPackage();
    }


    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getDbServer() {
        return dbServer;
    }

    public void setDbServer(String dbServer) {
        this.dbServer = dbServer;
    }

    public String getDbPort() {
        return dbPort;
    }

    public void setDbPort(String dbPort) {
        this.dbPort = dbPort;
    }

    public String getDbUser() {
        return dbUser;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public String getDbAutoReconnect() {
        return dbAutoReconnect;
    }

    public void setDbAutoReconnect(String dbAutoReconnect) {
        this.dbAutoReconnect = dbAutoReconnect;
    }

    public String getDbAutoReconnectForPool() {
        return dbAutoReconnectForPool;
    }

    public void setDbAutoReconnectForPool(String dbAutoReconnectForPool) {
        this.dbAutoReconnectForPool = dbAutoReconnectForPool;
    }

    public String getDbDialect() {
        return dbDialect;
    }

    public void setDbDialect(String dbDialect) {
        this.dbDialect = dbDialect;
    }

    public String getDbEntityPackage() {
        return dbEntityPackage;
    }

    public void setDbEntityPackage(String dbEntityPackage) {
        this.dbEntityPackage = dbEntityPackage;
    }

    public String getCpMaxPoolSize() {
        return cpMaxPoolSize;
    }

    public void setCpMaxPoolSize(String cpMaxPoolSize) {
        this.cpMaxPoolSize = cpMaxPoolSize;
    }

    public String getCpMinPoolSize() {
        return cpMinPoolSize;
    }

    public void setCpMinPoolSize(String cpMinPoolSize) {
        this.cpMinPoolSize = cpMinPoolSize;
    }

    public String getCpInteractiveTimeout() {
        return cpInteractiveTimeout;
    }

    public void setCpInteractiveTimeout(String cpInteractiveTimeout) {
        this.cpInteractiveTimeout = cpInteractiveTimeout;
    }

    public String getCpWaitTimeout() {
        return cpWaitTimeout;
    }

    public void setCpWaitTimeout(String cpWaitTimeout) {
        this.cpWaitTimeout = cpWaitTimeout;
    }

    public String getCpMaxIdleTime() {
        return cpMaxIdleTime;
    }

    public void setCpMaxIdleTime(String cpMaxIdleTime) {
        this.cpMaxIdleTime = cpMaxIdleTime;
    }

    public String getDbURL() {
        return dbURL;
    }

    public void setDbURL(String dbURL) {
        this.dbURL = dbURL;
    }

    public String getDbShowSQL() {
        return dbShowSQL;
    }

    public void setDbShowSQL(String dbShowSQL) {
        this.dbShowSQL = dbShowSQL;
    }

    public String getCpAcquireRetryAttempts() {
        return cpAcquireRetryAttempts;
    }

    public void setCpAcquireRetryAttempts(String cpAcquireRetryAttempts) {
        this.cpAcquireRetryAttempts = cpAcquireRetryAttempts;
    }

    public String getCpAcquireRetryDelay() {
        return cpAcquireRetryDelay;
    }

    public void setCpAcquireRetryDelay(String cpAcquireRetryDelay) {

        this.cpAcquireRetryDelay = cpAcquireRetryDelay;
    }

    public String getCpName() {
        return cpName;
    }

    public void setCpName(String cpName) {
        this.cpName = cpName;
    }

}



