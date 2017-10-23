package com.example.demo;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "kids")
public class Kid {
    private int id;
    private String name;
    private Set<Subject> subjects;

    public Kid() {
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

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "kids_subjects", joinColumns = @JoinColumn(name = "kid_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id", referencedColumnName = "id"))
    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        String result = "Kid{" + "id=" + id + ", name= " + name;

        if (subjects != null) {
            for(Subject sub: subjects) {
                result += " ,Subject {id: " + sub.getId() + ", name: " + sub.getName() + "}";
            }
        }

        result += "}";

        return result;
    }
}
