package com.twu.biblioteca;

import java.util.ArrayList;

public class User {
    private static int counterID = 1000000;
    private final int userID;
    private String name;
    private String function;
    private String password;
    private String email;
    private int phoneNumber;

    public User(){
        this.userID = counterID++;
    }

    public User(String name, String function, String password, String email, int phoneNumber) {
        this.name = name;
        this.function = function;
        this.userID = counterID++;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getID(){
        return this.userID;
    }

    public boolean validatePassword(String password){
        if(this.password.equals(password))
            return true;
        return false;
    }

    public static User findUser(int userID, ArrayList<User> systemUsers){
        User userFound = null;
        for (User userIterator : systemUsers) {
            if (userIterator.getID() == userID)
                userFound = userIterator;
        }
        return userFound;
    }

    public static User login(int userID, String password, ArrayList<User> usersList){
        User userFound = null;
        User userLogged = null;
        userFound = findUser(userID, usersList);
        if(userFound.validatePassword(password))
            userLogged = userFound;
        return userLogged;
    }

    public void printUserInfo(){
        System.out.println("Name:" + this.name);
        System.out.println("Email:" + this.email);
        System.out.println("Phone number:" + this.phoneNumber);
        System.out.println("___________________________________________________");
    }


}
