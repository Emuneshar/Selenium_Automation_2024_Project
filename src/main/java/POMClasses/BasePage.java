package POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static ReusableLibraries.TestParent.driver;

public class BasePage {
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

/*//constructor method is a bridge between a page object class and test class
//it allows you to initialize the webdriver from your test parent and logger for example to interact with any web element (xpath)
//this applies to all individual pages
public BasePage (WebDriver driver){
    PageFactory.initElements(driver,this);
}// end of base page constructor
//need a reference to google home page
//in order to use the methods in test class
//create static reference
public static GoogleHomePage googleHomePage(){
    GoogleHomePage googleHomePage = new GoogleHomePage(driver);
    return googleHomePage;
}//end of google homepage constructor
public static YahooHomePage yahooHomePage(){
    YahooHomePage yahooHomePage = new YahooHomePage(driver);
    return yahooHomePage;
}//end of yahoo home page constructor*/
