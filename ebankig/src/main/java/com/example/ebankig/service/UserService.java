package com.example.ebankig.service;

import java.util.List;

import com.example.ebankig.model.User;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(String login);
    User saveUser(User user);
    void deleteUser(String login);
    User loginOrRegister(User user);
}


