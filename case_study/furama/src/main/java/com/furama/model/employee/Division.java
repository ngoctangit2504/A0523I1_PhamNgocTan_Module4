package com.furama.model.employee;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "division", cascade = CascadeType.ALL)
    private List<Employee> employeeList;

    public Division() {
    }

    public Division(int id, String name) {
        this.id = id;
        this.name = name;
    }

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
}
