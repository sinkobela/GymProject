package ro.fasttrackit.gymproject.services;

import org.springframework.stereotype.Service;
import ro.fasttrackit.gymproject.exceptions.NotFoundException;
import ro.fasttrackit.gymproject.domain.Gym;
import ro.fasttrackit.gymproject.repositories.GymRepository;

import java.util.List;

@Service
public class GymService {
    private final GymRepository repository;

    public GymService(GymRepository repository) {
        this.repository = repository;
    }

    public List<Gym> getAll() {
        return repository.findAll();
    }

    public Gym getById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Could not find Gym with this ID: " + id));
    }

    public Gym addGym(Gym gym) {
        return repository.save(gym);
    }

    public Gym removeGym(Integer id) {
        Gym gymToRemove = getById(id);
        repository.delete(gymToRemove);
        return gymToRemove;
    }
}
