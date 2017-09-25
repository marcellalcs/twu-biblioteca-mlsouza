package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {

    @Test
    public void addBookTest(){
        BibliotecaApp bibliotecaAppTest = new BibliotecaApp();
        Book bookTest = new Book("Titulo", "Autor", 2000);
        int numberOfBooksBefore;
        int numberOfBooksAfter;

        numberOfBooksBefore = bibliotecaAppTest.books.size();
        bibliotecaAppTest.registerABook(bookTest);
        numberOfBooksAfter = bibliotecaAppTest.books.size();

        boolean itGrows = numberOfBooksBefore < numberOfBooksAfter ? true : false;

        Boolean expectedReturn = true;

        assertEquals(expectedReturn, itGrows);
    }

    @Test
    public void shouldATypedUserIDBeARightInt(){
        String typedID = "1234-123";
        int userIDTransformed = BibliotecaApp.processUserNumberText(typedID);
        int expectedUserID = 1234123;
        assertEquals(expectedUserID, userIDTransformed);
    }

}
