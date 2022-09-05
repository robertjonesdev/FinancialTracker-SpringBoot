package com.example.demo.FinancialTransaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface FinancialTransactionRepository
        extends JpaRepository<FinancialTransaction, Long> {

    @Query(value = "Select t.* FROM financial_transaction t WHERE t.person_id = ?1", nativeQuery = true)
    List<FinancialTransaction> selectTransactionByPersonId(Long personId);

    @Query("SELECT t FROM FinancialTransaction t WHERE t.Month = ?1")
    Optional<FinancialTransaction> findByMonth(LocalDate month);
}
