package com.ngoctm.springsecurity.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.ngoctm.springsecurity")
@PropertySource("classpath:persistence-mysql.properties")
public class AppConfig {
	
	// logger
	private Logger logger = Logger.getLogger(getClass().getName());
	
	// set up variable to hold properties
	@Autowired
	private Environment env;
	
	private int getIntProp(String propName) {
		
		String propValue = env.getProperty(propName);
		int intPropValue = Integer.parseInt(propValue);
		
		return intPropValue;
		
	}
	
	// define a bean for ViewResolver
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	
	//define bean for security datasource
	@Bean
	public DataSource securityDataSource() {
		
		// log
		logger.info("prop " + env.getProperty("jdbc.user"));
		logger.info("prop " + env.getProperty("jdbc.password"));
		
		System.out.println(env.getProperty("jdbc.user") + env.getProperty("jdbc.password") + env.getProperty("jdbc.url"));
		//create connection pool
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		
		// set jdbc drive class
		try {
			comboPooledDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			
			e.printStackTrace();
		}
		
		// set database connection prop
		comboPooledDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		comboPooledDataSource.setUser(env.getProperty("jdbc.user"));
		comboPooledDataSource.setPassword(env.getProperty("jdbc.password"));
		// set connection pool prop
		comboPooledDataSource.setInitialPoolSize(getIntProp("connection.pool.initialPoolSize"));
		comboPooledDataSource.setMinPoolSize(getIntProp("connection.pool.minPoolSize"));
		comboPooledDataSource.setMaxPoolSize(getIntProp("connection.pool.maxPoolSize"));
		comboPooledDataSource.setMaxIdleTime(getIntProp("connection.pool.maxIdleTime"));
		return comboPooledDataSource;
	}


}
