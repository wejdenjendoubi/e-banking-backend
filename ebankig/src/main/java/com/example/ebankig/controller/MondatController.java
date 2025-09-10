
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

@RestController
@RequestMapping("/api/mondats")
@CrossOrigin(origins = "http://localhost:4200")
public class MondatController {

    @Autowired
    private MondatService mondatService;

    @PostMapping("/envoyer")
    public ResponseEntity<MondatDTO> envoyerMondat(@RequestBody MondatDTO dto) {
        MondatDTO result = mondatService.envoyerMondat(dto);
        return ResponseEntity.ok(result);
    }
}
