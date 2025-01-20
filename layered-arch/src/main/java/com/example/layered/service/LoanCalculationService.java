package com.example.layered.service;

import org.springframework.stereotype.Service;
import com.example.layered.entity.LoanCalculation;
import com.example.layered.repository.LoanCalculationRepository;
import com.example.layered.model.LoanRequest;
import lombok.RequiredArgsConstructor;
import com.example.layered.component.LoanCalculator;

@Service
@RequiredArgsConstructor
public class LoanCalculationService {

    private final LoanCalculationRepository repository;
    private final LoanCalculator loanCalculator;

    public LoanCalculation calculateLoan(LoanRequest request) {
        LoanCalculation calculation = loanCalculator.calculate(request);
        return repository.save(calculation);
    }
}
