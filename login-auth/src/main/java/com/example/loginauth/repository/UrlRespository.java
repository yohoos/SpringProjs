package com.example.loginauth.repository;

import com.example.loginauth.models.Url;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRespository extends JpaRepository<Url, Integer> {

    Url findUrlsById(Integer id);
}
