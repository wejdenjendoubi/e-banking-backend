package com.example.ebankig.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ebankig.model.Compte;

public interface CompteRepository extends JpaRepository<Compte, String> {
     Optional<Compte> findByNumCompte(String numCompte);
}
