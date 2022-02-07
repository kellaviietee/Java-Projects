package ee.taltech.iti0202.bookshelf;
public class Book {
    String title;
    String author;
    int yearOfPublishing;
    int price;
    Person owner;
    int bookId;
    static int id = 0;
    public static int getAndIncrementNextId() {
        return id + 1;
    }

    public Book(String title, String author, int yearOfPublishing, int price) {
        this.bookId = id;
        this.title = title;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
        this.price = price;
        this.owner = null;
        id = id + 1;
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
        currentOwner.sellBook(this);
        buyer.buyBook(this);
        return true;
    }

}