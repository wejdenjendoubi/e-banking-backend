package com.example.ebankig.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ebankig.model.Operation;
import com.example.ebankig.model.Compte;
import com.example.ebankig.service.OperationService;
import com.example.ebankig.service.CompteService;

@RestController
@RequestMapping("/api/operations")
@CrossOrigin(origins = "*")
public class OperationController {

    private final OperationService service;
    private final CompteService compteService; // service pour récupérer les comptes existants

    public OperationController(OperationService service, CompteService compteService) {
        this.service = service;
        this.compteService = compteService;
    }

    // Récupérer les opérations par compte (ici on filtre par type de compte ou numéro)
    @GetMapping("/byid/{compte}")
    public List<Operation> getByCompte(@PathVariable String compte) {
        return service.getAllOperations()
                      .stream()
                      .filter(op -> op.getCompte() != null &&
                            (compte.equalsIgnoreCase(op.getCompte().getType()) || 
                             compte.equals(op.getCompte().getNumCompte())))
                      .collect(Collectors.toList());
    }

    // Ajouter une nouvelle opération
    @PostMapping
    public Operation createOperation(@RequestBody Operation operation) {
        // Récupérer le compte lié à l’opération
        Compte compte = compteService.getCompteByNumOrType(
                            operation.getCompte().getNumCompte(), 
                            operation.getCompte().getType());
        if (compte == null) {
            throw new RuntimeException("Compte non trouvé !");
        }
        operation.setCompte(compte);
        return service.saveOperation(operation);
    }
}
