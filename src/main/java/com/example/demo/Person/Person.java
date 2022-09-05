package com.example.demo.Person;


import com.example.demo.FinancialTransaction.FinancialTransaction;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Person {
    @Id
    @SequenceGenerator(
            name = "person_sequence",
            sequenceName = "person_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "person_sequence"
    )
    private Long Id;
    private String Email;
    private Float WithdrawalRate;
    private Float GrowthRate;

    @JsonIgnore
    @OneToMany(
            mappedBy = "Person",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<FinancialTransaction> transactions= new ArrayList<>();


    public Person() {
    }

    public Person(Long Id,
                  String Email,
                  Float WithdrawalRate,
                  Float GrowthRate) {
        this.Id = Id;
        this.Email = Email;
        if (WithdrawalRate == null || WithdrawalRate > 0f) {
            this.WithdrawalRate = WithdrawalRate;
        } else {
            this.WithdrawalRate = 4.0f;
        }
        if (GrowthRate == null || GrowthRate > 0f) {
            this.GrowthRate = GrowthRate;
        } else {
            this.GrowthRate = 7.0f;
        }
    }

    public Person(String email,
                  Float withdrawalRate,
                  Float growthRate) {
        this.Email = email;
        if (withdrawalRate == null || withdrawalRate > 0f) {
            this.WithdrawalRate = withdrawalRate;
        } else {
            this.WithdrawalRate = 4.0f;
        }
        if (growthRate == null || growthRate > 0f) {
            this.GrowthRate = growthRate;
        } else {
            this.GrowthRate = 7.0f;
        }
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Float getWithdrawalRate() {
        return WithdrawalRate;
    }

    public void setWithdrawalRate(Float withdrawalRate) {
        if (withdrawalRate > 0f) {
            WithdrawalRate = withdrawalRate;
        } else {
            WithdrawalRate = 4.0f;
        }
    }

    public Float getGrowthRate() {
        return GrowthRate;
    }

    public void setGrowthRate(Float growthRate) {
        if (growthRate > 0f) {
            GrowthRate = growthRate;
        } else {
            GrowthRate = 7.0f;
        }
    }

    public List<FinancialTransaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(FinancialTransaction transaction) {
        if (!this.transactions.contains(transaction)) {
            this.transactions.add(transaction);
            transaction.setPerson(this);
        }
    }

    public void removeTransaction(FinancialTransaction transaction) {
        if (this.transactions.contains(transaction)) {
            this.transactions.remove(transaction);
            transaction.setPerson(null);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "Id=" + Id +
                ", Email='" + Email + '\'' +
                ", WithdrawalRate=" + WithdrawalRate +
                ", GrowthRate=" + GrowthRate +
                '}';
    }
}
