package com.example.ebankig.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.ebankig.dto.VirementDtoAdd;
import com.example.ebankig.dto.VirementsDto;
import com.example.ebankig.model.Compte;
import com.example.ebankig.model.Virement;
import com.example.ebankig.repository.CompteRepository;
import com.example.ebankig.repository.VirementRepository;

@Service
public class VirementServiceImpl implements VirementService {

    private final ModelMapper modelMapper = new ModelMapper();

    private final VirementRepository virementRepository;
    private final CompteRepository compteRepository;

    public VirementServiceImpl(VirementRepository virementRepository, CompteRepository compteRepository) {
        this.virementRepository = virementRepository;
        this.compteRepository = compteRepository;
    }

    @Override
    public List<VirementsDto> getAllVirements() {

    List<Virement> virements = virementRepository.findAll() ;

    List<VirementsDto> virementsDto = virements.stream()
        .map(v -> modelMapper.map(v, VirementsDto.class)) 
        .collect(Collectors.toList());

        return virementsDto ;
    }

    @Override
    public Virement getVirementById(Long id) {
        return virementRepository.findById(id).orElse(null);
    }
@Override
public Virement createVirement(VirementDtoAdd virementDto) {
    // Vérifier si le compte source existe sinon le créer
    Compte source = compteRepository.findByNumCompte(virementDto.getCompteSource())
            .orElseGet(() -> {
                Compte newCompte = new Compte();
                newCompte.setNumCompte(virementDto.getCompteSource()); 
                return compteRepository.save(newCompte);
            });

    // Vérifier si le compte bénéficiaire existe sinon le créer
    Compte beneficiaire = compteRepository.findByNumCompte(virementDto.getCompteDestination())
            .orElseGet(() -> {
                Compte newCompte = new Compte();
                newCompte.setNumCompte(virementDto.getCompteDestination()); // <-- corrige ici
                return compteRepository.save(newCompte);
            });

    // Créer le virement
    Virement virement = new Virement();
    virement.setMotif(virementDto.getMotif());
    virement.setMontant(virementDto.getMontant());
    virement.setCompteSource(source);
    virement.setCompteBeneficiaire(beneficiaire);

    return virementRepository.save(virement);
}


    @Override
    public void deleteVirement(Long id) {
        virementRepository.deleteById(id);
    }
}
