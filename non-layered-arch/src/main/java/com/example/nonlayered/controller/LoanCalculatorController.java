package com.example.nonlayered.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import lombok.Data;

@Controller
public class LoanCalculatorController {

    // 内部クラスとしてリクエストデータを定義
    @Data
    public static class LoanResult {
        private double principal;
        private double interestRate;
        private int loanTermMonths;
        private double monthlyPayment;
        private double totalPayment;
        private double totalInterest;
    }

    @GetMapping("/")
    public String showCalculator() {
        return "calculator";
    }

    @PostMapping("/calculate")
    public String calculate(
            @RequestParam("principal") double principal,
            @RequestParam("interestRate") double interestRate,
            @RequestParam("loanTermMonths") int loanTermMonths,
            Model model) {

        // ビジネスロジックを直接コントローラーに実装
        double annualRate = interestRate / 100.0;
        double monthlyRate = annualRate / 12.0;

        // 毎月の返済額の計算（アモチゼーション計算）
        double monthlyPayment = principal *
                (monthlyRate * Math.pow(1 + monthlyRate, loanTermMonths)) /
                (Math.pow(1 + monthlyRate, loanTermMonths) - 1);

        double totalPayment = monthlyPayment * loanTermMonths;
        double totalInterest = totalPayment - principal;

        // 結果オブジェクトを作成して値を設定
        LoanResult result = new LoanResult();
        result.setPrincipal(principal);
        result.setInterestRate(interestRate);
        result.setLoanTermMonths(loanTermMonths);
        result.setMonthlyPayment(monthlyPayment);
        result.setTotalPayment(totalPayment);
        result.setTotalInterest(totalInterest);

        model.addAttribute("result", result);
        return "result";
    }
}
