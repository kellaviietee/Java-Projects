package ee.taltech.iti0202.bookshelf;

import java.util.*;

public class Book {

    public static List<Book> books = new ArrayList<>();
    public static int availableId = -1;
    public String title;
    public String author;
    public int yearOfPublishing;
    public int price;
    public Person owner;
    public int bookId;
    /*
    Create a Book instance.
     */
    public static Book of(String title, String author, int yearOfPublishing, int price){
        Book testBook = new Book(title,author,yearOfPublishing,price);
        for(Book book : books){
            if(compareBooks(book,testBook)){
                return book;
            }
        }
        books.add(testBook);
        return testBook;
    }
    /*
    Create a simplified Book instance.
    */
    public static Book of(String title, int price){
        if (books.size() == 0){
            return null;
        }
        String previousAuthor = books.get(books.size()-1).getAuthor();
        int previousYear = books.get(books.size()-1).getYearOfPublishing();
        Book testBook = new Book(title,previousAuthor,previousYear,price);
        for(Book book : books){
            if(compareBooks(book,testBook)){
                return book;
            }
        }
        books.add(testBook);
        return testBook;
    }

    public static List<Book> getBooksByOwner(Person owner){
        return owner.getOwnedBooks();
    }

    public static boolean removeBook(Book book){
        if(book == null || !books.contains(book)){
            return false;
        }
        Person bookOwner = book.getOwner();
        if (bookOwner != null){
            bookOwner.sellBook(book);
        }
        books.remove(book);
        return true;
    }

    public static List<Book> getBooksByAuthor(String author){
        List<Book> authorBooks = new ArrayList<>();
        for(Book book : books){
            if(book.getAuthor().toLowerCase().equals(author.toLowerCase())){
              authorBooks.add(book);
            }
        }
        return authorBooks;
    }

    /*
    Get current available BookId and increment it for the next book.
     */
    public static int getAndIncrementNextId() {
        availableId += 1;
        return availableId;
    }
    /*
    Book class constructor.
     */
    public Book(String title, String author, int yearOfPublishing, int price) {
        this.title = title;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
        this.price = price;
        this.bookId = getAndIncrementNextId();

    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public Person getOwner() {
        return owner;
    }

    public int getPrice() {
        return price;
    }
    /*
    Get the book id.
     */
    public int getId() {
        return bookId;
    }

    public boolean buy(Person buyer) {
        if (buyer == null) {
            if (this.getOwner() != null) {
                Person bookOwner = getOwner();
                bookOwner.sellBook(this);
                return true;
            }
            return false;
        } else if (buyer.getMoney() >= this.price && buyer != this.getOwner()) {
            if (getOwner() != null) {
                Person bookOwner = getOwner();
                bookOwner.sellBook(this);
            }
            buyer.buyBook(this);
            return true;
        }
        return false;
    }

    /*
    Check if two Book instances are the same.
     */
    public static boolean compareBooks(Book book1, Book book2){
        return Objects.equals(book1.getTitle(), book2.getTitle())
                && Objects.equals(book1.getAuthor(), book2.getAuthor())
                && book1.getYearOfPublishing() == book2.getYearOfPublishing()
                && book1.getPrice() == book2.getPrice();
    }
}
