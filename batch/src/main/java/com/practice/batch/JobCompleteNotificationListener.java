package com.practice.batch;

import com.practice.models.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by yohoos on 5/14/17.
 */
@Component
public class JobCompleteNotificationListener extends JobExecutionListenerSupport {

    private static final Logger log = LoggerFactory.getLogger(JobCompleteNotificationListener.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JobCompleteNotificationListener(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("!!! JOB FINISHED! Time to verify the results");

            List<Movie> results = jdbcTemplate.query("SELECT movie_id, title, genres FROM movie LIMIT 5", new RowMapper<Movie>() {
                @Override
                public Movie mapRow(ResultSet resultSet, int i) throws SQLException {
                    return new Movie(Integer.parseInt(resultSet.getString(1)),
                            resultSet.getString(2), resultSet.getString(3));
                }
            });

            for (Movie movie : results) {
                log.info("Found <" + movie + "> in the database.");
            }
        }
    }
}
