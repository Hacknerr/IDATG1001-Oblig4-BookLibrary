import Library.BookRegister;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class is used to manage a book-library application.
 * @author André Gärtner
 * @version 1.0.1
 */
public class App {

    Scanner scn;
    BookRegister bookRegister;

    /**
     * Constructor that initializes a Scanner and creates the Library.
     * Also takes the user to the info-menu.
     */
    public App() {
        scn = new Scanner(System.in);
        bookRegister = new BookRegister();
        bookRegister.fillBookRegister();
        totalInfoMenu();
    }

    /**
     * Creates an object of the App class.
     * @param args
     */
    public static void main(String[] args) {
        App app = new App();
    }

    /**
     * This method combines and displayed the welcome message and the menu.
     */
    public void totalInfoMenu(){
        welcomeMessage();
        menu();
    }

    /**
     * This method offers the user an interface with multiple options to choose between.
     */
    public void welcomeMessage(){
        System.out.println("NTNU-Library");
        System.out.println("1. List all books");
        System.out.println("2. Search for books");
        System.out.println("3. Add a book");
        System.out.println("4. Remove a book");
        System.out.println("5. Exit program");
    }

    /**
     * This method takes input from user through a Scanner. Only accepts integer.
     */
    public void menu(){

        boolean validMenuChoice = false;
        int integerInputChoice = 0;

        while(!validMenuChoice){
            try{
                integerInputChoice = scn.nextInt();
                validMenuChoice = true;
            }catch(InputMismatchException e){
                System.out.println("Please enter an integer!");
                scn.next();
            }
        }

        if(bookRegister.checkValidInteger(integerInputChoice, 1, 5)){
            switch(integerInputChoice){
                case 1:
                    bookRegister.listAllBooks();
                    totalInfoMenu();
                    break;
                case 2:
                    searchMenu();
                    break;
                case 3:
                    regBookMenu();
                    break;
                case 4:
                    removeBookMenu();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    totalInfoMenu();
                    break;
            }
        }else{
            menu();
        }

    }

    /**
     * This method prints information about searching, and
     * takes input from user through a Scanner. Only accepts integer.
     */
    public void searchMenu(){
        System.out.println("Search By:");
        System.out.println("1. Title");
        System.out.println("2. Author");
        System.out.println("3. Barcode");
        System.out.println("4. Return to main menu");

        boolean validMenuChoice = false;
        int integerInputChoice = 0;

        while(!validMenuChoice){
            try{
                integerInputChoice = scn.nextInt();
                validMenuChoice = true;
            }catch(InputMismatchException e){
                System.out.println("Please enter an integer!");
                scn.next();
            }
        }

        if(bookRegister.checkValidInteger(integerInputChoice, 1, 4)){
            switch(integerInputChoice){
                case 1:
                    searchByTitleMenu();
                    break;
                case 2:
                    searchByAuthorMenu();
                    break;
                case 3:
                    searchByBarcodeMenu();
                    break;
                default:
                    totalInfoMenu();
            }
        }else{
            searchMenu();
        }

    }

    /**
     * Takes input from user and sends the information to a search-method.
     */
    public void searchByTitleMenu(){
        System.out.println("Write a title to search by");
        scn.nextLine();
        String fromUser = scn.nextLine();
        System.out.println(bookRegister.printResultsFromSearch(bookRegister.searchByTitle(fromUser)));
        searchMenu();
    }

    /**
     * Takes input from user and sends the information to a search-method.
     */
    public void searchByAuthorMenu(){
        System.out.println("Write an author to search by");
        scn.nextLine();
        String fromUser = scn.nextLine();
        System.out.println(bookRegister.printResultsFromSearch(bookRegister.searchByAuthor(fromUser)));
        searchMenu();
    }

    /**
     * Takes input from user and sends the information to a search-method.
     */
    public void searchByBarcodeMenu(){
        System.out.println("Write a barcode to search by");

        boolean validMenuChoice = false;
        long fromUser = 0;

        while(!validMenuChoice){
            try{
                fromUser = scn.nextLong();
                validMenuChoice = true;
            }catch(InputMismatchException e){
                System.out.println("Please enter a valid barcode with 13 digits!");
                scn.next();
            }
        }

        if(bookRegister.checkBarcode(fromUser) == true){
            System.out.println(bookRegister.printResultsFromSearch(bookRegister.searchByBarcode(fromUser)));
        }
        searchMenu();
    }

    /**
     * Takes input from user and registers the information as a new book.
     */
    public void regBookMenu(){
        System.out.println("Add a title");
        String titleFromUser = scn.next();

        System.out.println("Add an author");
        String authorFromUser = scn.next();

        System.out.println("Add a publisher");
        String publisherFromUser = scn.next();

        System.out.println("Add a publishing year between 1950 and 2020");

        boolean validMenuChoice = false;
        int publishingYearFromUser = 0;

        while(!validMenuChoice){
            try{
                publishingYearFromUser = scn.nextInt();
                validMenuChoice = true;
            }catch(InputMismatchException e){
                System.out.println("Please enter an integer!");
                scn.next();
            }
        }

        System.out.println("Add amount of pages between 10 and 999");

        boolean validMenuChoice2 = false;
        int pagesFromUser = 0;

        while(!validMenuChoice2){
            try{
                pagesFromUser = scn.nextInt();
                validMenuChoice2 = true;
            }catch(InputMismatchException e){
                System.out.println("Please enter an integer!");
                scn.next();
            }
        }

        System.out.println("Add a barcode with 13 digits");
        boolean validMenuChoice3 = false;
        long barcodeFromUser = 0;

        while(!validMenuChoice3){
            try{
                barcodeFromUser = scn.nextLong();
                validMenuChoice3 = true;
            }catch(InputMismatchException e){
                System.out.println("Please enter a barcode with 13 digits!");
                scn.next();
            }
        }

        if(bookRegister.checkValidInteger(publishingYearFromUser, 1950, 2020)
                && bookRegister.checkValidInteger(pagesFromUser, 10, 999)
                && bookRegister.checkBarcode(barcodeFromUser) == true
                ){
            bookRegister.regNewBook(titleFromUser, authorFromUser, publisherFromUser, publishingYearFromUser, pagesFromUser, barcodeFromUser);
            totalInfoMenu();
        }else{
            totalInfoMenu();
        }

    }

    /**
     * Takes input from user and removes a book
     */
    public void removeBookMenu(){
        bookRegister.listAllBooks();
        System.out.println("Write the barcode of which book you wish to delete");

        boolean validMenuChoice = false;
        long fromUser = 0;

        while(!validMenuChoice){
            try{
                fromUser = scn.nextLong();
                validMenuChoice = true;
            }catch(InputMismatchException e){
                System.out.println("Please enter a valid barcode with 13 digits!");
                scn.next();
            }
        }

        if(bookRegister.checkBarcode(fromUser) == true){
            bookRegister.deleteBook(fromUser);
        }
        totalInfoMenu();
    }

}
