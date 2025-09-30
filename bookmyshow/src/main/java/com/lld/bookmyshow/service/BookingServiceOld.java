package com.lld.bookmyshow.service;

import com.lld.bookmyshow.model.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class BookingServiceOld {
    LockSeatService lockSeatService;
    PaymentService paymentService;
    private final Map<String, Booking> bookings = new ConcurrentHashMap<>();

    public Booking bookSeat(String userId, Show show, List<Seat> seats, double amount){
        lockSeatService   = new LockSeatService();
        paymentService = new PaymentService("paymentId",amount, PaymentMethod.CREDIT_CARD);
        //1. Lock the seat
        Seat seat  = new Seat("1A",SeatCategory.SILVER);
        seat.setStatus(SeatStatus.AVAILABLE);
        List<String> seatIds = List.of(seat).stream().map(s -> s.getSeatNumber()).collect(Collectors.toList());

        boolean isLockSeat = lockSeatService.lockSeat(show.getShowId(), seatIds, 5, "userId12345");


        //2. Process payment
        if (!isLockSeat) {
            throw new RuntimeException("Selected seats are not available");
        }
        Payment payment = paymentService.processPayment(amount);
        User user = new User("Aman","test@gmail.com");
        if (payment.getStatus().equals(PaymentStatus.SUCCESS)) {
            Booking booking =new Booking(user,show.getMovie().getMovieId(),show,seats,BookingStatus.CONFIRM, 300.0);
            if (booking.getBookingStatus().equals(BookingStatus.CONFIRM) && lockSeatService.confirmSeatBooking(show.getShowId(), seatIds)) {
                bookings.put(booking.getBookingId(), booking);
                seat.setStatus(SeatStatus.BOOKED);
                return booking;
            } else {
                throw new RuntimeException("Failed to confirm booking");
            }
        } else {
            lockSeatService.releaseSeats(show.getShowId(), seatIds);
            throw new RuntimeException("Payment failed");
        }
    }
}
