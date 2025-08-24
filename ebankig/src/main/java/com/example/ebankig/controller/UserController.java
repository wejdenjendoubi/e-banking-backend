package com.example.ebankig.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ebankig.model.User;
import com.example.ebankig.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200",  allowedHeaders = "*")

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) { this.userService = userService; }

    @GetMapping ("all")
        public List<User> getAll() { return userService.getAllUsers(); }

    @GetMapping
        ("/{login}") public User getById(@PathVariable String login) { return userService.getUserById(login); }

    @PostMapping("add")
         public User save(@RequestBody User user) { return userService.saveUser(user); }

    @DeleteMapping
        ("/{login}") public void delete(@PathVariable String login) { userService.deleteUser(login); }
}
