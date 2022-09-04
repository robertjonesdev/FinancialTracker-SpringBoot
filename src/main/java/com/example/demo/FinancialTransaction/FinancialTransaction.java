package com.example.demo.FinancialTransaction;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import java.time.LocalDate;
@Entity
@Table
public class FinancialTransaction {
    @Id
    @SequenceGenerator(
            name = "transaction_sequence",
            sequenceName = "transaction_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "transaction_sequence"
    )
    private Long Id;
    private LocalDate Month;
    private Long NetWorth;
    private Long Savings;
    private Long Expenses;

    private Long PersonId;
    public FinancialTransaction() {
    }

    public FinancialTransaction(Long id, LocalDate month, Long netWorth, Long savings, Long expenses, Long personId) {
        Id = id;
        Month = month;
        NetWorth = netWorth;
        Savings = savings;
        Expenses = expenses;
        PersonId = personId;
    }

    public FinancialTransaction(LocalDate month, Long netWorth, Long savings, Long expenses, Long personId) {
        Month = month;
        NetWorth = netWorth;
        Savings = savings;
        Expenses = expenses;
        PersonId = personId;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public LocalDate getMonth() {
        return Month;
    }

    public void setMonth(LocalDate month) {
        Month = month;
    }

    public Long getNetWorth() {
        return NetWorth;
    }

    public void setNetWorth(Long netWorth) {
        NetWorth = netWorth;
    }

    public Long getSavings() {
        return Savings;
    }

    public void setSavings(Long savings) {
        Savings = savings;
    }

    public Long getExpenses() {
        return Expenses;
    }

    public void setExpenses(Long expenses) {
        Expenses = expenses;
    }

    public Long getPersonId() {
        return PersonId;
    }

    public void setPersonId(Long personId) {
        PersonId = personId;
    }

    @Override
    public String toString() {
        return "FinancialTransaction{" +
                "Id=" + Id +
                ", Month=" + Month +
                ", NetWorth=" + NetWorth +
                ", Savings=" + Savings +
                ", Expenses=" + Expenses +
                ", PersonId=" + PersonId +
                '}';
    }
}
