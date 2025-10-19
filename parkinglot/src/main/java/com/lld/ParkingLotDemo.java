package com.lld;

import com.lld.model.*;
import com.lld.service.ParkingLotManager;
import com.lld.strategy.HourlyPricingStrategy;
import com.lld.strategy.NearestSpotStrategy;

import java.time.LocalDateTime;

public class ParkingLotDemo {
    public static void main(String[] args) {
        ParkingLotManager parkingLotManager = new ParkingLotManager(new NearestSpotStrategy(),new HourlyPricingStrategy());

        ParkingLot parkingLot = addParkingSpot();

        System.out.println("\n----Stared Bike1 Parking-----");
        Vehicle vehicle1 = new Bike("UP71DC2428");
        Tickets entry = parkingLotManager.entry(parkingLot, vehicle1, LocalDateTime.now());
        System.out.println("\nParked vehicleType: "+entry.getVehicle().getVehicleType()+", VehicleNumber:"+ entry.getVehicle().getVehicleNumber()+", ParkingSpot:"+entry.getParkingSpot());

        System.out.println("\n----Stared Bike2 Parking-----");
        Vehicle vehicle2 = new Bike("UP10CC3264");
        Tickets entry2 = parkingLotManager.entry(parkingLot, vehicle2, LocalDateTime.now().minusHours(2));
        System.out.println("\nParked vehicleType: "+entry2.getVehicle().getVehicleType()+", VehicleNumber:"+ entry2.getVehicle().getVehicleNumber()+", ParkingSpot:"+entry2.getParkingSpot());

        double exitPrice = parkingLotManager.exit(vehicle1, entry);
        System.out.println("\nVehicle1 EXIT: Charges:  "+exitPrice);

        double exitPrice2 = parkingLotManager.exit(vehicle1, entry2);
        System.out.println("\nVehicle2 EXIT: Charges:  "+exitPrice2);


        System.out.println("\n----Stared Car Parking-----");
        Vehicle vehicle3 = new Car("UP63AN9495");
        Tickets entry3 = parkingLotManager.entry(parkingLot, vehicle3, LocalDateTime.now().minusHours(3));
        System.out.println("\nParked vehicleType: "+entry3.getVehicle().getVehicleType()+", VehicleNumber:"+ entry3.getVehicle().getVehicleNumber()+", ParkingSpot:"+entry3.getParkingSpot());
        double exitPrice3 = parkingLotManager.exit(vehicle3, entry3);
        System.out.println("\nVehicle3 EXIT: Charges:  "+exitPrice3);

    }

    public static ParkingLot addParkingSpot(){
        ParkingLot lot = ParkingLot.getInstance();
        ParkingFloor parkingFloor = new ParkingFloor(1);
        parkingFloor.addSpot(VehicleType.BIKE,new BikeParkingSpot("1A"));
        parkingFloor.addSpot(VehicleType.BIKE,new BikeParkingSpot("1B"));
        parkingFloor.addSpot(VehicleType.CAR,new CarParkingSpot("1C"));
        lot.addFloor(parkingFloor);
        return lot;
    }
}