package com.example.demo.FinancialTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/transaction")
public class FinancialTransactionController {

    private final FinancialTransactionService transactionService;

    @Autowired
    public FinancialTransactionController(FinancialTransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<FinancialTransaction> getTransactions() {
        return transactionService.getTransactions();
    }
}
