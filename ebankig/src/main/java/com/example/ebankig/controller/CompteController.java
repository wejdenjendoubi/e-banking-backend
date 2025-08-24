package com.example.ebankig.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ebankig.model.Compte;
import com.example.ebankig.service.CompteService;

@RestController
@RequestMapping("/api/comptes")
@CrossOrigin(origins = "http://localhost:4200")
public class CompteController {

    private final CompteService compteService;

    public CompteController(CompteService compteService) {
        this.compteService = compteService;
    }

    @GetMapping("all")
    public List<Compte> getAllComptes() {
        return compteService.getAllComptes();
    }

    @GetMapping("/{id}")
    public Compte getCompte(@PathVariable String id) {
        return compteService.getCompteById(id);
    }

    @PostMapping("add")
    public Compte createCompte(@RequestBody Compte compte) {
        return compteService.saveCompte(compte);
    }

    @DeleteMapping("/{id}")
    public void deleteCompte(@PathVariable String id) {
        compteService.deleteCompte(id);
    }
}
