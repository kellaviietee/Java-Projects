package ee.taltech.iti0202.bookshelf;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tester for Bookshelf.
 */
class BookTest {
    private static final int TEST_YEAR = 2010;
    private static final int TEST_PRICE = 20;
    private static final int SECOND_TEST_PRICE = 30;
    private static final int FIRST_ID = 0;
    private static final int SECOND_ID = 1;
    private static final int NO_MONEY = 0;
    private static final int ENOUGH_MONEY = 200;
    /**
     * Test if the First available ID is 0
     */
    /*@Test
    void testFirstId() {
        assertEquals(FIRST_ID, Book.availableId);
    }

    /**
     * Test available ID after one Book
     */

    /*@Test
    void testIdAfterBook(){
        Book testBook = new Book("Apteeker Melchior ja Oleviste mõistatus",
                "Indrek Hargla", TEST_YEAR, TEST_PRICE);
        assertEquals(SECOND_ID,Book.availableId);
    }
    /**
     * Test if a single book creation works.
     */
    @Test
    void createSingleBook() {
        Book testBook = new Book("Apteeker Melchior ja Oleviste mõistatus",
                "Indrek Hargla", TEST_YEAR, TEST_PRICE);
        String testTitle = "Apteeker Melchior ja Oleviste mõistatus", testAuthor = "Indrek Hargla";
        assertEquals(testTitle, testBook.getTitle());
        assertEquals(testAuthor, testBook.getAuthor());
        assertEquals(TEST_YEAR, testBook.getYearOfPublishing());
        assertEquals(TEST_PRICE, testBook.getPrice());
    }


    /**
     * Test Person buying null book.
     */
    @Test
    void testPersonBuyNullBook(){
        Person testPerson = new Person("Lauri",100);
        assertFalse(testPerson.buyBook(null));

    }

    /**
     * Test Person buying book with no money.
     */
    @Test
    void testPersonBuyBookNoMoney(){
        Book testBook = new Book("Apteeker Melchior ja Pirita kägistaja",
                "Indrek Hargla", TEST_YEAR, TEST_PRICE);
        Person testPerson = new Person("Lauri",NO_MONEY);
        assertEquals(false,testPerson.buyBook(testBook));
    }
    /**
     * Test Person buying book.
     */
    @Test
    void testPersonSellBook(){
        Book testBook = new Book("Apteeker Melchior ja Oleviste mõistatus",
                "Indrek Hargla", TEST_YEAR, TEST_PRICE);
        Person testPerson = new Person("Lauri",ENOUGH_MONEY);
        assertEquals(true,testPerson.buyBook(testBook));
    }
    /**
     * Test Book owner after buying
     */
    @Test
    void testGetBookOwner(){
        Book testBook = new Book("Apteeker Melchior ja Oleviste mõistatus",
                "Indrek Hargla", TEST_YEAR, TEST_PRICE);
        Person testPerson = new Person("Lauri",ENOUGH_MONEY);
        testPerson.buyBook(testBook);
        assertEquals(testPerson,testBook.getOwner());
    }
    /**
     * Test Book ID after a book is spawned.
     */
    /*@Test
    void testGetBookID(){
        Book testBook = new Book("Apteeker Melchior ja Oleviste mõistatus",
                "Indrek Hargla", TEST_YEAR, TEST_PRICE);
        assertEquals(4,testBook.getId());
    }

    /**
     * Test buying a book with null buyer and no owner.
     */
    @Test
    void testBookBuyBuyerNullOwnerNull(){
        Book testBook = new Book("Apteeker Melchior ja Oleviste mõistatus",
                "Indrek Hargla", TEST_YEAR, TEST_PRICE);
        assertFalse(testBook.buy(null));

    }

