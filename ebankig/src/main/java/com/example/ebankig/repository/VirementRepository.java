package com.example.ebankig.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ebankig.model.Virement;

public interface VirementRepository extends JpaRepository<Virement, Long> { }
