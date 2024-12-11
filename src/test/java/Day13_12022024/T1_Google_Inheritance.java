package Day13_12022024;

import Day11_11252024.ReuasbleMethods;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_Google_Inheritance extends TestParent{
     @Test(priority = 1)
     public void searchForACar(){
         driver.navigate().to("https://www.google.com");
         ReuasbleMethods.sendKeysMethod(driver, "//*[@name = 'q']", "bmw", "Google Search");
         ReuasbleMethods.submitMethod(driver, "//*[@name = 'q']", "Submit");

     }

     @Test(priority = 2)
     public void captureSearchResult() throws InterruptedException {
         Thread.sleep(2000);
         ReuasbleMethods.clickMethod(driver, "//*[@id = 'hdtb-tls']", "Click");
         String Result = ReuasbleMethods.captureText(driver, "//*[@id = 'result-stats']", "Get Stats");
         System.out.println(Result);
     }

    // Write a test to make sure the google title is correct
    @Test(priority = 3)
    public void tc003_verifyGoogleTitle(){
        driver.navigate().to("https://www.google.com");
        String expectedResult = "Gogle";
        String actualResult = driver.getTitle();
        assertEqualsLogger(actualResult, expectedResult);

    }
}
