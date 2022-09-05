package com.example.demo.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getPersons() {
        return personService.getPersons();
    }

    @GetMapping(path = "{personId}")
    public Optional<Person> getPersonById(@PathVariable("personId") Long personId) {
        return personService.getPersonById(personId);
    }

    @PostMapping
    public void registerNewPerson(@RequestBody Person person) {
        personService.addNewPerson(person);
    }
    @DeleteMapping(path = "{personId}")
    public void deletePerson(@PathVariable("personId") Long personId) {
        personService.deletePerson(personId);
    }

    @PutMapping(path = "{personId}")
    public void updatePerson (
            @PathVariable("personId") Long personId,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) Float withdrawalRate,
            @RequestParam(required = false) Float growthRate) {
        personService.updatePerson(personId, email, withdrawalRate, growthRate);
    }
}
