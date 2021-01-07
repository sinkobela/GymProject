package ro.fasttrackit.gymproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.gymproject.domain.Gym;

public interface GymRepository extends JpaRepository<Gym, Integer> {
}
