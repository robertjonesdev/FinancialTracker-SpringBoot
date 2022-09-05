package com.example.demo.FinancialTransaction;

import com.example.demo.Person.Person;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="person_id",
            referencedColumnName="id",
            foreignKey = @ForeignKey(
                    name = "person_transaction_fk"
            )
    )
    private Person Person;

    public FinancialTransaction() {

    }

    public FinancialTransaction(LocalDate month,
                                Long netWorth,
                                Long savings,
                                Long expenses) {
        Month = month;
        NetWorth = netWorth;
        Savings = savings;
        Expenses = expenses;
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

    public void setPerson(Person person) {
        Person = person;
    }

    public Person getPerson() {
        return Person;
    }
    public Long getPersonId() {
        return Person.getId();
    }

    @Override
    public String toString() {
        return "FinancialTransaction{" +
                "Id=" + Id +
                ", Month=" + Month +
                ", NetWorth=" + NetWorth +
                ", Savings=" + Savings +
                ", Expenses=" + Expenses +
                ", Person=" + Person +
                '}';
    }
}
