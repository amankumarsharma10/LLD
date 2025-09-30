package com.lld.bookmyshow;

import com.lld.bookmyshow.model.*;
import com.lld.bookmyshow.service.BookingServiceOld;

import java.time.LocalDate;
import java.util.List;

public class BookMyShowMain {
    public static void main(String[] args) {
        BookingServiceOld bookingService = new BookingServiceOld();

        Theater theater = new Theater("Esplanade", "Sec-37");
        Screen screen = new Screen(theater);
        Movie movie1 = new Movie("BOSS","HINDI",LocalDate.of(2013,04,01),150);
        Movie movie2 = new Movie("Pushpa","TELUGU",LocalDate.of(2025,05,01) ,150);


        Show show = new Show("09:00","12:00",movie1,screen);
        Seat seat = new Seat("1A",SeatCategory.PLATINUM);
        Seat seat1 = new Seat("2A",SeatCategory.SILVER);
        List<Seat> seats = List.of(seat, seat1);
        Booking booking = bookingService.bookSeat("userId12345", show, seats, 500.0);
        System.out.println("Booking confirm");
        System.out.println(booking);
    }
}
