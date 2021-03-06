package com.MADProductions.MADProductions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.MADProductions.MADProductions")
@SpringBootApplication
public class MadProductionsApplication {
    @Value("${spring.application.name}")

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(MadProductionsApplication.class);
        SpringApplication.run(MadProductionsApplication.class, args);
        logger.info("Application started");

    }

}
