package com.example.ebankig.service;

import java.util.List;

import com.example.ebankig.dto.VirementDtoAdd;
import com.example.ebankig.dto.VirementsDto;
import com.example.ebankig.model.Virement;

public interface VirementService {
    List<VirementsDto> getAllVirements();
    Virement getVirementById(Long id);
    Virement createVirement(VirementDtoAdd virement); // ← ajouté
    void deleteVirement(Long id);
}
