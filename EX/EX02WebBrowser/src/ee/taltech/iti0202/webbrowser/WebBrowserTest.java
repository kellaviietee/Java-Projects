package ee.taltech.iti0202.webbrowser;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class WebBrowserTest {

    @Test
    /*
    Tests if going to the same Page keeps History the same length.
     */
    void testSamePageSameHistory() {
        WebBrowser webBrowser = new WebBrowser();
        for (int i = 0; i < 1000; i++) {
            webBrowser.goTo("google.com");
        }
        assertEquals(1, webBrowser.getHistory().size());
    }

    @Test
    /*
    Test going to 10000 pages then back once and then forward once.
     */
    void test10000PagesThenBackThenForward() {
        int testablePages = 10000;
        WebBrowser webBrowser = new WebBrowser();
        for (int i = 0; i < testablePages; i++) {
            webBrowser.goTo("Page" + (i + 1));
        }
        webBrowser.back();
        webBrowser.forward();
        assertEquals("Page10000", webBrowser.getCurrentUrl());
    }

    @Test
    /*
    Test if browser history adds all the pages.
     */
    void testHistory100Pages() {
        int MAXPAGES = 10000;
        WebBrowser webBrowser = new WebBrowser();
        List<String> testHistory = new ArrayList<>();
        testHistory.add("google.com");
        for (int i = 0; i < MAXPAGES; i++) {
            webBrowser.goTo("Page" + (i + 1));
            testHistory.add("Page" + (i + 1));
        }
        assertEquals(testHistory, webBrowser.getHistory());
    }

    @Test
    /*
    Test where Browser goes when Back button is pressed with no BackPages.
     */
    void testBackNoPages() {
        WebBrowser webBrowser = new WebBrowser();
        webBrowser.back();
        assertEquals("google.com", webBrowser.getCurrentUrl());
    }

    @Test
    /*
    Test if setting a new Homepage and going there works as intended.
     */
    void testHomeButtonWithNewHomePage() {
        WebBrowser webBrowser = new WebBrowser();
        webBrowser.setHomePage("neti.ee");
        webBrowser.homePage();
        assertEquals("neti.ee", webBrowser.getCurrentUrl());
    }

    @Test
    /*
    Go 10000 unique Page, then pressing 10000 time back button and then 10000 times forward button.
     */
    void testGoTo10000PagesThenBack10000TimesThenForward10000Times() {
        int MAXPAGES = 10000;
        WebBrowser webBrowser = new WebBrowser();
        for (int i = 0; i < MAXPAGES; i++) {
            webBrowser.goTo("Page" + (i + 1));
        }
        for (int i = 0; i < MAXPAGES; i++) {
            webBrowser.back();
        }
        for (int i = 0; i < MAXPAGES; i++) {
            webBrowser.forward();
        }
        assertEquals("Page10000", webBrowser.getCurrentUrl());
    }

    @Test
    /*
    Test to see browsers history when no new pages have been visited.
     */
    void historyNoPagesVisited() {
        WebBrowser webBrowser = new WebBrowser();
        List<String> testHistory = new ArrayList<>();
        testHistory.add("google.com");
        assertEquals(testHistory, webBrowser.getHistory());
    }

    @Test
    /*
    Test if removing a bookmark works.
     */
    void testRemoveBookmark() {
        List<String> testBookmarks = new ArrayList<>();
        WebBrowser webBrowser = new WebBrowser();
        webBrowser.goTo("neti.ee");
        webBrowser.addAsBookmark();
        webBrowser.goTo("facebook.com");
        webBrowser.addAsBookmark();
        testBookmarks.add("facebook.com");
        webBrowser.goTo("youtube.com");
        webBrowser.addAsBookmark();
        testBookmarks.add("youtube.com");
        webBrowser.removeBookmark("neti.ee");
        assertEquals(testBookmarks, webBrowser.getBookmarks());
    }

    @Test
    /*
    Test going to 100 new page, then going 30 pages back, then 5 forward and then back again.
     */
    void test100Pages30Back5GoTo30Back() {
        int FIRSTGOTOPAGES = 100;
        int FIRSTBACKPAGES = 30;
        int SECONDGOTOPAGES = 5;
        int SECONDBACKPAGES = 30;
        WebBrowser webBrowser = new WebBrowser();
        for (int i = 0; i < FIRSTGOTOPAGES; i++) {
            webBrowser.goTo("Page" + (i + 1));
        }
        for (int i = 0; i < FIRSTBACKPAGES; i++) {
            webBrowser.back();
        }
        for (int i = 0; i < SECONDGOTOPAGES; i++) {
            webBrowser.goTo("Page" + (i + 1));
        }
        for (int i = 0; i < SECONDBACKPAGES; i++) {
            webBrowser.back();
        }
        assertEquals("Page45", webBrowser.getCurrentUrl());
    }

    @Test
    /*
    Test if adding a bookmark works.
     */
    void testAddBookmark() {
        List<String> testBookmarks = new ArrayList<>();
        testBookmarks.add("facebook.com");
        WebBrowser webBrowser = new WebBrowser();
        webBrowser.goTo("facebook.com");
        webBrowser.addAsBookmark();
        assertEquals(testBookmarks, webBrowser.getBookmarks());

    }
    @Test
    /*
    Test if adding the same bookmark twice does not add the same bookmark twice.
     */
    void testAddBookmarkTwice() {
        List<String> testBookmarks = new ArrayList<>();
        testBookmarks.add("facebook.com");
        WebBrowser webBrowser = new WebBrowser();
        webBrowser.goTo("facebook.com");
        webBrowser.addAsBookmark();
        webBrowser.addAsBookmark();
        assertEquals(testBookmarks, webBrowser.getBookmarks());

    }
    @Test
    /*
    Test Top3 visited pages when user has not left the homepage.
     */
    void testTopPagesWithHome() {
        String testTopPages = "google.com - 1 visit";
        WebBrowser webBrowser = new WebBrowser();
        assertEquals(testTopPages,webBrowser.getTop3VisitedPages());
    }
    @Test
    /*
    Test Top3 visited Pages when ony two different pages have been visited.
     */
    void testTopPages2Pages() {
        String testTopPages = "google.com - 2 visits\nfacebook.com - 2 visits";
        WebBrowser webBrowser = new WebBrowser();
        webBrowser.goTo("facebook.com");
        webBrowser.back();
        webBrowser.forward();
        assertEquals(testTopPages,webBrowser.getTop3VisitedPages());
    }
    @Test
    /*
    Test Top3Pages, with same visits but first in history being on first position.
     */
    void testTopPages3DifferentPages() {
        String testTopPages = "facebook.com - 4 visits\nneti.ee - 4 visits\nyoutube.com - 3 visits";
        WebBrowser webBrowser = new WebBrowser();
        webBrowser.goTo("facebook.com");
        webBrowser.goTo("neti.ee");
        webBrowser.goTo("facebook.com");
        webBrowser.goTo("neti.ee");
        webBrowser.goTo("youtube.com");
        webBrowser.goTo("facebook.com");
        webBrowser.goTo("neti.ee");
        webBrowser.goTo("youtube.com");
        webBrowser.goTo("neti.ee");
        webBrowser.goTo("youtube.com");
        webBrowser.goTo("facebook.com");
        assertEquals(testTopPages,webBrowser.getTop3VisitedPages());
    }
    @Test
    /*
    Test for 10000 Forward pressings.
     */
    void testEmptyForward() {
        int MAXPAGES = 10000;
        WebBrowser webBrowser = new WebBrowser();
        for (int i = 0; i < MAXPAGES; i++) {
            webBrowser.forward();
        }
        assertEquals("google.com",webBrowser.getCurrentUrl());
    }
}
