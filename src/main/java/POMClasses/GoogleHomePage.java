package POMClasses;

import ReusableLibraries.ReusableMethodsLogger_POM;
import ReusableLibraries.TestParent;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage extends TestParent {

    ExtentTest logger;
    public GoogleHomePage (WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = TestParent.logger;
    }//end of google homepage constructor

    @FindBy(xpath = "//*[@name = 'q']")
    WebElement googleSearchField;

    @FindBy (xpath = "//*[@name = 'btnK']")

    WebElement googleSearchButton;

    public void searchInGoogle(String userData) {
        ReusableMethodsLogger_POM.sendKeysMethod(driver, googleSearchField, userData, logger, "Search Field");
    }

    public void submitOnGoogleSearch(){
        ReusableMethodsLogger_POM.submitMethod(driver,googleSearchButton,logger,"Google Search Button");
    }

}
