package com.twu.biblioteca;
import java.util.ArrayList;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void aPasswordCanBeValidated(){
        User user = new User("Tita", "Costumer", "senha secreta", "user@email.com", 112231223);

        assertEquals(true, user.validatePassword("senha secreta"));
        assertEquals(false, user.validatePassword("senha erradona"));
    }

    @Test
    public void aRegisterdUserCanBeFound(){
        ArrayList<User> users = new ArrayList<User>();
        User userFound;
        User user1 = new User("Tita", "Costumer", "senha secreta", "user@email.com", 112231223);

        users.add(user1);
        userFound = User.findUser(1000000, users);

        assertEquals(true, userFound.equals(user1));
    }

    @Test
    public void aUserCanLog(){
        ArrayList<User> users = new ArrayList<User>();
        User logged = null;
        User user1 = new User("Tita", "Costumer", "senha secreta", "user@email.com", 112231223);
        users.add(user1);

        logged = User.login(1000000, "senhatita", users);

        assertEquals(true, logged.equals(user1));


    }


}
