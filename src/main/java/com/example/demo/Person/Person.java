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
        if (WithdrawalRate > 0f) {
            this.WithdrawalRate = WithdrawalRate;
        } else {
            this.WithdrawalRate = 4.0f;
        }
        if (GrowthRate > 0f) {
            this.GrowthRate = GrowthRate;
        } else {
            this.GrowthRate = 7.0f;
        }
    }

    public Person(String email,
                  float withdrawalRate,
                  float growthRate) {
        this.Email = email;
        if (WithdrawalRate > 0f) {
            this.WithdrawalRate = WithdrawalRate;
        } else {
            this.WithdrawalRate = 4.0f;
        }
        if (GrowthRate > 0f) {
            this.GrowthRate = GrowthRate;
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

    public float getWithdrawalRate() {
        return WithdrawalRate;
    }

    public void setWithdrawalRate(float withdrawalRate) {
        if (withdrawalRate > 0f) {
            WithdrawalRate = withdrawalRate;
        } else {
            WithdrawalRate = 4.0f;
        }
    }

    public float getGrowthRate() {
        return GrowthRate;
    }

    public void setGrowthRate(float growthRate) {
        if (growthRate > 0f) {
            GrowthRate = growthRate;
        } else {
            GrowthRate = 7.0f;
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
