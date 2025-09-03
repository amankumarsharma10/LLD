package com.lld.employee.hierarchy.dto;

public class ManagerNode {
    private String id;
    private String name;
    private String title;

    private ManagerNode manager;

    public ManagerNode(String id, String name, String title) {
        this.id = id;
        this.name = name;
        this.title = title;
    }

    public ManagerNode(String id, String name, String title, ManagerNode manager) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.manager=manager;
    }


    // getters & setters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getTitle() { return title; }
    public ManagerNode getManager(){ return manager; }
    public void setManager(ManagerNode manager) { this.manager = manager; }

}
