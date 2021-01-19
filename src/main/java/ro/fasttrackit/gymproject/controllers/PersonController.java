package ro.fasttrackit.gymproject.controllers;

import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.gymproject.domain.Person;
import ro.fasttrackit.gymproject.services.PersonService;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAll();
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Integer id) {
        return personService.getById(id);
    }

    @PostMapping
    public Person addPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }

    @PutMapping("/{id}")
    public Person editPerson(@PathVariable Integer id, @RequestBody Person person) {
        return personService.editPerson(id, person);
    }

    @DeleteMapping("/{id}")
    public Person removePerson(@PathVariable Integer id) {
        return personService.removePerson(id);
    }
}
