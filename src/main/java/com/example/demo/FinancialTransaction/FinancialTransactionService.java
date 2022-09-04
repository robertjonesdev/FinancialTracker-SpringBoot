package com.example.demo.FinancialTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FinancialTransactionService {

    private final FinancialTransactionRepository repository;

    @Autowired
    public FinancialTransactionService(FinancialTransactionRepository repository) {
        this.repository = repository;
    }
    public List<FinancialTransaction> getTransactions() {
        return repository.findAll();
    }
}
