package ee.taltech.iti0202.bookshelf;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


/**
 * Tester for Bookshelf.
 */
class BookTest {
    static final int TEST_YEAR = 2010;
    static final int TEST_PRICE = 20;
    static final int FIRST_ID = 0;
    static final int SECOND_ID = 1;
    static final int NO_MONEY = 0;

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
     * Test if the First available ID is 0
     */
    @Test
    void testFirstId() {
        assertEquals(FIRST_ID, Book.availableId);
    }

    /**
     * Test available ID after one Book
     */
    @Test
    void testIdAfterBook(){
        Book testBook = new Book("Apteeker Melchior ja Oleviste mõistatus",
                "Indrek Hargla", TEST_YEAR, TEST_PRICE);
        assertEquals(SECOND_ID,Book.availableId);
    }
    /**
     * Test Person buying null book.
     */
    @Test
    void TestPersonBuyNullBook(){
        Person testPerson = new Person("Lauri",100);
        assertFalse(testPerson.buyBook(null));

    }

    /**
     * Test Person buying book with no money.
     */
    @Test
    void TestPersonBuyBookNoMoney(){
        Book testBook = new Book("Apteeker Melchior ja Oleviste mõistatus",
                "Indrek Hargla", TEST_YEAR, TEST_PRICE);
        Person testPerson = new Person("Lauri",NO_MONEY);
        assertEquals(false,testPerson.buyBook(testBook));
    }
}

