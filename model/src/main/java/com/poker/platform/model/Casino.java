package com.poker.platform.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "casino")
public class Casino {

    @Id
    @Basic
    private int id;

    @Basic
    @Column(name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Casino)) return false;
        Casino casino = (Casino) o;
        return id == casino.id &&
                Objects.equals(name, casino.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
