package com.practice.batch;

import com.practice.models.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by yohoos on 5/14/17.
 */
public class MovieItemProcessor implements ItemProcessor<Movie, Movie> {

    private static final Logger log = LoggerFactory.getLogger(MovieItemProcessor.class);

    @Override
    public Movie process(final Movie person) throws Exception {
        return person;
    }
}
