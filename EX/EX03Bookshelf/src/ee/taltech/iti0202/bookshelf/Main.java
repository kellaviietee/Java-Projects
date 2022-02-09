package ee.taltech.iti0202.bookshelf;

import java.util.List;

public class Main {
    
    public static void main(String[] args) {
// second part
        Book b0 = Book.of("Java EX00", 1);
        System.out.println(b0); // null
        Book b1 = Book.of("Java EX01", "Ago Luberg", 2018, 3);
        Book b2 = Book.of("Java EX02",4);
        System.out.println(b2.getAuthor()); // Ago Luberg
        Book b3 = Book.of("Java EX03",7);
        Book b4 = Book.of("Java EX01", 11);
        System.out.println(b1.getPrice());
        System.out.println(b4.getPrice());
        System.out.println(b1 == b4); // true
        Book harry1 = Book.of("Harry Potter: The Philosopher's Stone", "J. K. rowling", 1997, 1000);
        Book harry2 = Book.of("Harry Potter: The Chamber of Secrets", "J. K. Rowling", 1998, 1000);
        List<Book> rowlingBooks = Book.getBooksByAuthor("j. k. rowling");
        System.out.println(rowlingBooks.size()); // 2
        System.out.println(rowlingBooks.get(0).getTitle()); // Harry Potter: The Philosopher's Stone
        System.out.println(rowlingBooks.get(1).getAuthor()); // J. K. Rowling

        Person bonusPerson = new Person("Joonas Boonus", 10000);
        b1.buy(bonusPerson);
        bonusPerson.buyBook(harry1);

        List<Book> personBooks = Book.getBooksByOwner(bonusPerson);
        System.out.println(personBooks.size()); // 2
        System.out.println(personBooks.contains(b1));  // true
        System.out.println(personBooks.contains(harry1)); // true
        System.out.println(bonusPerson.getMoney()); // 8997

        Book.removeBook(b1);
        personBooks = Book.getBooksByOwner(bonusPerson);
        System.out.println(personBooks.size()); // 1
        System.out.println(personBooks.contains(b1)); // false
        System.out.println(bonusPerson.getMoney()); // 9000
    }
}