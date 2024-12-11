package Day14_12032024;

import Day11_11252024.ReuasbleMethods;
import Day13_12022024.TestParent;
import org.testng.annotations.Test;

public class T1_Google_Inheritcance_With_Logger extends TestParent {

    @Test(priority = 1)
    public void searchForACar(){
        driver.navigate().to("https://www.google.com");
        ReuasableMethodsLoggers.sendKeysMethod(driver, "//*[@name = 'q']", "bmw", logger,  "Google Search");
        ReuasableMethodsLoggers.submitMethod(driver, "//*[@name = 'q']", logger, "Submit");

    }

    @Test(priority = 2)
    public void captureSearchResult() throws InterruptedException {
        Thread.sleep(2000);
        ReuasableMethodsLoggers.clickMethod(driver, "//*[@id = 'hdtb-tls']", logger, "Click");
        String Result = ReuasableMethodsLoggers.captureText(driver, "//*[@id = 'result-stats']", logger, "Get Stats");
        System.out.println(Result);
    }

    // Write a test to make sure the google title is correct
    @Test(priority = 3)
    public void tc003_verifyGoogleTitle(){
        driver.navigate().to("https://www.google.com");
        String expectedResult = "Google";
        String actualResult = driver.getTitle();
        assertEqualsLogger(actualResult, expectedResult);

    }
}
