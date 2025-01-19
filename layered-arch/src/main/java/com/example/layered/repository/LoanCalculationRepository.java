package com.example.layered.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.layered.entity.LoanCalculation;

@Repository
public interface LoanCalculationRepository extends JpaRepository<LoanCalculation, Long> {
}
