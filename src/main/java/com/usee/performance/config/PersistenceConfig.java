/** 
 * Project Name:performance 
 * File Name:PersistenceConfig.java 
 * Package Name:com.usee.performance.config
 * Date:Jul 24, 201511:05:08 AM 
 * Copyright (c) 2015, jianlei.qin@sktlab.com All Rights Reserved. 
 * 
 */
package com.usee.performance.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * ClassName: PersistenceConfig
 * 
 * @author jetq
 * @version Configuration Framework 1.0
 * @since JDK 1.7
 */
@Order(10)
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.usee.performance.domain")
public class PersistenceConfig {

	@Autowired
	private Environment env;

	@Value("${init-db:false}")
	private String initDatabase;

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory().getObject());
		txManager.setDataSource(dataSource());
		return txManager;
	}

	// @Bean
	// public PlatformTransactionManager transactionManager() {
	//
	// EntityManagerFactory factory = entityManagerFactory().getObject();
	//
	// return new JpaTransactionManager(factory);
	//
	// }

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] { "com.usee.performance.domain" });

		Properties jpaProperties = new Properties();

		jpaProperties.put("hibernate.dialect",
				env.getProperty("hibernate.dialect"));
		jpaProperties.put("hibernate.show_sql",
				env.getProperty("hibernate.show_sql"));
		jpaProperties.put("hibernate.hbm2ddl.auto",
				env.getProperty("hibernate.hbm2ddl.auto"));
		sessionFactory.setHibernateProperties(jpaProperties);

		return sessionFactory;
	}
	
	// @Bean
	// public LocalContainerEntityManagerFactoryBean entityManagerFactory()
	//
	// {
	//
	// LocalContainerEntityManagerFactoryBean factory = new
	// LocalContainerEntityManagerFactoryBean();
	//
	// HibernateJpaVendorAdapter vendorAdapter = new
	// HibernateJpaVendorAdapter();
	//
	// vendorAdapter.setGenerateDdl(Boolean.TRUE);
	//
	// vendorAdapter.setShowSql(Boolean.TRUE);
	//
	// factory.setDataSource(dataSource());
	//
	// factory.setJpaVendorAdapter(vendorAdapter);
	//
	// factory.setPackagesToScan("com.usee.performace.domain");
	//
	// Properties jpaProperties = new Properties();
	//
	// jpaProperties.put("hibernate.dialect",
	// env.getProperty("hibernate.dialect"));
	// jpaProperties.put("hibernate.show_sql",
	// env.getProperty("hibernate.show_sql"));
	// jpaProperties.put("hibernate.hbm2ddl.auto",
	// env.getProperty("hibernate.hbm2ddl.auto"));
	//
	// factory.setJpaProperties(jpaProperties);
	//
	// factory.afterPropertiesSet();
	//
	// factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
	//
	// return factory;
	//
	// }

	@Bean
	public HibernateExceptionTranslator hibernateExceptionTranslator() {

		return new HibernateExceptionTranslator();

	}

	@Bean
	public DataSource dataSource() {

		BasicDataSource dataSource = new BasicDataSource();

		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));

		dataSource.setUrl(env.getProperty("jdbc.url"));

		dataSource.setUsername(env.getProperty("jdbc.username"));

		dataSource.setPassword(env.getProperty("jdbc.password"));

		return dataSource;

	}

	@Bean
	public DataSourceInitializer dataSourceInitializer(DataSource dataSource) {

		DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();

		dataSourceInitializer.setDataSource(dataSource);

		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();

		databasePopulator.addScript(new ClassPathResource("db.sql"));

		dataSourceInitializer.setDatabasePopulator(databasePopulator);

		dataSourceInitializer.setEnabled(Boolean.parseBoolean(initDatabase));

		return dataSourceInitializer;

	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate template = new JdbcTemplate(dataSource());
		return template;
	}

}
