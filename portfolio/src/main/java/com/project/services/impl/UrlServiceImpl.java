package com.project.services.impl;

import com.project.models.Url;
import com.project.models.UrlCounts;
import com.project.repository.UrlRespository;
import com.project.services.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

@Service("urlService")
public class UrlServiceImpl implements UrlService {

    @Autowired
    private UrlRespository urlRespository;

    @Override
    public Url findUrlById(Integer id) {
        return urlRespository.findUrlsById(id);
    }

    @Override
    public List<Url> findAll() {
        return urlRespository.findAll();
    }

    public List<UrlCounts> getCounts() throws MalformedURLException {
        HashMap<String, UrlCounts> result = new HashMap<>();
        for (Url x : findAll()) {
            URL url = new URL(x.getUrl());
            if (!result.containsKey(url.getHost())) {
                UrlCounts counts = new UrlCounts(url.getHost(), x.getVisitCount(), x.getTypedCount());
                result.put(url.getHost(), counts);
            } else {
                UrlCounts counts = result.get(url.getHost());
                counts.typed_counts += x.getTypedCount();
                counts.visit_counts += x.getVisitCount();
                result.put(url.getHost(), counts);
            }
        }
        List<UrlCounts> finalResult = new ArrayList<>(result.values());
        Collections.sort(finalResult);
        return finalResult;
    }
}
