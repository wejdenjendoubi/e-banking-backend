package com.example.ebankig.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ebankig.model.User;

public interface UserRepository extends JpaRepository<User, String> {
}
