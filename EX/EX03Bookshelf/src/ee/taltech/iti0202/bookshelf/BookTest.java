package ee.taltech.iti0202.bookshelf;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Tester for Bookshelf.
 */
class BookTest {
    static final int TEST_YEAR = 2010;
    static final int TEST_PRICE = 20;
    static final int FIRST_ID = 0;

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
     * Test if the First ID is 0
     */
    @Test
    void testFirstId() {
        assertEquals(FIRST_ID, Book.availableId);
    }
}

