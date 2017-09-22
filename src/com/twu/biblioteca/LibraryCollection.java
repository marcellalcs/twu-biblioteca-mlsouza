package com.twu.biblioteca;

public class LibraryCollection {
    protected String title;
    protected int year;
    protected int rentedBy;
    protected Boolean isRented;


    public boolean checkout(int userID){
        boolean success = false;

        if(!this.isRented){
            this.rentedBy = userID;
            this.isRented = true;
            success = true;
        }
        return success;
    }

    public boolean returnItem(int userID){
        boolean success = false;

        if(this.isRented && this.rentedBy == userID){
            this.isRented = false;
            this.rentedBy = 0;
            success = true;
        }
        return success;
    }

    public boolean isRented(){
        return isRented;
    }

    public int getRentedBy(){
        return this.rentedBy;
    }

    public void printTitle(){
        System.out.println(this.title);
    }

    public void printYearPublished(){
        System.out.println(this.year);
    }
}
