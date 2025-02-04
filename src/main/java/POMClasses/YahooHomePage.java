package POMClasses;

import ReusableLibraries.ReusableMethodsLogger_POM;
import ReusableLibraries.TestParent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YahooHomePage extends TestParent {

    public YahooHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.logger = TestParent.logger;
    }//end of yahoo homepage constructor
    @FindBy(xpath = "//*[@id = 'uh-sbq']")
    WebElement yahooSearchField;
    @FindBy (xpath = "//*[@aria-label= 'Search the web']")
    WebElement yahooSearchButton;
    public void searchInYahoo(String userData) {
        ReusableMethodsLogger_POM.sendKeysMethod(driver, yahooSearchField, userData, logger, "Search Field");
    }
    public void submitOnYahooSearch(){
        ReusableMethodsLogger_POM.submitMethod(driver,yahooSearchButton,logger,"Google Search Button");
    }

}
