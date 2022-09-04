package com.example.demo.FinancialTransaction;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class FinancialTransactionConfig {
    @Bean
    CommandLineRunner ftCommandLineRunner(FinancialTransactionRepository repository) {
        return args -> {
            FinancialTransaction august2022 = new FinancialTransaction(
                LocalDate.of(2022, Month.AUGUST, 1),
                102000L,
                2000L,
                3000L,
                1L
            );

            FinancialTransaction july2022 = new FinancialTransaction(
                    LocalDate.of(2022, Month.JULY, 1),
                    100000L,
                    2100L,
                    2900L,
                    1L
            );

            repository.saveAll(
                    List.of(august2022, july2022)
            );
        };
    }
}
