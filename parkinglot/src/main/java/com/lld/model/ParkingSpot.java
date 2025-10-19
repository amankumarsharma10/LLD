package com.lld.model;

public abstract class ParkingSpot {
    private String id;
    private boolean available;
    private Vehicle vehicle;
    private double price;

    public ParkingSpot(String id) {
        this.id = id;
        this.available = true;
    }

    public void parkVehicle(Vehicle v){
        this.vehicle = v;
        this.available = false;
    }

    public void removeVehicle(){
        this.vehicle = null;
        this.available = true;
    }

    public boolean isAvailable() { return available; }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "id='" + id + '\'' +
                ", available=" + available +
                ", vehicle=" + vehicle +
                ", price=" + price +
                '}';
    }
}
