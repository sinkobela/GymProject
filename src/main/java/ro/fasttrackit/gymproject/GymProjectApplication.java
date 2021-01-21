package ro.fasttrackit.gymproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.fasttrackit.gymproject.domain.Gym;
import ro.fasttrackit.gymproject.domain.Membership;
import ro.fasttrackit.gymproject.domain.Person;
import ro.fasttrackit.gymproject.domain.Type;
import ro.fasttrackit.gymproject.repositories.GymRepository;
import ro.fasttrackit.gymproject.repositories.MembershipRepository;
import ro.fasttrackit.gymproject.repositories.PersonRepository;

@SpringBootApplication
public class GymProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(GymProjectApplication.class, args);
	}

}
