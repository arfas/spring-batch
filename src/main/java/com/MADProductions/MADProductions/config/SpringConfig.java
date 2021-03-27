package com.MADProductions.MADProductions.config;

import com.MADProductions.MADProductions.model.Details;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
@Configuration
@EnableBatchProcessing
public class SpringConfig {
@Bean
public Job job(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory, ItemReader<Details> itemReader, ItemProcessor<Details,Details> itemProcessor, ItemWriter<Details> itemWriter){
Step step=stepBuilderFactory.get("File-Loader").<Details,Details>chunk(100).reader(itemReader).processor(itemProcessor).writer(itemWriter).build();
return jobBuilderFactory.get("New-Load").incrementer(new RunIdIncrementer()).start(step).build();
}
@Bean
public FlatFileItemReader<Details> itemReader() {

    FlatFileItemReader<Details> flatFileItemReader = new FlatFileItemReader<>();
    flatFileItemReader.setResource(new FileSystemResource("src/main/resources/namegrade.csv"));
    flatFileItemReader.setName("CSV-Reader");
    flatFileItemReader.setLinesToSkip(1);
    flatFileItemReader.setLineMapper(lineMapper());
    return flatFileItemReader;

}
@Bean
public LineMapper<Details> lineMapper() {

    DefaultLineMapper<Details> defaultLineMapper = new DefaultLineMapper<>();
    DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

    lineTokenizer.setDelimiter(",");
    lineTokenizer.setStrict(false);
    lineTokenizer.setNames("Name", "GPA");

    BeanWrapperFieldSetMapper<Details> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
    fieldSetMapper.setTargetType(Details.class);

    defaultLineMapper.setLineTokenizer(lineTokenizer);
    defaultLineMapper.setFieldSetMapper(fieldSetMapper);

    return defaultLineMapper;
}
}
