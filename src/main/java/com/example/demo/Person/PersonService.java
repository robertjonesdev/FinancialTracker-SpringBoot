package com.example.demo.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersons() {
            return personRepository.findAll();
    }

    public void addNewPerson(Person person) {
        Optional<Person> personOptional = personRepository.findPersonByEmail(person.getEmail());

        if(personOptional.isPresent()) {
            throw new IllegalStateException("email address already registered");
        }

        /* TODO: check if email is valid */

        personRepository.save(person);
    }

    public void deletePerson(Long personId) {

        boolean exists = personRepository.existsById(personId);
        if (!exists) {
            throw new IllegalStateException("person with id " + personId + " does not exist");
        }
        personRepository.deleteById(personId);

    }

    @Transactional
    public void updatePerson(Long personId,
                             String email,
                             Float WithdrawalRate,
                             Float GrowthRate) {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new IllegalStateException(
                        "person with id " + personId + " does not exist"
                ));

        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(person.getEmail(), email)) {
            Optional<Person> personOptional = personRepository
                    .findPersonByEmail(email);
            if (personOptional.isPresent()) {
                throw new IllegalStateException("Email taken");
            }
            person.setEmail(email);
        }
        if (WithdrawalRate != null && WithdrawalRate > 0.0f) {
            person.setWithdrawalRate(WithdrawalRate);
        }

        if (GrowthRate != null && GrowthRate > 0.0f) {
            person.setGrowthRate(GrowthRate);
        }
    }
}
