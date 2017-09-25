package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;


public class BibliotecaApp {
    protected ArrayList<Book> books;
    protected ArrayList<Movie> movies;
    protected ArrayList<User> users;
    protected ArrayList<String> menuOptions;
    public static User loggedUser;

    BibliotecaApp(){
        this.books = new ArrayList<Book>();
        this.movies = new ArrayList<Movie>();
        this.menuOptions = new ArrayList<String>();
        this.users = new ArrayList<User>();
        this.menuOptions.add("1 - List availables books");
        this.menuOptions.add("2 - List availables movies");
        this.menuOptions.add("3 - return a book");
        this.menuOptions.add("4 - return a movie");
        this.menuOptions.add("5 - See personal info");
        this.menuOptions.add("0 - Close Biblioteca");
    }

    public void inicializeData(){
        Book book1 = new Book("Revolução dos Bichos", "George Orwell", 1945 );
        Book book2 = new Book("O Chefão", "Mario Puzo", 1969);
        Book book3 = new Book("A Verdade Além das Aparências", "Samuel Gomes", 2015);

        this.registerABook(book1);
        this.registerABook(book2);
        this.registerABook(book3);

        Movie movie1 = new Movie("O Fabuloso Destino de Amelie Poulain", 2002, "Jean-Pierre Jeunet", 5);
        Movie movie2 = new Movie("Into the Wild", 2008, "Sean Pean", 5);
        Movie movie3 = new Movie("O Poderoso Chefão", 1972, "Francis Ford Copola", 5);

        this.registerAMovie(movie1);
        this.registerAMovie(movie2);
        this.registerAMovie(movie3);

        User user1 = new User("Tita", "costumer", "senhatita", "tita@dogsmail.com", 12345678);
        User user2 = new User("Mingau", "costumer", "senhamingau", "gagau@catsmail.com", 87654321);

        this.registerAnUser(user1);
        this.registerAnUser(user2);

    }



    public static int processUserNumberText(String userNumber){
        String numberArray[] = userNumber.split("-");
        String numberUnited = numberArray[0] + numberArray[1];
        int userIDNumber = Integer.parseInt(numberUnited);

        return userIDNumber;
    }

    public ArrayList<Book> getListOfBooks(){
        return this.books;
    }

    public ArrayList<Movie> getListOfMovies(){
        return this.movies;
    }

    public ArrayList<User> getListOfUsers(){
        return this.users;
    }

    public void registerABook(Book newBook){
        this.books.add(newBook);
    }

    public void registerAMovie(Movie newMovie){
        this.movies.add(newMovie);
    }

    public void registerAnUser(User newUser){
        this.users.add(newUser);
    }


    public void printWelcomeMessage(){
        System.out.println("Hello, welcome to Biblioteca!");
    }

    public void printMenuOptions(){
        System.out.println("Choose a option below:");
        for(String menu : this.menuOptions) System.out.println(menu);
    }

    public static int scanTypedInt(){
        Scanner keyboard = new Scanner(System.in);
        return  keyboard.nextInt();
    }

    public static String scanTypedText() {
        Scanner keyboard = new Scanner(System.in);
        return  keyboard.nextLine();
    }

    public void tryingToLogin(){
        boolean login = true;
        while(login){
            System.out.println("Type your user ID:");
            String userIDTyped = BibliotecaApp.scanTypedText();
            int userID  = BibliotecaApp.processUserNumberText(userIDTyped);
            System.out.println("Type your password:");
            String userPassword = BibliotecaApp.scanTypedText();
            loggedUser = User.login(userID, userPassword, this.getListOfUsers());
            if(loggedUser == null)
                System.out.println("incorrect user ID or password, try again");
            else {
                login = false;
            }
        }

    }

    public static void main(String[] args) {
        BibliotecaApp biblioteca = new BibliotecaApp();
        biblioteca.inicializeData();

        biblioteca.printWelcomeMessage();
        biblioteca.tryingToLogin();


        boolean terminal = true;
        int choosenMenu;
        int choosenBookID;
        int choosenMovieID;
        Movie chosenMovie;
        Book chosenBook;

        while (terminal) {
            biblioteca.printMenuOptions();
            choosenMenu = biblioteca.scanTypedInt();
            switch (choosenMenu) {
                case 1:
                    Book.printAvailableBooks(biblioteca.getListOfBooks());
                    System.out.println("Do you like any? Type the code of the book you want to check it out");
                    choosenBookID = biblioteca.scanTypedInt();

                    try{ chosenBook = biblioteca.books.get(choosenBookID - 1);}
                    catch (IndexOutOfBoundsException e){
                        System.out.println("Sorry, but that is not a valid book.");
                        break;
                    }

                    if (chosenBook.checkout(loggedUser.getID())) {
                        System.out.println("Thank you! Enjoy the book ");
                        chosenBook.printTitle();
                    } else
                        System.out.println("This is not a valid book. Try again");

                    break;
                case 2:
                    Movie.printAvailabletMovies(biblioteca.getListOfMovies());
                    System.out.println("Do you like any? Type the code of the movie you want to check it out");
                    choosenMovieID = biblioteca.scanTypedInt();

                    try{chosenMovie = biblioteca.movies.get(choosenMovieID - 1);}
                    catch (IndexOutOfBoundsException e){
                        System.out.println("Sorry, but that is not a valid movie.");
                        break;
                    }

                    if (chosenMovie.checkout(loggedUser.getID())) {
                        System.out.println("Thank you! Enjoy the movie ");
                        chosenMovie.printTitle();
                    } else
                        System.out.println("This is not a valid movie. Try again");

                    break;
                case 3:
                    System.out.println("What is the name of the book?");
                    String bookReturnedName = biblioteca.scanTypedText();
                    System.out.println("What is the author?");
                    String bookReturnedAuthor = biblioteca.scanTypedText();
                    System.out.println("What is the published year?");
                    int bookReturnedPublishedYear = biblioteca.scanTypedInt();

                    chosenBook = new Book(bookReturnedName, bookReturnedAuthor, bookReturnedPublishedYear);
                    Book bookToReturn = Book.findABook(chosenBook, biblioteca.getListOfBooks());

                    if (bookToReturn != null) {
                        bookToReturn.returnItem(loggedUser.getID());
                        System.out.println("Thanks, book returned");
                    }else {
                        System.out.println("Sorry, It was not possibile to return this book");
                    }
                    break;
                case 4:
                    System.out.println("What is the name of the movie?");
                    String movieReturnedName = biblioteca.scanTypedText();
                    System.out.println("What is the director?");
                    String movieReturnedAuthor = biblioteca.scanTypedText();
                    System.out.println("What is the published year?");
                    int movieReturnedPublishedYear = biblioteca.scanTypedInt();
                    System.out.println("What is the rating?");
                    int movieRating = biblioteca.scanTypedInt();
                    chosenMovie = new Movie(movieReturnedName, movieReturnedPublishedYear, movieReturnedAuthor, movieRating);
                    Movie movieToReturn = Movie.findAMovie(chosenMovie, biblioteca.getListOfMovies());
                    if (movieToReturn != null) {
                        movieToReturn.returnItem(loggedUser.getID());
                        System.out.println("Thanks, book returned");
                    }else {
                        System.out.println("Sorry, It was not possible to return this movie");
                    }
                    break;
                case 5:
                    loggedUser.printUserInfo();
                    break;
                case 0:
                    System.out.println("Thanks =) See you latter!");
                    terminal = false;
                    System.exit(0);
                    break;
                default:
                    System.out.println("That option is not available. Try again.");
                    break;
            }

        }
    }
}
