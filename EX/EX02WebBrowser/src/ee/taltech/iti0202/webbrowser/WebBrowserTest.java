package ee.taltech.iti0202.webbrowser;

import static org.junit.jupiter.api.Assertions.*;

class WebBrowserTest {

    @org.junit.jupiter.api.Test
    void homePage() {
    }

    @org.junit.jupiter.api.Test
    void back() {
    }

    @org.junit.jupiter.api.Test
    void forward() {
    }

    @org.junit.jupiter.api.Test
    void goTo() {
        WebBrowser webBrowser = new WebBrowser();
        webBrowser.goTo("neti.ee");
        assertEquals("neti.ee",webBrowser.getCurrentUrl());
    }

    @org.junit.jupiter.api.Test
    void addAsBookmark() {
    }

    @org.junit.jupiter.api.Test
    void removeBookmark() {
    }

    @org.junit.jupiter.api.Test
    void getBookmarks() {
    }

    @org.junit.jupiter.api.Test
    void setHomePage() {
        WebBrowser webBrowser = new WebBrowser();
        webBrowser.setHomePage("neti.ee");
    }

    @org.junit.jupiter.api.Test
    void getTop3VisitedPages() {
    }

    @org.junit.jupiter.api.Test
    void getHistory() {
        WebBrowser webBrowser = new WebBrowser();
        webBrowser.setHomePage("neti.ee");
        webBrowser.goTo("facebook.com");
        webBrowser.back();
        webBrowser.back();
        String[] testArray = {"google.com", "facebook.com", "google.com"};
        assertArrayEquals(testArray,webBrowser.getHistory().toArray());
    }

    @org.junit.jupiter.api.Test
    void getCurrentUrl() {
    }
}