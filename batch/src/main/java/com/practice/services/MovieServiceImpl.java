package com.practice.services;

import com.practice.models.Movie;
import com.practice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by yohoos on 5/14/17.
 */
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie findMovieByTitle(String title) {
        return movieRepository.findMovieByTitle(title);
    }

    @Override
    public void saveMovie(Movie movie) {
        movieRepository.save(movie);
    }
}
