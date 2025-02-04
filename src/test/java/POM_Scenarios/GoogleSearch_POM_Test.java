package POM_Scenarios;

import POMClasses.BasePage;
import ReusableLibraries.TestParent;
import org.testng.annotations.Test;

public class GoogleSearch_POM_Test extends TestParent {
    @Test(priority = 1)
    public void tc001_searchForACar() throws InterruptedException {
        //navigate to google home page
        driver.navigate().to("https://www.google.com");
        //search for a car
        BasePage.googleHomePage().searchInGoogle("BMW");
        //hit submit
        BasePage.googleHomePage().submitOnGoogleSearch();
        Thread.sleep(2000);
    }//end of test case 1
}
