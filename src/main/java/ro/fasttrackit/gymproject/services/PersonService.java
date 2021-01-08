package ro.fasttrackit.gymproject.services;

import org.springframework.stereotype.Service;
import ro.fasttrackit.gymproject.domain.Person;
import ro.fasttrackit.gymproject.exceptions.NotFoundException;
import ro.fasttrackit.gymproject.repositories.PersonRepository;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public List<Person> getAll() {
        return repository.findAll();
    }

    public Person getById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Could not find Person with this ID: " + id));
    }

    public Person addPerson(Person person) {
        return repository.save(person);
    }

    public Person removePerson(Integer id) {
        Person personToRemove = getById(id);
        repository.delete(personToRemove);
        return personToRemove;
    }

    public Person editPerson(Integer id, Person person) {
        Person personToEdit = getById(id);
        personToEdit.setName(person.getName());
        personToEdit.setAddress(person.getAddress());
        personToEdit.setBirthDate(person.getBirthDate());
        return repository.save(personToEdit);
    }
}
