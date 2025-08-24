package com.example.ebankig.service;

import java.util.List;

import com.example.ebankig.model.Operation;

public interface OperationService {
    List<Operation> getAllOperations();
    Operation getOperationById(Long id);
    Operation saveOperation(Operation operation);
    void deleteOperation(Long id);
}
