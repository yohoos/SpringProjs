package com.project;

import com.project.services.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PortfolioApplication {

    @Autowired
    @Qualifier("urlService")
    private static UrlService urlService;

    public static void main(String[] args) {
        SpringApplication.run(PortfolioApplication.class, args);
    }
}
