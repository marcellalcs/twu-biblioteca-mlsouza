package com.twu.biblioteca;

public class Movie extends LibraryCollection{
    String director;
    int movieRating;

    public Movie(String name, int year, String director, int movieRating){
        this.title = name;
        this.year = year;
        this.director = director;
        this.movieRating = movieRating;
        this.rentedBy = 0;
        this.isRented = false;
    }


}
