package ro.fasttrackit.gymproject.domain;

import javax.persistence.*;

@Entity
public class Gym {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String gymName;

    public Gym() {
    }

    public Gym(Integer id, String gymName) {
        this.id = id;
        this.gymName = gymName;
    }

    public Gym(String gymName) {
        this(null, gymName);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGymName() {
        return gymName;
    }

    public void setGymName(String gymName) {
        this.gymName = gymName;
    }

}
