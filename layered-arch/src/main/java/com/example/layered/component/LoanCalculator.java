package com.example.layered.component;

import org.springframework.stereotype.Component;
import com.example.layered.entity.LoanCalculation;
import com.example.layered.model.LoanRequest;

@Component
public class LoanCalculator {

    public LoanCalculation calculate(LoanRequest request) {
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
        calculation.setMonthlyPayment(Math.round(monthlyPayment));
        calculation.setTotalPayment(Math.round(totalPayment));
        calculation.setTotalInterest(Math.round(totalInterest));

        return calculation;
    }
}
