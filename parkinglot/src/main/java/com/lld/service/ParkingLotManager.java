package com.lld.service;

import com.lld.model.*;
import com.lld.strategy.ParkingStrategy;
import com.lld.strategy.PricingStrategy;

import java.time.LocalDateTime;

public class ParkingLotManager {
    ParkingStrategy parkingStrategy;
    PricingStrategy pricingStrategy;

    public ParkingLotManager(ParkingStrategy parkingStrategy, PricingStrategy pricingStrategy) {
        this.parkingStrategy = parkingStrategy;
        this.pricingStrategy = pricingStrategy;
    }

    public Tickets entry(ParkingLot lot, Vehicle vehicle, LocalDateTime entryTime){
        // find nearest parking spot
        ParkingSpot spot = parkingStrategy.findSpot(vehicle.getVehicleType(), lot.getFloors());
        // generate Ticket
        Tickets tickets = generateTicket(vehicle, spot,entryTime);
        System.out.println("Tickets: Parking spot"+tickets.getParkingSpot());
        return tickets;
    }

    public double exit(Vehicle vehicle, Tickets ticket){
        LocalDateTime exitTime = LocalDateTime.now();
        double amount = pricingStrategy.calculate(ticket.getEntryTime(), exitTime, ticket.getVehicle().getVehicleType());
        ticket.getParkingSpot().removeVehicle();
        return amount;
    }


    public Tickets generateTicket(Vehicle vehicle,ParkingSpot spot,LocalDateTime entryTime) {

        if (spot == null) throw new RuntimeException("No spot available");
        spot.parkVehicle(vehicle);
        return new Tickets(entryTime,vehicle, spot);
    }
}
