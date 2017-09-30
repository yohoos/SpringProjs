package com.example.loginauth.services;

import com.example.loginauth.models.User;

/**
 * Created by yohoos on 5/12/17.
 */
public interface UserService {

    User findUserByEmail(String email);

    void saveUser(User user);

//    void signUp(User user);
}
