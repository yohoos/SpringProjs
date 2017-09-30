package com.example.loginauth.services;

import com.example.loginauth.models.Url;
import com.example.loginauth.models.UrlCounts;

import java.net.MalformedURLException;
import java.util.List;

public interface UrlService {

    Url findUrlById(Integer id);

    List<Url> findAll();

    List<UrlCounts> getCounts() throws MalformedURLException;
}
