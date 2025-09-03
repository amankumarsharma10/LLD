package com.lld.employee.hierarchy.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Employee {
    @Id
    private String id;
    private String name;
    private String title;

    @ManyToOne(fetch = FetchType.LAZY) // Many employees can have one manager
    @JoinColumn(name = "manager_id")
    private Employee manager;

    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
    private List<Employee> subordinates;

    protected Employee() {}

    public Employee(String id, String name, String title) {
        this.id = id;
        this.name = name;
        this.title = title;
    }

    // getters & setters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getTitle() { return title; }
    public Employee getManager() { return manager; }
    public void setManager(Employee manager) { this.manager = manager; }
    public List<Employee> getSubordinates() { return subordinates; }
    public void setSubordinates(List<Employee> subordinates) { this.subordinates = subordinates; }
}
