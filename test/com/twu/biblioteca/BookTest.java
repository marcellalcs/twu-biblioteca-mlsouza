package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void shoudisThisMeFail(){
        Book bookOriginal = new Book("O Chefão", "Mario Puzzo", 1969);
        Book bookCopy = new Book("O Chefão", "Mario Puzzo", 1969);
        Book bookDiff = new Book("Chefão", "Mario Puzzo", 1969);

        assertEquals(true, bookOriginal.isThisMe(bookCopy));
        assertEquals(false, bookOriginal.isThisMe(bookDiff));
    }


}
