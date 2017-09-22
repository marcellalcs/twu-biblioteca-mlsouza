package com.twu.biblioteca;

public class Book {

    private String title;
    private String author;
    private int yearPublished;
    private int rentedBy;
    private Boolean isRented;

    public Book(String title, String author, int yearPublished){
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.rentedBy = 0;
        this.isRented = false;
    }

    public Book(Boolean isRented, int userID){
        this.isRented = isRented;
        this.rentedBy = userID;
    }

    public boolean checkoutBook(int userID){
        boolean success = false;

        if(!this.isRented){
            this.rentedBy = userID;
            this.isRented = true;
            success = true;
        }
        return success;
    }

    public boolean isThisMe(Book book){
        if(this.title.equals(book.title) && this.author.equals(book.author) && this.yearPublished == book.yearPublished)
            return true;
        return false;
    }

    public boolean returnBook(int userID){
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

    public void printBookAuthor(){
        System.out.println(this.author);
    }

    public void printBookTitle(){
        System.out.println(this.title);
    }
    public void printBookYearPublished(){
        System.out.println(this.yearPublished);
    }


}
