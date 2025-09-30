package com.lld.bookmyshow.service;

import com.lld.bookmyshow.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingService {
    private final List<Movie> movies;
    private final List<Theater> theaters;
    private final Map<String, Show> showMap;
    private final Map<String, Booking> bookingMap;
    private final BookingStatus bookingStatus;

    public BookingService() {
        this.movies = new ArrayList<>();
        this.theaters = new ArrayList<>();
        this.showMap = new HashMap<>();
        this.bookingMap = new HashMap<>();
        this.bookingStatus=BookingStatus.PENDING;
    }

    public void addMovie(Movie movie){
        movies.add(movie);
    }

    public void addShow(Show show){
        showMap.put(show.getShowId(), show);
    }

    public void addBooking(Booking booking){
        bookingMap.put(booking.getBookingId(), booking);
    }

    public Booking bookTickets(User user, Show show, List<Seat> selectedSeats){
        // check if seat available
        if (isSeatsAvailable(show,selectedSeats)){
            // Calculate totalPrice
            var totalPrice = calculatePrice(show,selectedSeats);

            //Make Payments

            // changing the status from Available to BOOKED
            updateSeatAsBooked(show,selectedSeats);

            Booking booking = new Booking(user, show.getMovie().getMovieId(), show, selectedSeats, BookingStatus.CONFIRM, totalPrice);

            bookingMap.put(booking.getBookingId(), booking);
            return booking;
        }

        return null;
    }

    private double calculatePrice(Show show, List<Seat> selectedSeats) {
        return selectedSeats.stream().mapToDouble(Seat::getBasePrice).sum();
    }

    private void updateSeatAsBooked(Show show, List<Seat> seats){
        for (Seat seat: seats){
            Seat showSeats = show.getScreen().getSeats().get(seat.getSeatNumber());
            showSeats.setStatus(SeatStatus.BOOKED);
        }
    }
    private boolean isSeatsAvailable(Show show, List<Seat> selectedSeats){
        for (Seat seat: selectedSeats) {
            Seat showSeat = show.getScreen().getSeats().get(seat.getSeatNumber());
            if (!showSeat.getStatus().equals(SeatStatus.AVAILABLE))
                return false;
        }
        return true;
    }
}
