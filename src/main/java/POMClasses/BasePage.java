package POMClasses;

import ReusableLibraries.TestParent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends TestParent {
    // constructor method is a bridge between a page object class and a test class
    // it allows you to initiazlise the webdriver from your test parent and logger for example to interacty with any webelement

    public BasePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }  // End of base page constructor

    // need a refrence to google home page
    // in order to use thhe methods in the test class
    // create static refrence
    public static GoogleHomePage googleHomePage(){
        GoogleHomePage googleHomePage = new GoogleHomePage(driver);
        return googleHomePage;
    }

    public static YahooHomePage yahooHomePage(){
        YahooHomePage yahooHomePage = new YahooHomePage(driver);
        return yahooHomePage;
    }
}


