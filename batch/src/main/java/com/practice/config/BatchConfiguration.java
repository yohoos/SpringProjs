package com.practice.config;

import com.practice.batch.JobCompleteNotificationListener;
import com.practice.batch.MovieCSVItemReader;
import com.practice.batch.MovieItemProcessor;
import com.practice.models.Movie;
import com.practice.repository.MovieRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by yohoos on 5/14/17.
 */
@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public DataSource dataSource;

    @Autowired
    private MovieRepository movieRepository;

    @Bean
    public MovieCSVItemReader reader() throws IOException {
        return new MovieCSVItemReader("/home/yohoos/Desktop/VMSharedFolder/datasets/ml-latest/movies.csv");
    }

    @Bean
    public MovieItemProcessor processor() {
        return new MovieItemProcessor();
    }

    @Bean
    public RepositoryItemWriter<Movie> writer() {
        RepositoryItemWriter<Movie> writer = new RepositoryItemWriter<>();
        writer.setMethodName("save");
        writer.setRepository(movieRepository);
        return writer;
    }

    @Bean
    public Job importUserJob(JobCompleteNotificationListener listener) throws IOException {
        return jobBuilderFactory.get("importMovieJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1())
                .end()
                .build();
    }

    @Bean
    public Step step1() throws IOException {
        return stepBuilderFactory.get("step1")
                .<Movie, Movie>chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }
}
