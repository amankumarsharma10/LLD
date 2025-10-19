package com.lld.strategy;

import com.lld.model.ParkingFloor;
import com.lld.model.ParkingSpot;
import com.lld.model.VehicleType;

import java.util.List;

public interface ParkingStrategy {
    ParkingSpot findSpot(VehicleType type, List<ParkingFloor> floors);
}
