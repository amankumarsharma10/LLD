package com.lld.model;

public class CarParkingSpot extends ParkingSpot {

    public CarParkingSpot(String id) {
        super(id);
    }

    double price(Integer hour){
        return 50*hour;
    }
}
