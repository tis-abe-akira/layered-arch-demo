package com.example.layered.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class LoanCalculation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double principal; // 元本
    private double interestRate; // 利率
    private int loanTermMonths; // 返済期間（月）
    private double monthlyPayment; // 毎月の返済額
    private double totalPayment; // 総返済額
    private double totalInterest; // 総利息
}
