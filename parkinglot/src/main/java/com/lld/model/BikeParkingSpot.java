package com.lld.model;

public class BikeParkingSpot extends ParkingSpot {
    public BikeParkingSpot(String id) {
        super(id);
    }

    double price(Integer hour){
        return 20*hour;
    }
}
