package com.lld.bookmyshow.model;

import java.util.List;

public class User {
    private String id;
    private String name;
    private String email;
   // private List<Booking> bookings;


    public User(String name, String email) {
        this.id = IdGenerator.generateId();
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
