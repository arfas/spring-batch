package com.MADProductions.MADProductions.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class ContollerClass {
    Logger logger = LoggerFactory.getLogger(ContollerClass.class);

    @GetMapping("/enter")
    public String getBook() {
        logger.info("Entered this controller");
        return "Entered this controller";
    }


}
