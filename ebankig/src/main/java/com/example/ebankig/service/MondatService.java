package com.example.ebankig.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ebankig.dto.MondatDTO;
import com.example.ebankig.model.Mondat;
import com.example.ebankig.repository.MondatRepository;

@Service
public class MondatService {

    @Autowired
    private MondatRepository mondatRepository;

    public MondatDTO envoyerMondat(MondatDTO dto) {
        Mondat mondat = new Mondat();
        mondat.setCompteDestinataire(dto.getCompteDestinataire());
        mondat.setMontant(dto.getMontant());

        // Générer code aléatoire 4 chiffres
        int code = 1000 + new Random().nextInt(9000);
        mondat.setCodeRetrait(code);

        mondat = mondatRepository.save(mondat);

        // Retour DTO
        MondatDTO result = new MondatDTO();
        result.setId(mondat.getId());
        result.setCompteDestinataire(mondat.getCompteDestinataire());
        result.setMontant(mondat.getMontant());
        result.setCodeRetrait(mondat.getCodeRetrait());

        return result;
    }
}
