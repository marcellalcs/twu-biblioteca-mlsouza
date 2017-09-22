package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void checkoutBookTest(){
        Book bookTest = new Book("Titulo", "Autor", 2000);
        Boolean expectedReturn = true;
        Boolean executedReturn = bookTest.checkoutBook(1);

        assertEquals(expectedReturn, executedReturn);
        assertEquals(true, bookTest.isRented());
        assertEquals(1, bookTest.getRentedBy());
    }

    @Test
    public void shouldFailCheckoutWhenBookIsAlreadyRentedByMe(){
        Book bookTest = new Book(true, 1);

        Boolean expectedReturn = false;
        Boolean executedReturn = bookTest.checkoutBook(1);

        assertEquals(expectedReturn, executedReturn);
        assertEquals(true, bookTest.isRented());
        assertEquals(1, bookTest.getRentedBy());
    }

    @Test
    public void shouldFailCheckoutWhenBookIsAlreadyRentedByOtherUser(){
        Book bookTest = new Book(true, 2);

        Boolean expectedReturn = false;
        Boolean executedReturn = bookTest.checkoutBook(1);

        assertEquals(expectedReturn, executedReturn);
        assertEquals(true, bookTest.isRented());
        assertEquals(2, bookTest.getRentedBy());
    }



    @Test
    public void returnBookTest(){
        Book bookTest = new Book(true, 1);

        Boolean expectedReturn = true;
        Boolean executedReturn = bookTest.returnBook(1);

        assertEquals(expectedReturn, executedReturn);
        assertEquals(0, bookTest.getRentedBy());
        assertEquals(false, bookTest.isRented());
    }

    @Test
    public void returnBookFailTest(){
        Book bookTest = new Book(false, 0);

        boolean expectedReturn = false;
        boolean executedReturn = bookTest.returnBook(1);

        assertEquals(expectedReturn, executedReturn);
        assertEquals(false, bookTest.isRented());
        assertEquals(0, bookTest.getRentedBy());
    }

    @Test
    public void returnBookbyWrongUser(){
        Book bookTest = new Book(true, 1);

        boolean expectedReturn = false;
        boolean executedReturn = bookTest.returnBook(2);

        assertEquals(expectedReturn, executedReturn);
        assertEquals(true, bookTest.isRented());
        assertEquals(1, bookTest.getRentedBy());
    }

    @Test
    public void shoudisThisMeFail(){
        Book bookOriginal = new Book("O Chefão", "Mario Puzzo", 1969);
        Book bookCopy = new Book("O Chefão", "Mario Puzzo", 1969);
        Book bookDiff = new Book("Chefão", "Mario Puzzo", 1969);

        assertEquals(true, bookOriginal.isThisMe(bookCopy));
        assertEquals(false, bookOriginal.isThisMe(bookDiff));
    }


}
