package ee.taltech.iti0202.bookshelf;

import java.util.ArrayList;
import java.util.List;

public class Person {
    String name;
    int money;
    List<Book> ownedBooks;
    
    public Person(String name, int money) {
        this.name = name;
        this.money = money;
        this.ownedBooks = new ArrayList<>();
    }

    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public boolean buyBook(Book book) {
        if (book != null) {
            if(getMoney() >= book.getPrice() && book.owner == null){
                book.owner = this;
                money -= book.getPrice();
                ownedBooks.add(book);
                return true;
            }
        }
        return false;
    }

    public boolean sellBook(Book book) {
        if(book != null){
            if(book.getOwner() == this){
                money += book.getPrice();
                book.owner = null;
                ownedBooks.remove(book);
                return true;
            }
        }
        return false;
    }
    public List<Book> getBooks(){
        return ownedBooks;
    }
}