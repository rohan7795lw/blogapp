package com.demo.bloagapp.blogapp;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class JpaTestConfig {
	
	
	@Bean
	@Profile("test")
	public DataSource datasource() {
		var datasource = new DriverManagerDataSource();
		
		datasource.setDriverClassName("org.h2.Driver");
		datasource.setUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
		
		return datasource;
	}
}
