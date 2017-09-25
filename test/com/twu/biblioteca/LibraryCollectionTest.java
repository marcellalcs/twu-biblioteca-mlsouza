package com.twu.biblioteca;

import com.twu.biblioteca.Book;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryCollectionTest {

    @Test
    public void checkoutTest(){
        Book bookTest = new Book("Titulo", "Autor", 2000);
        Boolean expectedReturn = true;
        Boolean executedReturn = bookTest.checkout(1000001);

        assertEquals(expectedReturn, executedReturn);
        assertEquals(true, bookTest.isRented());
        assertEquals(1000001, bookTest.getRentedBy());
    }

    @Test
    public void shouldFailCheckoutWhenBookIsAlreadyRentedByMe(){
        Book bookTest = new Book(true, 1000001);

        Boolean expectedReturn = false;
        Boolean executedReturn = bookTest.checkout(1000001);

        assertEquals(expectedReturn, executedReturn);
        assertEquals(true, bookTest.isRented());
        assertEquals(1000001, bookTest.getRentedBy());
    }

    @Test
    public void shouldFailCheckoutWhenBookIsAlreadyRentedByOtherUser(){
        Book bookTest = new Book(true,  1000001);

        Boolean expectedReturn = false;
        Boolean executedReturn = bookTest.checkout(1000001);

        assertEquals(expectedReturn, executedReturn);
        assertEquals(true, bookTest.isRented());
        assertEquals(1000001, bookTest.getRentedBy());
    }

    @Test
    public void returnBookTest(){
        Book bookTest = new Book(true, 1000001);

        Boolean expectedReturn = true;
        Boolean executedReturn = bookTest.returnItem(1000001);

        assertEquals(expectedReturn, executedReturn);
        assertEquals(0, bookTest.getRentedBy());
        assertEquals(false, bookTest.isRented());
    }

    @Test
    public void returnBookFailTest(){
        Book bookTest = new Book(false, 0);

        boolean expectedReturn = false;
        boolean executedReturn = bookTest.returnItem(1000001);

        assertEquals(expectedReturn, executedReturn);
        assertEquals(false, bookTest.isRented());
        assertEquals(0, bookTest.getRentedBy());
    }

    @Test
    public void returnBookbyWrongUser(){
        Book bookTest = new Book(true, 1000001);

        boolean expectedReturn = false;
        boolean executedReturn = bookTest.returnItem(1000002);

        assertEquals(expectedReturn, executedReturn);
        assertEquals(true, bookTest.isRented());
        assertEquals(1000001, bookTest.getRentedBy());
    }
}
