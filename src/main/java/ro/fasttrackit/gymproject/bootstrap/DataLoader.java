package ro.fasttrackit.gymproject.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ro.fasttrackit.gymproject.domain.Gym;
import ro.fasttrackit.gymproject.domain.Membership;
import ro.fasttrackit.gymproject.domain.Person;
import ro.fasttrackit.gymproject.domain.Type;
import ro.fasttrackit.gymproject.services.GymService;
import ro.fasttrackit.gymproject.services.MembershipService;
import ro.fasttrackit.gymproject.services.PersonService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final GymService gymService;
    private final PersonService personService;
    private final MembershipService membershipService;

    public DataLoader(GymService gymService, PersonService personService, MembershipService membershipService) {
        this.gymService = gymService;
        this.personService = personService;
        this.membershipService = membershipService;
    }

    @Override
    public void run(String... args) throws Exception {
        gymService.addGym(new Gym("Endurance fitness"));
        gymService.addGym(new Gym("Oxygen GYM"));
        gymService.addGym(new Gym("Fit 4 You"));

        personService.addPerson(new Person("Bela", "Nufarului 28", LocalDate.of(1995,11,3)));
        personService.addPerson(new Person("Feri", "Clujului 15", LocalDate.of(2008,10,8)));
        personService.addPerson(new Person("Peti", "Decebal 39", LocalDate.of(1990,6,16)));

        membershipService.addMembership(new Membership(Type.ONE_MONTH, LocalDate.of(2021,1,7)));
        membershipService.addMembership(new Membership(Type.THREE_MONTH, LocalDate.of(2021,1,7)));
        membershipService.addMembership(new Membership(Type.SIX_MONTH, LocalDate.of(2021,1,7)));
    }
}
