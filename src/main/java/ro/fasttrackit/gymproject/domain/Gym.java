package ro.fasttrackit.gymproject.domain;

import javax.persistence.*;

@Entity
public class Gym {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    /* @OneToMany  (cascade = CascadeType.ALL)
    private List<Person> persons; */

    public Gym() {
    }

    public Gym(String name) {
        this.name = name;
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
}
