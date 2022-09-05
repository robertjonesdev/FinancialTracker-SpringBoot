package com.example.demo.FinancialTransaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface FinancialTransactionRepository
        extends JpaRepository<FinancialTransaction, Long> {

    @Query("SELECT t FROM FinancialTransaction t WHERE t.Month = ?1 AND t.PersonId = ?2")
    Optional<FinancialTransaction> findByMonth(LocalDate month, Long personId);
}
