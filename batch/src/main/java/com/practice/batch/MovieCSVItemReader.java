package com.practice.batch;

import com.opencsv.CSVReader;
import com.practice.models.Movie;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yohoos on 5/14/17.
 */
public class MovieCSVItemReader implements ItemReader<Movie> {

    BufferedReader reader;
    int count = 0;

    public MovieCSVItemReader(String path) throws IOException {
        this.reader = new BufferedReader(new FileReader(path));
        this.reader.readLine();
    }

    @Override
    public Movie read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        String line;
        Movie movie = null;
        if ((line = reader.readLine()) != null) {
            line = line.replaceAll("\"", "");
            Matcher match = Pattern.compile("^([0-9]+),(.+),(.+)$").matcher(line);
            try {
                boolean test = match.find();
                movie = new Movie();
                movie.setMovie_id(Integer.parseInt(match.group(1)));
                movie.setTitle(match.group(2));
                movie.setGenres(match.group(3));
            } catch (UnexpectedInputException e) {
                System.err.println(e.getMessage());
                System.err.println("Line does not have 3 valid elements.");
            }
        }
        count++;
        return movie;
    }
}
