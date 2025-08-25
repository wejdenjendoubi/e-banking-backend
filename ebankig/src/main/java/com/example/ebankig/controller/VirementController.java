package com.example.ebankig.controller;

import java.io.Serializable;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ebankig.dto.VirementDtoAdd;
import com.example.ebankig.model.Virement;
import com.example.ebankig.service.VirementService;

@RestController
@RequestMapping("/api/virements")
@CrossOrigin(origins = "http://localhost:4200",  allowedHeaders = "*")
public class VirementController implements Serializable{



    private final VirementService virementService;

    public VirementController(VirementService virementService) {
        this.virementService = virementService;
    }
    @GetMapping("/test")
    public String test() {
        return "API is working!";
    }
    @GetMapping("all")
   public ResponseEntity<?> getAllVirements() {
        return ResponseEntity.ok(virementService.getAllVirements());
    }

   @PostMapping("add")
    public ResponseEntity<?> createVirement(@RequestBody VirementDtoAdd virementDto) {
        Virement saved = virementService.createVirement(virementDto);
    return ResponseEntity.ok(saved);
    }
}
