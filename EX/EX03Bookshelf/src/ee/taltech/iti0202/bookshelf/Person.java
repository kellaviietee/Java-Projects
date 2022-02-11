package ee.taltech.iti0202.bookshelf;

import java.util.ArrayList;
import java.util.List;

/**
 * Person class.
 */
public class Person {
    public String name;
    public int money;
    public List<Book> books;

    /**
     * Constructor class for the Person
     * @param name Name of the Person.
     * @param money How much money does the person has.
     */
    public Person(String name, int money) {
        this.name = name;
        this.money = money;
        this.books = new ArrayList<>();
    }

    /**
     * Getter for Persons money.
     * @return Current amount of money.
     */
    public int getMoney() {
        return money;
    }

    /**
     * Getter for Persons name.
     * @return Persons name.
     */
    public String getName() {
        return name;
    }

    /**
     * Person tries to buy a book.
     * @param book The book Person tries to buy.
     * @return If the purchase was successful.
     */
    public boolean buyBook(Book book) {
        if (book == null) {
            return false;
        } else if (book.price > getMoney() || book.getOwner() != null) {
            return false;
        } else {
            money -= book.getPrice();
            book.owner = this;
            books.add(book);
            return true;
        }
    }

    /**
     * Person tries to sell a book.
     * @param book Book that Person tries to sell.
     * @return If selling was successful.
     */
    public boolean sellBook(Book book) {
        if (book == null || book.getOwner() != this) {
            return false;
        } else {
            money += book.getPrice();
            books.remove(book);
            book.owner = null;
            return true;
        }
    }

    /**
     * Getter for Persons currently owned books.
     * @return List of books the Person owns.
     */
    public List<Book> getBooks() {
        return books;
    }
}