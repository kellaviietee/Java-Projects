package ee.taltech.iti0202.bookshelf;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Book {

    public static List<Book> getBooks() {
        return books;
    }

    public static Map<String, List<Book>> booksByAuthor = new HashMap<>();
    public static List<Book> books = new ArrayList<>();
    public static Book previousBook;
    public static int availableId = -1;
    public String title;
    public String author;
    public int yearOfPublishing;
    public int price;
    public Person owner;
    public int bookId;

    /**
     * Create a Book instance.
     *
     * @param title            Title of the book.
     * @param author           Author of the book.
     * @param yearOfPublishing When the book was published.
     * @param price            Price of the book
     * @return return the added book or the book that is already on the bookshelf.
     */
    public static Book of(String title, String author, int yearOfPublishing, int price) {
        Book testBook = new Book(title, author, yearOfPublishing, price);
        if(books.contains(testBook)){
            return testBook;
        }
        books.add(testBook);
        addBookToAuthor(testBook);
        previousBook = testBook;
        return testBook;
    }

    /**
     * Create a simplified Book instance.
     *
     * @param title Title of the book
     * @param price Price of the book
     * @return return the added book or the one already on the bookshelf.
     */
    public static Book of(String title, int price) {
        if (previousBook == null) {
            return null;
        }
        String previousAuthor = previousBook.getAuthor();
        int previousYear = previousBook.getYearOfPublishing();
        Book testBook = new Book(title, previousAuthor, previousYear, price);
        if(books.contains(testBook)){
            return testBook;
        }
        books.add(testBook);
        addBookToAuthor(testBook);
        previousBook = testBook;
        return testBook;
    }

    /**
     * Adda book to the Authors list.
     *
     * @param book Is the book to add to the Authors list of books.
     */
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
                List<Book> bookList = new ArrayList<>();
                bookList.add(book);
                booksByAuthor.put(bookAuthor, bookList);
            }
        }
    }

    /**
     * Remove the book from bookshelf.
     *
     * @param book book to be removed
     * @return if the book was removed.
     */
    public static boolean removeBook(Book book) {
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

    /**
     * Get Books the Person owns.
     *
     * @param owner Person that has the books.
     * @return List of Books.
     */
    public static List<Book> getBooksByOwner(Person owner) {
        return owner.getBooks();
    }

    /**
     * Get All the books by a single Author.
     *
     * @param author Authors name.
     * @return List of books.
     */
    public static List<Book> getBooksByAuthor(String author) {
        if (booksByAuthor.get(author.toLowerCase()) == null) {
            return new ArrayList<>();
        } else return booksByAuthor.get(author.toLowerCase());
    }

    /**
     * Get current available BookId and increment it for the next book.
     */
    public static int getAndIncrementNextId() {
        availableId += 1;
        return availableId;
    }

    /**
     * Book class constructor.
     *
     * @param title            Title of the book.
     * @param author           Author of the book.
     * @param yearOfPublishing When was the book published.
     * @param price            Price of the book.
     */
    public Book(String title, String author, int yearOfPublishing, int price) {
        this.title = title;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
        this.price = price;
        this.bookId = getAndIncrementNextId();

    }

    /**
     * Get title of the book.
     *
     * @return Title of the book.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Author of the book.
     *
     * @return Book Author.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Publishing year of the book.
     *
     * @return Year when the book was published.
     */
    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    /**
     * Current owner of the book.
     *
     * @return Person currently owning the book.
     */
    public Person getOwner() {
        return owner;
    }

    /**
     * Price of the book.
     *
     * @return Books price.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Get the ID of the book.
     *
     * @return ID of the book.
     */
    public int getId() {
        return bookId;
    }

    /**
     * Person tries to buy a book.
     *
     * @param buyer Person trying to buy the book.
     * @return If the transaction was successful.
     */
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return yearOfPublishing == book.yearOfPublishing && title.equals(book.title) && author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, yearOfPublishing);
    }
}

