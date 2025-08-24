package com.example.ebankig.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ebankig.model.Compte;
import com.example.ebankig.repository.CompteRepository;

@Service
public class CompteServiceImpl implements CompteService {
    private final CompteRepository compteRepository;

    public CompteServiceImpl(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }

    @Override
    public List<Compte> getAllComptes() { return compteRepository.findAll(); }

    @Override
    public Compte getCompteById(String numCompte) { return compteRepository.findById(numCompte).orElse(null); }

    @Override
    public Compte saveCompte(Compte compte) { return compteRepository.save(compte); }

    @Override
    public void deleteCompte(String numCompte) { compteRepository.deleteById(numCompte); }
}
