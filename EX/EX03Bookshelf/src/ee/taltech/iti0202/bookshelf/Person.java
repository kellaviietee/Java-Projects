package ee.taltech.iti0202.bookshelf;

public class Person {
    public String name;
    public int money;

    public Person(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public boolean buyBook(Book book) {
        if (book == null){
            return false;
        }
        else if(book.price > getMoney() || book.getOwner() != null){
            return false;
        }
        else{
            money -= book.getPrice();
            book.owner = this;
            return true;
        }
    }

    public boolean sellBook(Book book) {
        if(book == null || book.getOwner() != this) {
            return false;
        }
        else{
            money += book.getPrice();
            book.owner = null;
            return true;
        }

    }
}