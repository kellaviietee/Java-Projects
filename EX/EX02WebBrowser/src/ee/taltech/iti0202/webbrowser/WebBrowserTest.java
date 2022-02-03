package ee.taltech.iti0202.webbrowser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WebBrowserTest {

    @Test
    public void homePageTest(){
        WebBrowser webBrowser = new WebBrowser();
        String newHomePage = "neti.ee";
        webBrowser.setHomePage(newHomePage);
        webBrowser.homePage();
        assertEquals("neti.ee",webBrowser.currentHomePage);
    }

}