package com.example.demo.FinancialTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    public List<FinancialTransaction> getTransactionsByPersonId(Long personId) {
        return repository.selectTransactionByPersonId(personId);
    }

    public void addNewTransaction(FinancialTransaction transaction) {
        Optional<FinancialTransaction> transactionOptional = repository.findByMonth(transaction.getMonth());

        if(transactionOptional.isPresent()) {
            throw new IllegalStateException("Transaction for this month already exists.");
        }

        /* TODO: check if month is valid? */

        repository.save(transaction);
    }

    public void deleteTransaction(Long transactionId) {
        boolean exists = repository.existsById(transactionId);
        if (!exists) {
            throw new IllegalStateException("transaction with id " + transactionId + " does not exist");
        }
        repository.deleteById(transactionId);

    }

    @Transactional
    public void updateTransaction(Long transactionId,
                             LocalDate Month,
                             Long NetWorth,
                             Long Savings,
                             Long Expenses) {
        FinancialTransaction transaction = repository.findById(transactionId)
                .orElseThrow(() -> new IllegalStateException(
                        "transaction with id " + transactionId + " does not exist"
                ));

        if (Month == null) {
            throw new IllegalStateException("Month required");
        }
        if (NetWorth != null & NetWorth > 0) {
            transaction.setNetWorth(NetWorth);
        }
        if (Savings != null && Savings > 0) {
            transaction.setSavings(Savings);
        }
        if (Expenses != null && Expenses > 0) {
            transaction.setExpenses(Expenses);
        }
    }
}
