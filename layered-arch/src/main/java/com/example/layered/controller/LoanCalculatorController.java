package com.example.layered.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.layered.entity.LoanCalculation;
import com.example.layered.model.LoanRequest;
import com.example.layered.service.LoanCalculationService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoanCalculatorController {

    private final LoanCalculationService service;

    @GetMapping("/")
    public String showCalculator(Model model) {
        model.addAttribute("loanRequest", new LoanRequest());
        return "calculator";
    }

    @PostMapping("/calculate")
    public String calculate(@ModelAttribute LoanRequest loanRequest, Model model) {
        LoanCalculation result = service.calculateLoan(loanRequest);
        model.addAttribute("result", result);
        return "result";
    }
}
