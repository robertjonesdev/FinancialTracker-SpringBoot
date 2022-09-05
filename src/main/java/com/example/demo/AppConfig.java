package com.example.demo;

import com.example.demo.FinancialTransaction.FinancialTransaction;
import com.example.demo.FinancialTransaction.FinancialTransactionRepository;
import com.example.demo.Person.Person;
import com.example.demo.Person.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class AppConfig {
    @Bean
    CommandLineRunner CommandLineRunner(PersonRepository personRepository, FinancialTransactionRepository transactionRepository) {
        return args -> {

            Person robert = new Person(
                    "robert@robertjones.dev",
                    4.0f,
                    7.0f
            );

            Person user = new Person(
                    "user@user.com",
                    4.0f,
                    7.0f
            );

            personRepository.saveAll(
                    List.of(robert, user)
            );

            FinancialTransaction august2022 = new FinancialTransaction(
                    LocalDate.of(2022, Month.AUGUST, 1),
                    102000L,
                    2000L,
                    3000L
            );

            FinancialTransaction july2022 = new FinancialTransaction(
                    LocalDate.of(2022, Month.JULY, 1),
                    100000L,
                    2100L,
                    2900L
            );


            august2022.setPerson(robert);
            july2022.setPerson(robert);


            robert.addTransaction(august2022);
            robert.addTransaction(july2022);

            transactionRepository.saveAll(
                    List.of(august2022, july2022)
            );
            personRepository.saveAll(
                    List.of(robert, user)
            );

        };
    }
}
