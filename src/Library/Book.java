package Library;


/**
 * This class is used to create and manage books.
 * @Author: André Gärtner
 * @Version: 1.0.1
 */
public class Book {

    private String title;
    private String author;
    private String publisher;
    private int publishingYear;
    private int pages;
    private long barcode;
    private boolean borrowed;

    /**
     * This is a constructor that takes 7 parameters as described.
     * @param title This is the parameter for the book title.
     * @param author This is the parameter for the author of the book.
     * @param publisher This is the parameter for the publisher of the book.
     * @param publishingYear This is the parameter for the year the book was published.
     * @param pages This is the parameter for the amount of pages in the book.
     * @param barcode This is the parameter for the barcode of the book.
     * @param borrowed This is the parameter for the availability of the book.
     */
    public Book(String title, String author, String publisher, int publishingYear, int pages, long barcode, boolean borrowed) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publishingYear = publishingYear;
        this.pages = pages;
        this.barcode = barcode;
        this.borrowed = borrowed;
    }

    /**
     * This function return the book title.
     * @return Book title
     */
    public String getTitle() {
        return title;
    }

    /**
     * This function returns the name of the author.
     * @return Author's Name
     */
    public String getAuthor() {
        return author;
    }

    /**
     * This function returns the barcode of the book.
     * @return Barcode
     */
    public long getBarcode() {
        return barcode;
    }

    /**
     * This function returns information about a book.
     * @return String
     */
    public String getLongDescription(){
       return "Title: " + title + ", Author: " + author + ", Publisher: " + publisher + ", Year published: " + publishingYear + ", pages: " + pages + ", Barcode: " + barcode + ", Borrowed: " + borrowed;
    }

}
