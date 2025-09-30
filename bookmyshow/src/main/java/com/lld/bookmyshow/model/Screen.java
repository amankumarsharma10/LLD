package com.lld.bookmyshow.model;

import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ToString
public class Screen {
    private String screenId;
    private List<Show> shows;
    private Map<String, Seat> seats;
    private Theater theater;

    public Screen(Theater theater) {
        this.screenId = IdGenerator.generateId();
        this.shows = new ArrayList<>();
        this.seats = initializeSeats();
        this.theater = theater;
    }

    public void addShows(Show show){
        this.shows.add(show);
    }

    public Map<String, Seat> initializeSeats(){
        seats = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            this.seats.put(String.valueOf(i),new Seat(String.valueOf(i),SeatCategory.SILVER));
        }
        for (int i = 11; i < 20; i++) {
            this.seats.put(String.valueOf(i),new Seat(String.valueOf(i),SeatCategory.GOLD));
        }
        for (int i = 21; i < 30; i++) {
            this.seats.put(String.valueOf(i),new Seat(String.valueOf(i),SeatCategory.PLATINUM));
        }
        return seats;
    }

    public String getScreenId() {
        return screenId;
    }

    public List<Show> getShows() {
        return shows;
    }

    public Map<String, Seat> getSeats() {
        return seats;
    }

    public Theater getTheater() {
        return theater;
    }
}
