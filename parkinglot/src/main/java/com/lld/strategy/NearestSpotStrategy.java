package com.lld.strategy;

import com.lld.model.ParkingFloor;
import com.lld.model.ParkingSpot;
import com.lld.model.VehicleType;

import java.util.List;

public class NearestSpotStrategy implements ParkingStrategy{
    @Override
    public ParkingSpot findSpot(VehicleType type, List<ParkingFloor> floors) {
        for (ParkingFloor floor : floors) {
            ParkingSpot spot = floor.getAvailableSpot(type);
            if (spot != null) return spot;
        }
        return null;
    }
}
