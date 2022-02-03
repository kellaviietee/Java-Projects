package ee.taltech.iti0202.webbrowser;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WebBrowser {
    public String currentHomePage;
    public List<String> webHistory;
    public String currentPage;
    public List<String> backPages;
    public List<String> forwardPages;
    public List<String> bookmarks;

    public WebBrowser() {
        this.currentHomePage = "google.com";
        this.currentPage = currentHomePage;
        this.webHistory = new ArrayList<>();
        this.backPages = new ArrayList<>();
        this. forwardPages = new ArrayList<>();
        this.bookmarks = new ArrayList<>();
        webHistory.add(currentHomePage);
    }

    /**
     * Goes to homepage.
     */
    public void homePage() {


    }

    /**
     * Goes back to previous page.
     */
    public void back() {



    }

    /**
     * Goes forward to next page.
     */
    public void forward() {

    }

    /**
     * Go to a webpage.
     *
     * @param url url to go to
     */
    public void goTo(String url) {
        currentPage = url;
    }

    /**
     * Add a webpage as a bookmark.
     */
    public void addAsBookmark() {

    }

    /**
     * Remove a bookmark.
     *
     * @param bookmark to remove
     */
    public void removeBookmark(String bookmark) {


    }

    public List<String> getBookmarks() {

        return null;
    }

    public void setHomePage(String homePage) {


    }


    /**
     * Get top 3 visited pages.
     *
     * @return a String that contains top three visited pages separated with a newline "\n"
     */
    public String getTop3VisitedPages() {

        return null;
    }

    /**
     * Returns a list of all visited pages.
     *
     * Not to be confused with pages in your back-history.
     *
     * For example, if you visit "facebook.com" and hit back(),
     * then the whole history would be: ["google.com", "facebook.com", "google.com"]
     * @return list of all visited pages
     */
    public List<String> getHistory() {

        return webHistory;
    }


    /**
     * Returns the active web page (string).
     *
     * @return active web page
     */
    public String getCurrentUrl() {
        return currentPage;
    }
}