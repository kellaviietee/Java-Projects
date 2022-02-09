package ee.taltech.iti0202.bookshelf;
public class Book {

    public static int availableId = 0;
    public String title;
    public String author;
    public int yearOfPublishing;
    public int price;
    public Person owner;

    public static int getAndIncrementNextId() {
        int currentId = availableId;
        availableId += 1;
        return currentId;
    }

    public Book(String title, String author, int yearOfPublishing, int price) {
        this.title = title;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
        this.price = price;
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
        return availableId;
    }

    public boolean buy(Person buyer) {
        return false;
    }

}