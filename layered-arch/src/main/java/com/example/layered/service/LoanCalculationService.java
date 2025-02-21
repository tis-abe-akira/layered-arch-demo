package com.example.layered.service;

import org.springframework.stereotype.Service;
import com.example.layered.entity.LoanCalculation;
import com.example.layered.repository.LoanCalculationRepository;
import com.example.layered.model.LoanRequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoanCalculationService {

    private final LoanCalculationRepository repository;

    public LoanCalculation calculateLoan(LoanRequest request) {
        double principal = request.getPrincipal();
        double annualRate = request.getInterestRate() / 100.0;
        double monthlyRate = annualRate / 12.0;
        int months = request.getLoanTermMonths();

        // 毎月の返済額の計算（アモチゼーション計算）
        double monthlyPayment = principal *
                (monthlyRate * Math.pow(1 + monthlyRate, months)) /
                (Math.pow(1 + monthlyRate, months) - 1);

        double totalPayment = monthlyPayment * months;
        double totalInterest = totalPayment - principal;

        LoanCalculation calculation = new LoanCalculation();
        calculation.setPrincipal(principal);
        calculation.setInterestRate(request.getInterestRate());
        calculation.setLoanTermMonths(months);
        calculation.setMonthlyPayment(monthlyPayment);
        calculation.setTotalPayment(totalPayment);
        calculation.setTotalInterest(totalInterest);

        return repository.save(calculation);
    }
}
