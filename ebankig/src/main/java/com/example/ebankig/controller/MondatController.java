
package com.example.ebankig.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ebankig.dto.MondatDTO;
import com.example.ebankig.service.MondatService;
import com.example.ebankig.model.Compte;
import com.example.ebankig.model.Mondat;
import com.example.ebankig.service.CompteService;
import com.example.ebankig.service.MondatService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.server.ResponseStatusException;
import java.util.Random;

@RestController
@RequestMapping("/api/mondats")
@CrossOrigin(origins = "http://localhost:4200")
public class MondatController {

    @Autowired
    private MondatService mondatService;

    @Autowired
    private CompteService compteService;

    @PostMapping("/envoyer")
    public Mondat envoyerMondat(@RequestBody Mondat mondat) {
        // Validate that the account number is provided
        if (mondat.getNumCompte() == null || mondat.getNumCompte().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Compte manquant !");
        }

        // Retrieve the Compte entity from the database
        Compte compte = compteService.getCompteById(mondat.getNumCompte());
        if (compte == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Compte non trouvé !");
        }

        // Set the retrieved compte entity and generate a random codeRetrait
        mondat.setCompte(compte);
        mondat.setCodeRetrait(new Random().nextInt(9000) + 1000);

        // Save the mondat
        return mondatService.saveMondat(mondat);
    }

}
