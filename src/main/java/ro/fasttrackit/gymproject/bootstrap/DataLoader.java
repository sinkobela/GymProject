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
import java.util.List;

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

        Gym endurance = gymService.addGym(new Gym("Endurance fitness"));
        Gym oxygen = gymService.addGym(new Gym("Oxygen GYM"));
        Gym fit4You = gymService.addGym(new Gym("Fit 4 You"));

        personService.addPerson(new Person("Bela", "Nufarului 28", LocalDate.of(1995,11,3), oneMonth, endurance));
        personService.addPerson(new Person("Feri", "Clujului 15", LocalDate.of(2008,10,8), threeMonth,endurance));
        personService.addPerson(new Person("Peti", "Decebal 39", LocalDate.of(1990,6,16), sixMonth, endurance));
        personService.addPerson(new Person("Ana", "Dacia 31", LocalDate.of(1984,7,3), sixMonth, oxygen));
        personService.addPerson(new Person("Stefan", "Doja 10", LocalDate.of(1992,2,8), oneMonth, oxygen));
        personService.addPerson(new Person("Marius", "Coposu 66", LocalDate.of(1999,3,16), threeMonth, oxygen));
        personService.addPerson(new Person("Elena", "Stefan Cel Mare 8", LocalDate.of(2003,4,3), threeMonth, fit4You));
        personService.addPerson(new Person("Maria", "Transilvaniei 94", LocalDate.of(2000,10,8), sixMonth, fit4You));
        personService.addPerson(new Person("Cosmin", "Calugareni 39", LocalDate.of(1991,6,16), oneMonth, fit4You));


/*        List<Person> personList1 = List.of(
                personService.addPerson(new Person("Bela", "Nufarului 28", LocalDate.of(1995,11,3), oneMonth)),
                personService.addPerson(new Person("Feri", "Clujului 15", LocalDate.of(2008,10,8), threeMonth)),
                personService.addPerson(new Person("Peti", "Decebal 39", LocalDate.of(1990,6,16), sixMonth)));

        List<Person> personList2 = List.of(
                personService.addPerson(new Person("Ana", "Dacia 31", LocalDate.of(1984,7,3), sixMonth)),
                personService.addPerson(new Person("Stefan", "Doja 10", LocalDate.of(1992,2,8), oneMonth)),
                personService.addPerson(new Person("Marius", "Coposu 66", LocalDate.of(1999,3,16), threeMonth)));

        List<Person> personList3 = List.of(
                personService.addPerson(new Person("Elena", "Stefan Cel Mare 8", LocalDate.of(2003,4,3), threeMonth)),
                personService.addPerson(new Person("Maria", "Transilvaniei 94", LocalDate.of(2000,10,8), sixMonth)),
                personService.addPerson(new Person("Cosmin", "Calugareni 39", LocalDate.of(1991,6,16), oneMonth)));

        Gym endurance = gymService.addGym(new Gym("Endurance fitness", personList1));
        Gym oxygen = gymService.addGym(new Gym("Oxygen GYM", personList2));
        Gym fit4You = gymService.addGym(new Gym("Fit 4 You", personList3));
*/
    }
}
