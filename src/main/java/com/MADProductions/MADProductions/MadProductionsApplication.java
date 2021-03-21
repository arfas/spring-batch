package com.MADProductions.MADProductions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class MadProductionsApplication {

	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(MadProductionsApplication.class);
		SpringApplication.run(MadProductionsApplication.class, args);
		logger.info("Application started");

	}

}
