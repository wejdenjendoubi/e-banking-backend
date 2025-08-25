package com.example.ebankig.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ebankig.model.User;
import com.example.ebankig.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User loginOrRegister(User user) {
        return userRepository.findByLogin(user.getLogin())
                .orElseGet(() -> userRepository.save(user));
    }
    @Override
    public List<User> getAllUsers() { return userRepository.findAll(); }

    @Override
    public User getUserById(String login) { return userRepository.findById(login).orElse(null); }

    @Override
    public User saveUser(User user) { return userRepository.save(user); }

    @Override
    public void deleteUser(String login) { userRepository.deleteById(login); }
}
