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
        this.webHistory = new ArrayList<>();
        this.currentHomePage = "google.com";
        this.currentPage = currentHomePage;
        this.webHistory = new ArrayList<>();
        this.backPages = new ArrayList<>();
        this. forwardPages = new ArrayList<>();
        this.bookmarks = new ArrayList<>();
    }

    /**
     * Goes to homepage.
     */
    public void homePage() {
        goTo(currentHomePage);
    }

    /**
     * Goes back to previous page.
     */
    public void back() {
        if(!backPages.isEmpty()) {
            String previousPage = backPages.get(0);
            backPages.remove(0);
            forwardPages.add(currentPage);
            goTo(previousPage);
        }


    }

    /**
     * Goes forward to next page.
     */
    public void forward() {
        if(!forwardPages.isEmpty()){
            String forwardPage = forwardPages.get(0);
            forwardPages.remove(0);
            goTo(forwardPage);
        }
    }

    /**
     * Go to a webpage.
     *
     * @param url url to go to
     */
    public void goTo(String url) {
        if(!Objects.equals(currentPage, url)) {
            backPages.add(currentPage);
            webHistory.add(currentPage);
            forwardPages.clear();
        }
        currentPage = url;
    }

    /**
     * Add a webpage as a bookmark.
     */
    public void addAsBookmark() {
        String currentPage = getCurrentUrl();
        if(!bookmarks.contains(currentPage)){
            bookmarks.add(currentPage);
        }
    }

    /**
     * Remove a bookmark.
     *
     * @param bookmark to remove
     */
    public void removeBookmark(String bookmark) {
        bookmarks.remove(bookmark);
    }

    public List<String> getBookmarks() {
        return bookmarks;
    }

    public void setHomePage(String homePage) {
        currentHomePage = homePage;

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