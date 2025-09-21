package com.example.ebankig.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ebankig.model.Compte;

public interface CompteRepository extends JpaRepository<Compte, String> {
     Optional<Compte> findByNumCompte(String numCompte);
     List<Compte> findByUser_Login(String login);
}
