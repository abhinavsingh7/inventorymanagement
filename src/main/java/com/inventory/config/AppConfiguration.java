package com.inventory.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
public class AppConfiguration {
	
	 @Autowired
	 private Environment env;
	 
	@Bean
	public DataSource mySqlDataSource() throws PropertyVetoException {
		ComboPooledDataSource dataSource=new ComboPooledDataSource();
		dataSource.setDriverClass(env.getProperty("spring.datasource.driverClassName"));
        dataSource.setJdbcUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUser(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        dataSource.setMinPoolSize(Integer.parseInt(env.getProperty("spring.datasource.minPoolSize")));
        dataSource.setMaxPoolSize(Integer.parseInt(env.getProperty("spring.datasource.maxPoolSize")));
        dataSource.setMaxIdleTime(10000);
		return dataSource;
		
	}
	
}
