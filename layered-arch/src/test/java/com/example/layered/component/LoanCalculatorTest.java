package com.example.layered.component;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import com.example.layered.entity.LoanCalculation;
import com.example.layered.model.LoanRequest;

public class LoanCalculatorTest {

    private final LoanCalculator loanCalculator = new LoanCalculator();

    @Test
    public void testCalculate() {
        LoanRequest request = new LoanRequest();
        request.setPrincipal(100000);
        request.setInterestRate(5);
        request.setLoanTermMonths(60);

        LoanCalculation calculation = loanCalculator.calculate(request);

        assertThat(calculation.getPrincipal()).isEqualTo(100000);
        assertThat(calculation.getInterestRate()).isEqualTo(5);
        assertThat(calculation.getLoanTermMonths()).isEqualTo(60);
        assertThat(calculation.getMonthlyPayment()).isEqualTo(1887);
        assertThat(calculation.getTotalPayment()).isEqualTo(113227);
        assertThat(calculation.getTotalInterest()).isEqualTo(13227);
    }
}
