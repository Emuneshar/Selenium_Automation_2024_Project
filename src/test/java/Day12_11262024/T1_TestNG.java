package Day12_11262024;


import Day11_11252024.ReuasbleMethods;
import Day11_11252024.T1_USPS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;

public class T1_TestNG {

    // define global driver so it can be used throughout the project
    WebDriver driver;
    @BeforeSuite
    public void setUpChromeDriver(){
        driver = ReuasbleMethods.setup();
    }

    @Test(priority = 1)
    public void searchForACar(){
        driver.navigate().to("https://www.google.com");
        ReuasbleMethods.sendKeysMethod(driver, "//*[@name = 'q']", "bmw", "Google Search");
        ReuasbleMethods.submitMethod(driver, "//*[@name = 'q']", "Submit");

    }

    @Test(priority = 2)
    public void captureSearchResult(){
        ReuasbleMethods.clickMethod(driver, "//*[@id = 'hdtb-tls']", "Click");
        String Result = ReuasbleMethods.captureText(driver, "//*[@id = 'result-stats']", "Get Stats");
        System.out.println(Result);
    }
}
