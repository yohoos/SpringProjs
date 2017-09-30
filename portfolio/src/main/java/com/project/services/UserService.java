package com.project.services;

import com.project.models.User;

/**
 * Created by yohoos on 5/12/17.
 */
public interface UserService {

    User findUserByEmail(String email);

    void saveUser(User user);

    void signUp(User user);
}
