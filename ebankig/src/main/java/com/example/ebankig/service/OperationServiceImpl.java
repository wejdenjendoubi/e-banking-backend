package com.example.ebankig.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ebankig.model.Operation;
import com.example.ebankig.repository.OperationRepository;

@Service
public class OperationServiceImpl implements OperationService {
    private final OperationRepository operationRepository;

    public OperationServiceImpl(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    @Override
    public List<Operation> getAllOperations() { return operationRepository.findAll(); }

    @Override
    public Operation getOperationById(Long id) { return operationRepository.findById(id).orElse(null); }

    @Override
    public Operation saveOperation(Operation operation) { return operationRepository.save(operation); }

    @Override
    public void deleteOperation(Long id) { operationRepository.deleteById(id); }
}
