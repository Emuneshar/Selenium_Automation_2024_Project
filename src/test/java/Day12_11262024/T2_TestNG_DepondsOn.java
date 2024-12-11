package Day12_11262024;

import Day11_11252024.ReuasbleMethods;
import Day13_12022024.TestParent;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class T2_TestNG_DepondsOn extends TestParent {
    // define global driver so it can be used throughout the project


    @Test
    public void searchForACar(){
        driver.navigate().to("https://www.google.com");
        ReuasbleMethods.sendKeysMethod(driver, "//*[@name = 'q']", "bmw", "Google Search");
        ReuasbleMethods.submitMethod(driver, "//*[@name = 'q']", "Submit");

    }

    @Test(dependsOnMethods = "searchForACar")
    public void captureSearchResult(){
        ReuasbleMethods.clickMethod(driver, "//*[@id = 'hdtb-tls']", "Click");
        String Result = ReuasbleMethods.captureText(driver, "//*[@id = 'result-stats']", "Get Stats");
        System.out.println(Result);
    }


}
