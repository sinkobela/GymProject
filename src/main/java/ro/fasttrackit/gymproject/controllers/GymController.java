package ro.fasttrackit.gymproject.controllers;

import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.gymproject.domain.Gym;
import ro.fasttrackit.gymproject.services.GymService;

import java.util.List;

@RestController
@RequestMapping("/gyms")
public class GymController {
    private final GymService gymService;

    public GymController(GymService gymService) {
        this.gymService = gymService;
    }

    @GetMapping
    public List<Gym> getAllGyms() {
        return gymService.getAll();
    }

    @GetMapping("/{id}")
    public Gym getGymById(@PathVariable Integer id) {
        return gymService.getById(id);
    }

    @PostMapping
    public Gym addGym(@RequestBody Gym gym) {
        return gymService.addGym(gym);
    }

    @DeleteMapping("/{id}")
    public Gym removeGym(@PathVariable Integer id) {
        return gymService.removeGym(id);
    }
}
