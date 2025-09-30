package com.lld.bookmyshow.model;

import lombok.ToString;

import java.time.LocalDate;

@ToString
public class Movie {
     String movieId;
     String title;
     String language;
     LocalDate releaseDate;
     private int duration;

    public Movie(String title, String language,LocalDate releaseDate, int duration) {
        this.movieId = IdGenerator.generateId();
        this.title = title;
        this.language = language;
        this.releaseDate = releaseDate;
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public String getLanguage() {
        return language;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public String getMovieId() {
        return movieId;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId='" + movieId + '\'' +
                ", title='" + title + '\'' +
                ", language='" + language + '\'' +
                ", releaseDate=" + releaseDate +
                ", duration=" + duration +
                '}';
    }
}
