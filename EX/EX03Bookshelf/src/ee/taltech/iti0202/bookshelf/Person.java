package ee.taltech.iti0202.bookshelf;

import java.util.ArrayList;
import java.util.List;

public class Person {
    public String name;
    public int money;

    public List<Book> books;


    public Person(String name, int money) {
        this.name = name;
        this.money = money;
        this.books = new ArrayList<>();
    }

    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

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
    public List<Book> getBooks() {
        return books;
    }
}