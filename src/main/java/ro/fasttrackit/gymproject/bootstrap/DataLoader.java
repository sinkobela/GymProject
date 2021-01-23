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

        Membership oneMonth = membershipService.addMembership(new Membership(Type.ONE_MONTH, LocalDate.of(2021,1,1)));
        Membership threeMonth = membershipService.addMembership(new Membership(Type.THREE_MONTH, LocalDate.of(2021,1,1)));
        Membership sixMonth = membershipService.addMembership(new Membership(Type.SIX_MONTH, LocalDate.of(2021,1,1)));

        Gym endurance = gymService.addGym(new Gym("Endurance Fitness"));
        Gym oxygen = gymService.addGym(new Gym("Oxygen Gym"));
        Gym fit4You = gymService.addGym(new Gym("Fit 4 You"));

        personService.addPerson(new Person("Popescu Vlad", "Nufarului 28", LocalDate.of(1995,11,3), oneMonth, endurance));
        personService.addPerson(new Person("Muresan Mircea", "Calea Clujului 15", LocalDate.of(2008,10,8), threeMonth,endurance));
        personService.addPerson(new Person("Radu Ion", "Bulevardul Decebal 39", LocalDate.of(1990,6,16), sixMonth, endurance));

        personService.addPerson(new Person("Pop Anamaria", "Bulevardul Dacia 31", LocalDate.of(1984,7,3), sixMonth, oxygen));
        personService.addPerson(new Person("Muntean Stefan", "Gheorghe Doja 10", LocalDate.of(1992,2,8), oneMonth, oxygen));
        personService.addPerson(new Person("Baciu Elena", "Corneliu Coposu 66", LocalDate.of(1999,3,16), threeMonth, oxygen));

        personService.addPerson(new Person("Ardelean Razvan", "Stefan Cel Mare 8", LocalDate.of(2003,4,3), threeMonth, fit4You));
        personService.addPerson(new Person("Duma Camelia", "Transilvaniei 94", LocalDate.of(2000,10,8), sixMonth, fit4You));
        personService.addPerson(new Person("Rusu Cosmin", "Calugareni 39", LocalDate.of(1991,6,16), oneMonth, fit4You));
    }
}
