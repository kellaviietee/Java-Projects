package ee.taltech.iti0202.bookshelf;

public class Person {
    String name;
    int money;
    
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
        if (book != null) {
            if(getMoney() >= book.getPrice() && book.owner == null){
                book.owner = this;
                money -= book.getPrice();
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
                return true;
            }
        }
        return false;
    }
}