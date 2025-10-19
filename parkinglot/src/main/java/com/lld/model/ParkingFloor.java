package com.lld.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingFloor {

    private int floorNumber;
    private Map<VehicleType, List<ParkingSpot>> spotsByType = new HashMap<>();

    public ParkingFloor(int floorNumber) {
        this.floorNumber = floorNumber;
        spotsByType.put(VehicleType.CAR, new ArrayList<>());
        spotsByType.put(VehicleType.BIKE, new ArrayList<>());
        spotsByType.put(VehicleType.TRUCK, new ArrayList<>());
    }

    public void addSpot(VehicleType type, ParkingSpot spot) {
        spotsByType.get(type).add(spot);
    }

    public ParkingSpot getAvailableSpot(VehicleType type) {
        for (ParkingSpot spot : spotsByType.get(type)) {
            if (spot.isAvailable()) return spot;
        }
        return null;
    }
}
