package com.example.demo.Person;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PersonConfig {
    @Bean
    CommandLineRunner pCommandLineRunner(PersonRepository repository) {
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

            repository.saveAll(
                    List.of(robert, user)
            );
        };
    }
}
