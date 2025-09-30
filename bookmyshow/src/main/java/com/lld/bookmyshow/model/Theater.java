package com.lld.bookmyshow.model;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class Theater  {
    private String theaterId;
    private String name;
    private String location;
    private List<Screen> screens;

    public Theater(String name, String location) {
        this.theaterId = IdGenerator.generateId();
        this.name = name;
        this.location = location;
        this.screens = new ArrayList<>();
    }

    public void addScreens(List<Screen> screens) {
        this.screens = screens;
    }

    public String getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(String theaterId) {
        this.theaterId = theaterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    @Override
    public String toString() {
        return "Theater{" +
                "theaterId='" + theaterId + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", screens=" + screens +
                '}';
    }
}
