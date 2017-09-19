package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BooksTest {

    @Test
    checkoutBookTest(int userID){
        Boolean expectedReturn = this.checkoutBook(costumer);
        Boolean executedReturn = true;
        assertEquals(expectedReturn, executedReturn);
    }

}
