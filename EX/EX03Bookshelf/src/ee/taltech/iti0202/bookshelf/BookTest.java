package ee.taltech.iti0202.bookshelf;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    /**
     * Test if a single Book creation works.
     */
    @Test void CreateSingleBook(){
        Book testBook = new Book("Apteeker Melchior ja Oleviste mõistatus",
                "Indrek Hargla",2010,20);
        String testTitle = "Apteeker Melchior ja Oleviste mõistatus",testAuthor = "Indrek Hargla";
        int testyear = 2010, testPrice = 20;
        assertEquals(testTitle,testBook.getTitle());
        assertEquals(testAuthor,testBook.getAuthor());
        assertEquals(testyear,testBook.getYearOfPublishing());
        assertEquals(testPrice,testBook.getPrice());
    }


}