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

    @OneToOne /* (targetEntity = Membership.class, cascade = CascadeType.ALL) */
    private Membership membership;


    public Person() {
    }

    public Person(Integer id, String name, String address, LocalDate birthDate, Membership membership) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.birthDate = birthDate;
        this.membership = membership;
    }

    public Person (String name, String address, LocalDate birthDate, Membership membership) {
        this(null, name, address, birthDate, membership);
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
}
