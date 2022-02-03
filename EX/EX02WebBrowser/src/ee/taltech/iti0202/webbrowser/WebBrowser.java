package ee.taltech.iti0202.webbrowser;
import java.text.MessageFormat;
import java.util.*;

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
        goTo(currentHomePage);


    }

    /**
     * Goes back to previous page.
     */
    public void back() {
        if(!backPages.isEmpty()) {
            String previousPage = backPages.get(backPages.size() - 1);
            backPages.remove(backPages.size() - 1);
            forwardPages.add(currentPage);
            currentPage = previousPage;
            webHistory.add(currentPage);
        }



    }

    /**
     * Goes forward to next page.
     */
    public void forward() {
        if(!forwardPages.isEmpty()){
            backPages.add(currentPage);
            String nextPage = forwardPages.get(forwardPages.size()-1);
            forwardPages.remove(forwardPages.size()-1);
            currentPage = nextPage;
            webHistory.add(nextPage);
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
            currentPage = url;
            webHistory.add(url);
            forwardPages.clear();
        }

    }

    /**
     * Add a webpage as a bookmark.
     */
    public void addAsBookmark() {
        if(!bookmarks.contains(currentPage)) {
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
        Map<String, Integer> topVisited = new HashMap<>();
        Set<String> uniquePages = new HashSet<>(webHistory);
        List<String> uniqueList = new ArrayList<>(uniquePages);
        for (String page : uniquePages) {
            Integer visited = Collections.frequency(webHistory, page);
            topVisited.put(page, visited);
        }
        uniqueList.sort((o1, o2) -> {
            if (topVisited.get(o1) > topVisited.get(o2)) {
                return -1;
            }
            return 1;
        });
        StringBuilder finalString = new StringBuilder();
        int topCounter = 1;
        for(String page : uniqueList){
            if (topCounter > 3){
                break;
            }
            Integer visitNumber = topVisited.get(page);
            if (visitNumber == 1){
                finalString.append(page).append(" - 1 visit\n");

            }
            else{
                finalString.append(page).append(" - ").append(visitNumber).append(" visits\n");
            }
            topCounter++;
        }
        String trimmedFinalString = finalString.toString().trim();
        System.out.println(trimmedFinalString);
        return trimmedFinalString;
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
    public void testing(){
        goTo("neti.ee");
        goTo("facebook.com");
        goTo("youtube.com");
        goTo("facebook.com");
        goTo("google.com");
        goTo("facebook.com");
        goTo("youtube.com");
        goTo("google.com");
        goTo("facebook.com");
        getTop3VisitedPages();
    }
}