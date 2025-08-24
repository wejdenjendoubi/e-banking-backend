package com.example.ebankig.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ebankig.model.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long> {
}
