package ro.fasttrackit.gymproject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Type type;
    private LocalDate validFrom;
    private LocalDate validTo;

    public Membership() {
    }

    public Membership(Integer id, Type type, LocalDate validFrom) {
        this.id = id;
        this.type = type;
        this.validFrom = validFrom;
        this.validTo = setValidTo(type);
    }

    public Membership(Type type, LocalDate validFrom) {
        this(null, type, validFrom);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public LocalDate getValidTo() {
        return validTo;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public LocalDate setValidTo(Type type) {
        LocalDate result = null;
        if (type == Type.ONE_MONTH && validFrom != null) {
            result = validFrom.plusMonths(1);
        } else if (type == Type.THREE_MONTH && validFrom != null) {
            result = validFrom.plusMonths(3);
        } else if (validFrom != null) {
            result = validFrom.plusMonths(6);
        }
        return result;
    }

    public LocalDate getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
    }
}
