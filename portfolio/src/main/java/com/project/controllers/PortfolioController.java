package com.project.controllers;

import com.project.models.Url;
import com.project.models.UrlCounts;
import com.project.models.User;
import com.project.services.UrlService;
import com.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.util.List;

/**
 * Created by yohoos on 6/2/17.
 */
@Controller
public class PortfolioController {

    @Autowired
    @Qualifier("urlService")
    private UrlService urlService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String home() {
        return "/client/index";
    }

    @RequestMapping(value = {"/urls"}, method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Url> getUrls() {
        return urlService.findAll();
    }

    @RequestMapping(value = {"/url_counts"}, method = RequestMethod.GET)
    @ResponseBody
    public List<UrlCounts> getCounts() throws MalformedURLException {
        return urlService.getCounts();
    }

    @RequestMapping(value = {"/sign-up"}, method = RequestMethod.POST)
    public void signUp(@RequestBody String form) {
//        userService.signUp(user);
        System.out.println(form);
    }

}
