package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {

    @Test
    public void shouldAUserCheckOutAMovie(){
        Movie movieTest = new Movie("O Fabuloso Destino de Amelie Poulain", 2002, "Jean-Pierre Jeunet", 5);
        assertEquals(true, movieTest.checkout(1));
        assertEquals(true, movieTest.isRented());
        assertEquals(1, movieTest.getRentedBy());
    }

    @Test
    public void shoudAUserReturnAMovie(){
        Movie movieTest = new Movie ("Into the Wild", 2008, "Sean Pean", 5);
        movieTest.checkout(1);

        assertEquals(true, movieTest.returnItem(1));
        assertEquals(false, movieTest.isRented());
        assertEquals(0, movieTest.getRentedBy());
    }

    @Test
    public void shoudReturnFailIfTheMovieIsNotRentend(){
        Movie movieTest = new Movie("O Poderoso Chefão", 1972, "Francis Ford Copola", 5);

        assertEquals(false, movieTest.returnItem(1));
        assertEquals(0, movieTest.getRentedBy());
        assertEquals(false, movieTest.isRented);
    }



}
