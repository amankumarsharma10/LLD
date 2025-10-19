package com.lld.model;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private static ParkingLot instance;
    private static List<ParkingFloor> floors = new ArrayList<>();

    private ParkingLot() {
    }

    public static ParkingLot getInstance(){
        if (instance == null) {
            instance = new ParkingLot();
            floors.add(new ParkingFloor(1));
        }
        return instance;
    }

    public void addFloor(ParkingFloor floor) {
        floors.add(floor);
    }

    public List<ParkingFloor> getFloors() {
        return floors;
    }
}
