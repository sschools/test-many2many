package com.example.demo;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "subjects")
public class Subject {
    private int id;
    private String name;
    private Set<Kid> kids;

    public Subject() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "subjects")
    public Set<Kid> getKids() {
        return kids;
    }

    public void setKids(Set<Kid> kids) {
        this.kids = kids;
    }

    @Override
    public String toString() {
        String result = "Subject{" + "id=" + id + ", name= " + name;

        if (kids != null) {
            for(Kid kid: kids) {
                result += " ,Kid {id: " + kid.getId() + ", name: " + kid.getName() + "}";
            }
        }

        result += "}";

        return result;
    }
}
