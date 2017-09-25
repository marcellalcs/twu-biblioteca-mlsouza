package com.twu.biblioteca;

import java.util.ArrayList;

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

    public void printDirector(){
        System.out.println(this.director);
    }

    public void printRating(){
        System.out.println(this.movieRating);
    }

    public static void printAvailabletMovies(ArrayList<Movie> movies){
        for(int i=0; i<movies.size(); i++) {
            System.out.println(i + 1);

            System.out.print("Movie title: ");
            movies.get(i).printTitle();

            System.out.print("Director: ");
            movies.get(i).printDirector();

            System.out.print("Year published: ");
            movies.get(i).printYearPublished();

            System.out.print("Rating: ");
            movies.get(i).printRating();

            System.out.println("___________________________________________________");
        }
    }

    public boolean isThisMe(Movie movie){
        if(this.title.equals(movie.title) && this.director.equals(movie.director) && this.year == movie.year && this.movieRating == movie.movieRating)
            return true;
        return false;
    }

    public static Movie findAMovie(Movie searched, ArrayList<Movie> movies){
        Movie result = null;
        for(Movie movie : movies){
            if(movie.isThisMe(searched))
                result = movie;
        }
        return result;
    }


}
