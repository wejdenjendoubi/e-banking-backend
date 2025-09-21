package com.example.ebankig.service;

import java.util.List;

import com.example.ebankig.model.Compte;

public interface CompteService {
    List<Compte> getAllComptes();
    Compte getCompteById(String numCompte);
    Compte saveCompte(Compte compte);
    void deleteCompte(String numCompte);
    List<Compte> getComptesByUserLogin(String login);
}
