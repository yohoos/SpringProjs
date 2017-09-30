package com.example.loginauth.services.impl;

/**
 * Created by yohoos on 5/13/17.
 */

import com.example.loginauth.models.Role;
import com.example.loginauth.models.User;
import com.example.loginauth.repository.RoleRepository;
import com.example.loginauth.repository.UserRepository;
import com.example.loginauth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            System.out.println("User Already Exists");
            return;
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        userRepository.save(user);
    }
}