package com.example.demo.Person;


import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

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
    private float WithdrawalRate;
    private float GrowthRate;

    public Person() {
    }

    public Person(Long Id,
                  String Email,
                  float WithdrawalRate,
                  float GrowthRate) {
        this.Id = Id;
        this.Email = Email;
        this.WithdrawalRate = WithdrawalRate;
        this.GrowthRate = GrowthRate;
    }

    public Person(String email,
                  float withdrawalRate,
                  float growthRate) {
        Email = email;
        WithdrawalRate = withdrawalRate;
        GrowthRate = growthRate;
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

    public float getWithdrawalRate() {
        return WithdrawalRate;
    }

    public void setWithdrawalRate(float withdrawalRate) {
        WithdrawalRate = withdrawalRate;
    }

    public float getGrowthRate() {
        return GrowthRate;
    }

    public void setGrowthRate(float growthRate) {
        GrowthRate = growthRate;
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
