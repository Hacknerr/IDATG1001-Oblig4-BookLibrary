package Library;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;

public class BookRegister {

    HashSet<Book> bookLibrary;

    public BookRegister() {
        bookLibrary = new HashSet<>();
    }

    /**
     * Helper method for initializing objects of class Book.
     */
    public void fillBookRegister(){
        Book book1 = new Book("Flaggermusmannen", "Jo Nesbø", "Aschehoug & Co", 1997, 564, 544646464635757L, false);
        Book book2 = new Book("Snømannen", "Jo Nesbø", "Aschehoug & Co", 2007, 232, 544646464635758L, false);
        Book book3 = new Book("Tørst", "Jo Nesbø", "Aschehoug & Co", 2014, 435, 544646464635755L, false);
        addBook(book1);
        addBook(book2);
        addBook(book3);
    }

    /**
     * Adds a Book-object to the HashSet bookLibrary
     * @param book
     */
    public void addBook(Book book){
        if(compareBooks(book) == false){
            bookLibrary.add(book);
        }
    }

    /**
     * Compares Book object with all objects in the bookLibrary HashSet
     * @param book an object of class Book
     * @return True or false based on if book exists
     */
    public boolean compareBooks(Book book){
        for(Book searchLibrary : bookLibrary){
            if(searchLibrary.getBarcode() == book.getBarcode()){
                System.out.println("A book with the same barcode already exists! The book was not added.");
                return true;
            }
        }
        return false;
    }

    /**
     * Prints a list to the user of all books within the library.
     */
    public void listAllBooks(){
        for(Book searchLibrary : bookLibrary){
            System.out.println(searchLibrary.getLongDescription());
        }
    }

    /**
     * Prints a list to the user of all books within the library.
     */
    public void listAllBooks2(){
        Iterator<Book> it = bookLibrary.iterator();
        while(it.hasNext()){
            System.out.println(it.next().getLongDescription());
        }
    }

    /**
     * Creates a new Book object based on input from user. Sends the object to addBook()
     */
    public void regNewBook(String title, String author, String publisher, int publishingYear, int pages, long barcode){
            Book book = new Book(title, author,publisher, publishingYear, pages, barcode, false);
            addBook(book);
    }

    /**
     * Searches for books in the bookLibrary based on title from user.
     * @param titleFromUser Scanner object with a title from user.
     * @return Returns an arrayList with books of same title.
     */
    public ArrayList<String> searchByTitle(String titleFromUser){
        ArrayList<String> results = new ArrayList<>();
        for(Book searchLibrary : bookLibrary){
            if(searchLibrary.getTitle().equalsIgnoreCase(titleFromUser)){
                results.add(searchLibrary.getLongDescription());
            }
        }
        return results;
    }

    /**
     * Searches for books in the bookLibrary based on author from user.
     * @param authorFromUser Scanner object with an author from user.
     * @return Returns an arrayList with books of same author.
     */
    public ArrayList<String> searchByAuthor(String authorFromUser){
        ArrayList<String> results = new ArrayList<>();
        for(Book searchLibrary : bookLibrary){
            if(searchLibrary.getAuthor().equalsIgnoreCase(authorFromUser)){
                results.add(searchLibrary.getLongDescription() + "\n");
            }
        }
        return results;
    }

    /**
     * Searches for books in the bookLibrary based on barcode from user.
     * @param barcodeFromUser Scanner object with a barcode from user.
     * @return Returns an arrayList with books of same barcode.
     */
    public ArrayList<String> searchByBarcode(long barcodeFromUser){
        ArrayList<String> results = new ArrayList<>();
        for(Book searchLibrary : bookLibrary){
            if(searchLibrary.getBarcode() == (barcodeFromUser)){
                results.add(searchLibrary.getLongDescription());
            }
        }
        return results;
    }

    /**
     * Converts the contents of an ArrayList to a string.
     * @param results ArrayList with results from a search.
     * @return Returns a string with information about books found during search.
     */
    public String printResultsFromSearch(ArrayList<String> results){
        String print = "";
        if(results.isEmpty()){
            System.out.println("Didn't find any books.");
        }else{
           print = "Amount of books found: " + results.size() + "\n";
           for(String list : results){
               print += list;
           }
        }
        return print;
    }

    /**
     * Takes input from user and deletes book in bookLibrary with the same barcode.
     * @param fromUser Scanner object with datatype long
     */
    public void deleteBook(long fromUser){
        ArrayList<Book> deletedBooks = new ArrayList<>();
        for(Book results : bookLibrary){
            if(results.getBarcode() == fromUser){
                bookLibrary.remove(results);
                deletedBooks.add(results);
            }
        }
        if(deletedBooks.size() > 0){
            System.out.println("Book has been deleted!");
        }else{
            System.out.println("Didn't find any books to delete!");
        }
    }

    /**
     * Checks if the number from user is within legal range.
     * @param toBeChecked Scanner object with datatype int.
     * @param minimumValue The smallest integer value allowed.
     * @param maximumValue The largest integer value allowed.
     * @return Result from validation of integer as boolean.
     */
    public boolean checkValidInteger(int toBeChecked, int minimumValue, int maximumValue){
        boolean validInteger = false;
        if(toBeChecked <= maximumValue && toBeChecked >= minimumValue){
            validInteger = true;
        }else{
            System.out.println("The number " + toBeChecked + " is not a valid number! It has to be between " + minimumValue +" and " + maximumValue + ".");
        }
        return validInteger;
    }

    /**
     * Checks if the given barcode from user is 13-digits long.
     * @param fromUser Scanner object with datatype long
     * @return Result from validation of integer being 13-digits long.
     */
    public boolean checkBarcode(long fromUser){
        String newInput = Long.toString(fromUser);
        if(newInput.length() != 13){
            System.out.println("The barcode was not 13 digits long! Please try again.");
            return false;
        }
        return true;
    }

}
