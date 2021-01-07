package ro.fasttrackit.gymproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.gymproject.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
