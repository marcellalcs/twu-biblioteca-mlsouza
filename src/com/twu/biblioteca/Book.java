package com.twu.biblioteca;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Book extends LibraryCollection {
    protected String author;

    public static void printAvailableBooks(ArrayList<Book> books){
        for(int i=0; i<books.size(); i++){
            if(!books.get(i).isRented) {
                System.out.println(i + 1);

                System.out.print("Book title: ");
                books.get(i).printTitle();

                System.out.print("Author: ");
                books.get(i).printBookAuthor();

                System.out.print("Year published: ");
                books.get(i).printYearPublished();

                System.out.println("___________________________________________________");
            }
        }
    }

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

    public static Book findABook(Book searched, ArrayList<Book> books){
        Book result = null;
        for(Book book : books){
            if(book.isThisMe(searched))
                result = book;
        }
        return result;
    }


}
