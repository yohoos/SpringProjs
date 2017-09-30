package com.practice.repository;

import com.practice.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by yohoos on 5/14/17.
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Movie findMovieByTitle(String title);
}
