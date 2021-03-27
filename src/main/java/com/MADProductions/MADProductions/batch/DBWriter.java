package com.MADProductions.MADProductions.batch;

import com.MADProductions.MADProductions.Repository.DetailsRepository;
import com.MADProductions.MADProductions.model.Details;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<Details> {
    Logger logger = LoggerFactory.getLogger(DBWriter.class);
    private DetailsRepository userRepository;

    @Autowired
    public DBWriter(DetailsRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void write(List<? extends Details> users) throws Exception {
        logger.info("Data Saved for Users: " + users);
        userRepository.saveAll(users);
    }
}
