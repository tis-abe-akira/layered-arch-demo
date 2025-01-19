package com.example.layered.model;

import lombok.Data;

@Data
public class LoanRequest {
    private double principal; // 元本
    private double interestRate; // 利率
    private int loanTermMonths; // 返済期間（月）
}
