package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;


public class BibliotecaApp {
    protected ArrayList<Book> books;
    protected ArrayList<String> menuOptions;

    BibliotecaApp(){
        this.books = new ArrayList<Book>();
        this.menuOptions = new ArrayList<String>();
        this.menuOptions.add("1 - List availables books");
        this.menuOptions.add("2 - return a book");
        this.menuOptions.add("0 - Close Biblioteca");
    }

    public void registerABook(Book newBook){
        this.books.add(newBook);
    }


    public void listAllBooks(){
        for(int i=0; i<books.size(); i++){
            System.out.println(i+1);

            System.out.print("Book title: ");
            books.get(i).printBookTitle();

            System.out.print("Author: ");
            books.get(i).printBookAuthor();

            System.out.print("Year published: ");
            books.get(i).printBookYearPublished();

            System.out.println("___________________________________________________");
        }
    }

    public void printWelcomeMessage(){
        System.out.println("Hello, welcome to Biblioteca, what is your name?");
    }

    public void printMenuOptions(){
        System.out.println("Choose a option below:");
        for(String menu : this.menuOptions) System.out.println(menu);
    }

    public int scanTypedInt(){
        Scanner keyboard = new Scanner(System.in);
        return  keyboard.nextInt();
    }

    public String scanTypedText() {
        Scanner keyboard = new Scanner(System.in);
        return  keyboard.nextLine();
    }

    public Book findABook(Book searched){
        Book result =  null;
        for(Book book : this.books){
            if(book.isThisMe(searched))
                result = book;
        }
        return result;
    }

    public static void main(String[] args) {
        BibliotecaApp biblioteca = new BibliotecaApp();

        Book book1 = new Book("Revolução dos Bichos", "George Orwell", 1945 );
        Book book2 = new Book("O Chefão", "Mario Puzo", 1969);
        Book book3 = new Book("A Verdade Além das Aparências", "Samuel Gomes", 2015);

        biblioteca.registerABook(book1);
        biblioteca.registerABook(book2);
        biblioteca.registerABook(book3);

        biblioteca.printWelcomeMessage();
        String userName = biblioteca.scanTypedText();
        User costumer = new User (userName, "Costumer");



        boolean terminal = true;
        int choosenMenu;
        int choosenBookID;
        Book chosenBook;

        while (terminal) {
            biblioteca.printMenuOptions();
            choosenMenu = biblioteca.scanTypedInt();
            switch (choosenMenu) {
                case 1:
                    biblioteca.listAllBooks();
                    System.out.println("Do you like any? Type the code of the book you want to check it out");
                    choosenBookID = biblioteca.scanTypedInt();
                    chosenBook = biblioteca.books.get(choosenBookID-1);

                    if(chosenBook.checkoutBook(costumer.getID())) {
                        System.out.println("Thank you! Enjoy the book ");
                        chosenBook.printBookTitle();
                    }else
                        System.out.println("This is not a valid book. Try again");

                    break;
                case 2:
                    System.out.println("What is the name of the book you want to return?");
                    String bookReturntedName = biblioteca.scanTypedText();
                    System.out.println("What is the author?");
                    String bookReturnedAuthor = biblioteca.scanTypedText();
                    System.out.println("What is the published year?");
                    int bookReturnedPublishedYear = biblioteca.scanTypedInt();

                    chosenBook = new Book(bookReturntedName, bookReturnedAuthor, bookReturnedPublishedYear);
                    Book bookToRetur = biblioteca.findABook(chosenBook);
                    if(bookToRetur != null) {
                        bookToRetur.returnBook(costumer.getID());
                        System.out.println("Thanks, book returned");
                    }else
                        System.out.println("Sorry, It was not possibile to return this book");
                    break;
                case 0:
                    System.out.println("Thanks =) See you latter!");
                    terminal = false;
                    System.exit(0);
                    break;
                default:
                    System.out.println("That option is not available. Try again.");
            }
        }






    }

}
