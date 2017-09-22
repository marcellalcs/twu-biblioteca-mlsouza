package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void aRegisteredUserCanLog(){
        User user = new User("Tita", "Costumer");
        assertEquals(true, user.login("123-5678", "senhasecreta"));

    }


}
