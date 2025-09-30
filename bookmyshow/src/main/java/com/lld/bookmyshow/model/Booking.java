package com.lld.bookmyshow.model;

import java.util.List;

public class Booking {
    private String bookingId;
    private User user;
    private  String MovieId;
    private Show show;
    private List<Seat> reserveSeats;
    private BookingStatus bookingStatus;
    private double totalAmount;

    public Booking(User user, String movieId, Show show, List<Seat> reserveSeats, BookingStatus bookingStatus, double totalAmount) {
        this.bookingId = IdGenerator.generateId();
        this.user=user;
        MovieId = movieId;
        this.show = show;
        this.reserveSeats = reserveSeats;
        this.bookingStatus = bookingStatus;
        this.totalAmount = totalAmount;
    }

    public String getBookingId() {
        return bookingId;
    }

    public User getUser() {
        return user;
    }

    public String getMovieId() {
        return MovieId;
    }

    public Show getShow() {
        return show;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public List<Seat> getReserveSeats() {
        return reserveSeats;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId='" + bookingId + '\'' +
                ", MovieId='" + MovieId + '\'' +
                ", show=" + show +
                ", reserveSeats=" + reserveSeats +
                ", bookingStatus=" + bookingStatus +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
