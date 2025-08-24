package com.example.ebankig.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ebankig.model.Operation;
import com.example.ebankig.service.OperationService;

@RestController
@RequestMapping("/api/operations")
@CrossOrigin(origins = "*") 

public class OperationController {
    private final OperationService service;

    public OperationController(OperationService service) {
        this.service = service;
    }

    @GetMapping("/byid/{compte}")
    public List<Operation> getByCompte(@PathVariable String compte) {
        return null;
    }
}
