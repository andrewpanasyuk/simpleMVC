package com.example.simpleApp.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="groups")
public class Group {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private Long id;

    private String name;

    @OneToMany
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
