package com.MADProductions.MADProductions.batch;

import com.MADProductions.MADProductions.model.Details;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class DetailsItemProcessor implements ItemProcessor<Details, Details> {
    private static final Logger logger= LoggerFactory.getLogger(DetailsItemProcessor.class);


    public DetailsItemProcessor() {
    }

    @Override
    public Details process( Details details) throws Exception {
         String name = details.getName().toUpperCase();
         String GPA = details.getGPA();
//         Details transformedDetails = new Details(name,GPA);
        logger.info("Converting(" + name +") into ("+ details+")");
        return details;
    }
}
