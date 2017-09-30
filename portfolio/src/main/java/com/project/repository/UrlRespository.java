package com.project.repository;

import com.project.models.Url;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRespository extends JpaRepository<Url, Integer> {

    Url findUrlsById(Integer id);
}
