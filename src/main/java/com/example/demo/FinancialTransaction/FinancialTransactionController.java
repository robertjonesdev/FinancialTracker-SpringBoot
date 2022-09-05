package com.example.demo.FinancialTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @PostMapping
    public void registerNewFinancialTransaction(@RequestBody FinancialTransaction transaction) {
        transactionService.addNewTransaction(transaction);
    }
    @DeleteMapping(path = "{transactionId}")
    public void deletePerson(@PathVariable("transactionId") Long transactionId) {
        transactionService.deleteTransaction(transactionId);
    }

    @PutMapping(path = "{transactionId}")
    public void updateTransaction (
            @PathVariable("transactionId") Long transactionId,
            @RequestParam(required = true)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate month,
            @RequestParam(required = false) Long netWorth,
            @RequestParam(required = false) Long savings,
            @RequestParam(required = false) Long expenses) {
        transactionService.updateTransaction(transactionId, month, netWorth, savings, expenses);
    }
}
