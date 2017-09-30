package com.practice.services;

import com.practice.models.Movie;

/**
 * Created by yohoos on 5/14/17.
 */
public interface MovieService {
    Movie findMovieByTitle(String title);
    void saveMovie(Movie movie);
}
