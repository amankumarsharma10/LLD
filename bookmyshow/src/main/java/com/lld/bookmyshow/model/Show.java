package com.lld.bookmyshow.model;

import lombok.ToString;

@ToString
public class Show {
    private String showId;
    private String startTime;
    private String endTime;
    private Movie movie;
    private Screen screen;

    public Show(String startTime, String endTime, Movie movie, Screen screen) {
        this.showId = IdGenerator.generateId();
        this.startTime = startTime;
        this.endTime = endTime;
        this.movie = movie;
        this.screen = screen;
    }

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Screen getScreen() {
        return screen;
    }
}
