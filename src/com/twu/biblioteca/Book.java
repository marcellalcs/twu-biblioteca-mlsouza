package com.twu.biblioteca;

public class Book extends LibraryCollection {
    protected String author;

    public Book(boolean isRented, int userID){
        this.isRented = isRented;
        this.rentedBy = userID;
    }

    public Book(String title, String author, int yearPublished){
        this.title = title;
        this.author = author;
        this.year = yearPublished;
        this.rentedBy = 0;
        this.isRented = false;
    }

    public boolean isThisMe(Book book){
        if(this.title.equals(book.title) && this.author.equals(book.author) && this.year == book.year)
            return true;
        return false;
    }

    public void printBookAuthor(){
        System.out.println(this.author);
    }


}
