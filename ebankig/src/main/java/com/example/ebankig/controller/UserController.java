package com.example.ebankig.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ebankig.dto.UserDTO;
import com.example.ebankig.model.User;
import com.example.ebankig.repository.UserRepository;
import com.example.ebankig.service.UserService;

@RestController
@RequestMapping("/api/users")

public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) { this.userService = userService;
    this.userRepository = userRepository; }

    @GetMapping("/all")
    public List<User> getAll() { return userService.getAllUsers(); }

    @GetMapping("/{login}")
    public User getById(@PathVariable String login) { return userService.getUserById(login); }

    @PostMapping("/add")
    public User save(@RequestBody User user) { return userService.saveUser(user); }

    @DeleteMapping("/{login}")
    public void delete(@PathVariable String login) { userService.deleteUser(login); }

   @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginOrRegister(@RequestBody UserDTO userDTO) {
        Map<String, Object> response = new HashMap<>();
        Optional<User> existingUserOpt = userRepository.findByLogin(userDTO.getLogin());
        User user;

        if (existingUserOpt.isPresent()) {
            user = existingUserOpt.get();
            response.put("type", "existing");
        } else {
            user = new User();
            user.setLogin(userDTO.getLogin());
            user.setPassword(userDTO.getPassword());
            user.setComptes(new ArrayList<>());
            user = userRepository.save(user);
            response.put("type", "new");
        }

        response.put("login", user.getLogin());
        return ResponseEntity.ok(response);
    }
}

