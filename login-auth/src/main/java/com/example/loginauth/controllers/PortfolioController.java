package com.example.loginauth.controllers;

import com.example.loginauth.auth.SecurityConstants;
import com.example.loginauth.models.User;
import com.example.loginauth.services.UrlService;
import com.example.loginauth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "/login";
    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.GET)
    public String signUp() {
        return "/sign-up";
    }

    @RequestMapping(value = {"/sign-up"}, method = RequestMethod.POST)
    public String signUp(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/login";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String goHome() {
        return "/home";
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String error() {
        return "/error";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        Cookie jwtCookie = null;
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals(SecurityConstants.HEADER_STRING)) {
                jwtCookie = cookie;
            }
        }
        jwtCookie.setMaxAge(0);
        response.addCookie(jwtCookie);
    }

}
