package ee.taltech.iti0202.bookshelf;

import java.util.*;

public class Book {

    public static List<Book> getBooks() {
        return books;
    }

    public static Map<String, List<Book>> booksByAuthor = new HashMap<>();
    public static List<Book> books = new ArrayList<>(10000);
    public static Book previousBook;
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
    public static Book of(String title, String author, int yearOfPublishing, int price) {
        Book testBook = new Book(title, author, yearOfPublishing, price);
        for (Book book : books) {
            if (compareBooks(book, testBook)) {
                return book;
            }
        }
        books.add(testBook);
        addBookToAuthor(testBook);
        previousBook = testBook;
        return testBook;
    }

    /*
    Create a simplified Book instance.
    */
    public static Book of(String title, int price) {
        if (previousBook == null) {
            return null;
        }
        String previousAuthor = previousBook.getAuthor();
        int previousYear = previousBook.getYearOfPublishing();
        Book testBook = new Book(title, previousAuthor, previousYear, price);
        for (Book book : books) {
            if (compareBooks(book, testBook)) {
                return book;
            }
        }
        books.add(testBook);
        addBookToAuthor(testBook);
        previousBook = testBook;
        return testBook;
    }

    public static void addBookToAuthor(Book book) {
        if (book != null) {
            String bookAuthor = book.getAuthor().toLowerCase();
            if (booksByAuthor.containsKey(bookAuthor)) {
                List<Book> authorBooks = booksByAuthor.get(bookAuthor);
                if (!authorBooks.contains(book)) {
                    authorBooks.add(book);
                    booksByAuthor.put(bookAuthor, authorBooks);
                }
            }
            if (!booksByAuthor.containsKey(bookAuthor)) {
                List<Book> BookList = new ArrayList<>();
                BookList.add(book);
                booksByAuthor.put(bookAuthor, BookList);
            }
        }
    }

    public static boolean removeBook(Book book) {
        books.removeAll(null);
        if (book == null || !books.contains(book)) {
            return false;
        }
        Person bookOwner = book.getOwner();
        if (bookOwner != null) {
            bookOwner.sellBook(book);
        }
        books.remove(book);
        List<Book> authorsBooks = booksByAuthor.get(book.getAuthor().toLowerCase());
        if (authorsBooks != null) {
            authorsBooks.remove(book);
        }
        return true;
    }

    public static List<Book> getBooksByOwner(Person owner) {
        return owner.getBooks();
    }

    public static List<Book> getBooksByAuthor(String author) {
        if (booksByAuthor.get(author.toLowerCase()) == null) {
            return new ArrayList<>();
        } else return booksByAuthor.get(author.toLowerCase());
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
    public static boolean compareBooks(Book book1, Book book2) {
        return Objects.equals(book1.getTitle(), book2.getTitle())
                && Objects.equals(book1.getAuthor(), book2.getAuthor())
                && book1.getYearOfPublishing() == book2.getYearOfPublishing();
    }

}
