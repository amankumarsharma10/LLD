package com.lld.employee.hierarchy.dto;

import java.util.ArrayList;
import java.util.List;

public class EmployeeNode {
    private String id;
    private String name;
    private String title;
    private List<EmployeeNode> subordinates = new ArrayList<>();

    public EmployeeNode(String id, String name, String title) {
        this.id = id;
        this.name = name;
        this.title = title;
    }

    public void addSubordinate(EmployeeNode node) {
        this.subordinates.add(node);
    }

    // getters & setters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getTitle() { return title; }
    public List<EmployeeNode> getSubordinates() { return subordinates; }
}
