package ro.fasttrackit.gymproject.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String address;
    private LocalDate birthDate;

    @ManyToOne
    private Gym gym;

    @OneToOne
    private Membership membership;


    public Person() {
    }

    public Person(Integer id, String name, String address, LocalDate birthDate, Membership membership, Gym gym) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.birthDate = birthDate;
        this.membership = membership;
        this.gym = gym;
    }

    public Person (String name, String address, LocalDate birthDate, Membership membership, Gym gym) {
        this(null, name, address, birthDate, membership, gym);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    public Gym getGym() {
        return gym;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }
}
