package com.example.ebankig.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ebankig.model.Mondat;

@Repository
public interface MondatRepository extends JpaRepository<Mondat, Long> {
}
