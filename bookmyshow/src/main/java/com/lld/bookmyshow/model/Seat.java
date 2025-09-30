package com.lld.bookmyshow.model;

public class Seat {
    private String seatNumber;
    private SeatStatus status;
    private SeatCategory seatCategory;


    public Seat(String seatNumber, SeatCategory seatCategory) {
        this.seatNumber = seatNumber;
        this.status = SeatStatus.AVAILABLE;
        this.seatCategory = seatCategory;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }

    public SeatCategory getSeatCategory() {
        return seatCategory;
    }

    public static double getBasePrice(Seat seat){
        return seat.getSeatCategory().getPrice();
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatNumber='" + seatNumber + '\'' +
                ", status=" + status +
                ", seatCategory=" + seatCategory +
                '}';
    }
}
