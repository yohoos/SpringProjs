package com.practice.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by yohoos on 5/14/17.
 */
@Entity
public class Movie {

    @Id
    private int movie_id;

    @NotNull
    private String title;

    @NotNull
    private String genres;

    public Movie() {

    }

    public Movie(int movie_id, String title, String genres) {
        this.movie_id = movie_id;
        this.title = title;
        this.genres = genres;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }
}