    /**
     * Test buying a book with null buyer but has an owner.
     */
    @Test
    void testBookBuyBuyerNullOwnerNotNull(){
        Book testBook = new Book("Apteeker Melchior ja Oleviste mõistatus",
                "Indrek Hargla", TEST_YEAR, TEST_PRICE);
        testBook.owner = new Person("Lauri",ENOUGH_MONEY);
        assertTrue(testBook.buy(null));

    }
    /**
     * Test Person trying to buy with No money.
     */
    @Test
    void testBookBuyBuyerNoMoney(){
        Book testBook = new Book("Apteeker Melchior ja Oleviste mõistatus",
                "Indrek Hargla", TEST_YEAR, TEST_PRICE);
        Person testPerson = new Person("Lauri",ENOUGH_MONEY);
        testBook.owner = testPerson;
        Person testPerson2 = new Person("Madis",NO_MONEY);
        assertFalse(testBook.buy(testPerson2));
    }
    /**
     * Test Person trying to buy own Book.
     */
    @Test
    void testBookBuyBuyerOwnsBook(){
        Book testBook = new Book("Apteeker Melchior ja Oleviste mõistatus",
                "Indrek Hargla", TEST_YEAR, TEST_PRICE);
        Person testPerson = new Person("Lauri",ENOUGH_MONEY);
        testBook.owner = testPerson;
        assertFalse(testBook.buy(testPerson));

    }
    /**
     * Test Person trying to buy own with enough money.
     */
    @Test
    void testBookBuyAllCorrect(){
        Book testBook = new Book("Apteeker Melchior ja Oleviste mõistatus",
                "Indrek Hargla", TEST_YEAR, TEST_PRICE);
        Person testPerson = new Person("Lauri",ENOUGH_MONEY);
        testBook.owner = testPerson;
        Person testPerson2 = new Person("Madis",ENOUGH_MONEY);
        assertTrue(testBook.buy(testPerson2));

    }
    /**
     * Test creating a Book with first Bookof constructor.
     */
    @Test
    void testBookOfConstructor1(){
        Book.books.clear();
        Book testBook = Book.of("Apteeker Melchior ja Oleviste mõistatus",
                "Indrek Hargla", TEST_YEAR, TEST_PRICE);
        assertEquals(1,Book.books.size());
    }
    /**
     * Test adding the same Book twice.
     */
    @Test
    void testBookOfTwoSameBooks(){
        Book.books.clear();
        Book testBook = Book.of("Apteeker Melchior ja Oleviste mõistatus",
                "Indrek Hargla", TEST_YEAR, TEST_PRICE);
        Book sameBook = Book.of("Apteeker Melchior ja Oleviste mõistatus",SECOND_TEST_PRICE);
        assertEquals(sameBook,testBook);
    }
    /**
     * Test Second constructor is Null when no previously added books.
     */
    @Test
    void testConstructorWithNoPrevious(){
        Book sameBook = Book.of("Apteeker Melchior ja Oleviste mõistatus",SECOND_TEST_PRICE);
        assertNull(sameBook);
    }
    /**
     * Test books getter is correct.
     */
    @Test
    void testBooksGetter(){
        Book FirstBook = Book.of("Apteeker Melchior ja Oleviste mõistatus",
                "Indrek Hargla",2010,SECOND_TEST_PRICE);
        Book SecondBook = Book.of("Apteeker Melchior ja Rataskaevu viirastus",TEST_PRICE);
        List<Book> testList = new ArrayList<>();
        testList.add(FirstBook);
        testList.add(SecondBook);
        assertEquals(testList,Book.getBooks());
        assertEquals(testList,Book.getBooksByAuthor("Indrek Hargla"));
    }
    /**
     * Test removing books not on the list.
     */
    @Test
    void testBookRemovingNotExistingBook(){
        Book nonRemovableBook = new Book("Apteeker Melchior ja Gotlandi kurat",
                "Indrek Hargla",2017,SECOND_TEST_PRICE);
        assertFalse(Book.removeBook(nonRemovableBook));
    }
    /**
     * Test removing book on the list.
     */
    @Test
    void testBookRemovingExistingBook(){
        Book FirstBook = Book.of("Apteeker Melchior ja Oleviste mõistatus",
                "Indrek Hargla",2010,SECOND_TEST_PRICE);
        assertTrue(Book.removeBook(FirstBook));
    }



}

