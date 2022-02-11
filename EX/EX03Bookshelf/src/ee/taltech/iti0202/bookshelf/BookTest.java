package ee.taltech.iti0202.bookshelf;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Tester for Bookshelf.
 */
class BookTest {
    static final int TEST_YEAR = 2010;
    static final int TEST_PRICE = 20;

    /**
     * Test if a single book creation works.
     */
    @Test
    void createSingleBook() {
        Book testBook = new Book("Apteeker Melchior ja Oleviste mõistatus",
                "Indrek Hargla", 2010, 20);
        String testTitle = "Apteeker Melchior ja Oleviste mõistatus", testAuthor = "Indrek Hargla";
        assertEquals(testTitle, testBook.getTitle());
        assertEquals(testAuthor, testBook.getAuthor());
        assertEquals(TEST_YEAR, testBook.getYearOfPublishing());
        assertEquals(TEST_PRICE, testBook.getPrice());
    }


}