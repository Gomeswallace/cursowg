package com.cursomc.config;

import org.apache.el.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cursomc.services.DBService;

@Configuration
@Profile("dev")
public class DevConfig {


	@Autowired
	private DBService dbService; 
	
	
	@Bean
	public boolean instatiateDataBase() throws ParseException {
		
		dbService.instatiateDevDataBase();
		return true;
	}
}
