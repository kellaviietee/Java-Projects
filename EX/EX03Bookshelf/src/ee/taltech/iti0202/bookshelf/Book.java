package ee.taltech.iti0202.bookshelf;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class Book {
    String title;
    String author;
    int yearOfPublishing;
    int price;
    Person owner;
    int bookId;
    static int id = 0;
    static List<Book> books = new ArrayList<>();

    public static int getAndIncrementNextId() {
        return id;
    }
    public static Book of(String title, String author, int yearOfPublishing, int price){
        for(Book book : books){
            if(Objects.equals(book.getTitle(), title) && Objects.equals(book.getAuthor(), author)
                    && book.getYearOfPublishing() == yearOfPublishing && book.getPrice() == price){
                return book;
            }
        }
        Book newBook = new Book(title,author,yearOfPublishing,price);
        books.add(newBook);
        return newBook;
    }
    public static Book of(String title, int price){
        if(books.size() == 0){
            return null;
        }
        String author = books.get(books.size()-1).getAuthor();
        int yearOfPublishing = books.get(books.size()-1).getYearOfPublishing();
        for(Book book : books){
            if(Objects.equals(book.getTitle(), title) && book.getPrice() == price
            && book.getYearOfPublishing() == yearOfPublishing && Objects.equals(book.getAuthor(), author)){
                return book;
            }
            }
        Book newBook = new Book(title,author,yearOfPublishing,price);
        books.add(newBook);
        return newBook;
    }
    public static List<Book> getBooksByOwner(Person owner){
        return owner.getBooks();
    }
    public static boolean removeBook(Book book){
        if (book == null){
            return false;
        }
        for(Book testBook : books){
            if(Objects.equals(testBook.getTitle(), book.getTitle()) && Objects.equals(testBook.getAuthor(), book.getAuthor())
            && testBook.getYearOfPublishing() == book.getYearOfPublishing() && testBook.getPrice() == book.getPrice()) {
                if(book.getOwner() != null){
                    Person owner = book.getOwner();
                    owner.sellBook(book);
                }
                books.remove(book);
                return true;
            }
        }
        return false;
    }
    public static List<Book> getBooksByAuthor(String author){
        List<Book> booksByAuthor = new ArrayList<>();
        for(Book book : books){
            if(Objects.equals(book.getAuthor().toLowerCase(), author.toLowerCase())){
                booksByAuthor.add(book);
            }
        }
        return booksByAuthor;
    }


    public Book(String title, String author, int yearOfPublishing, int price) {
        this.bookId = id;
        id = id + 1;
        this.title = title;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
        this.price = price;
        this.owner = null;
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

    public int getId() {
        return bookId;
    }

    public boolean buy(Person buyer) {
        if(getOwner() == buyer || buyer.getMoney() < getPrice()){
            return false;
        }
        Person currentOwner = getOwner();
        if(currentOwner != null) {
            currentOwner.sellBook(this);
        }
        buyer.buyBook(this);
        return true;
    }

}