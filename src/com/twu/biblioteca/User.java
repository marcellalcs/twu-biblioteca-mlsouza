package com.twu.biblioteca;

public class User {
    private static int idCounter = 0;
    private final int userID;
    private String name;
    private String function;


    public User(String name, String function) {
        this.name = name;
        this.function = function;
        this.userID = this.idCounter++;
    }

    public int getID(){
        return this.userID;
    }

    public boolean login(String userCode, String password){
        return true;
    }

}
