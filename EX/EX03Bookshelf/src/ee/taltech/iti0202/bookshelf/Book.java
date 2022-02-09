package ee.taltech.iti0202.bookshelf;
public class Book {

    public static int availableId = -1;
    public String title;
    public String author;
    public int yearOfPublishing;
    public int price;
    public Person owner;
    public int bookId;

    public static int getAndIncrementNextId() {
        availableId += 1;
        return availableId;
    }

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

    public int getId() {
        return bookId;
    }

    public boolean buy(Person buyer) {
        if (getOwner() == null){
            return false;
        }
        else if(buyer == null){
            Person currentOwner = getOwner();
            currentOwner.sellBook(this);
            return true;
        }
        else if(buyer == getOwner() || buyer.money < getPrice()){
            return false;
        }
        else {
            Person currentOwner = getOwner();
            currentOwner.sellBook(this);
            buyer.buyBook(this);
            return true;
        }
    }

}