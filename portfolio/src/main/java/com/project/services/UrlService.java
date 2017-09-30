package com.project.services;

import com.project.models.Url;
import com.project.models.UrlCounts;

import java.net.MalformedURLException;
import java.util.List;

public interface UrlService {

    Url findUrlById(Integer id);

    List<Url> findAll();

    List<UrlCounts> getCounts() throws MalformedURLException;
}
