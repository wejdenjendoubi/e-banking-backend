package com.example.ebankig.service;

import com.example.ebankig.model.Mondat;
import com.example.ebankig.dto.MondatDTO;
import com.example.ebankig.repository.MondatRepository;
import com.example.ebankig.service.MondatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class MondatServiceImpl implements MondatService {

    @Autowired
    private MondatRepository mondatRepository;

    @Override
    public Mondat saveMondat(Mondat mondat) {
        return mondatRepository.save(mondat);
    }
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
