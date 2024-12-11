package Automation_ActionItem6;

import Day11_11252024.ReuasbleMethods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Assignment_One {

    // Here we create a global instance of our Webdriver
    WebDriver driver;

    // Here all the global xpaths needed for our code are created and saved as Strings for reusability and to minimize typing errors
    String siteToTest = "https://www.fideliscare.org";
    String xpathForSearchButton = "//*[@class = 'tool dropdown search']";
    String xpathForSearchInput = "//*[@class = 'form-control search-input']";
    String xpathForSubmit = "//*[@aria-label = 'Execute Search']";
    String xpathForFirstResult = "//*[@class = 'gs-title']";
    String xpathFirstName = "//*[@id = 'firstName']";
    String xpathLastName = "//*[@id = 'lastName']";
    String xpathZipCode = "//*[@id = 'zipCode']";
    String xpathPhoneNumber = "//*[@id = 'phoneNumber']";
    String xpathEmail = "//*[@id = 'email']";
    String xpathContactMe = "//*[@for = 'contactMe']";
    String xpathLogin = "//*[@class = 'tool dropdown login']";
    String xpathMemberPortal = "//*[@rel = 'noopener noreferrer']";
    String getXpathHelpfulHint = "//*[contains(text(), 'Helpful Hints')]";
    String xpathHelpfulHintPanel = "//*[@id = 'dnn_TipsContentPanel']";

    @BeforeSuite
    public void setUp(){ // Setting up the Web driver using a reusable method
        driver = ReuasbleMethods.setup();
    }

    // Here I am creating test case one which is only dependent upon the Before Suite code executing successfully
    @Test
    public void tc001_GetCoverage() throws InterruptedException {
        // Navigating to the site we need to test
        driver.navigate().to(siteToTest);

        // Click on the search button
        ReuasbleMethods.clickMethod(driver, xpathForSearchButton, "Search Button");

        // Sends the "Get dental coverage" text to the search box
        ReuasbleMethods.sendKeysMethod(driver,xpathForSearchInput , "Get Dental Coverage", "Text to search");

        // Clicks on the magnifying glass search button
        ReuasbleMethods.clickMethod(driver, xpathForSubmit,"Search Button");

        // Get the first result from the results page
        ReuasbleMethods.clickMethodWithIndex(driver, xpathForFirstResult , 1, "First result");
    }

    // Here I create test case 2 that will depend upon the outcome of test case 1
    @Test(dependsOnMethods = "tc001_GetCoverage")
    public void tc002_SendData(){
        //Switch to the new tab
        ReuasbleMethods.switchToTabByIndex(driver, 1);

        // Here I am passing in the First name
        ReuasbleMethods.sendKeysMethod(driver, xpathFirstName, "Tony", "First Name");

        // Here I am passing in the Last name
        ReuasbleMethods.sendKeysMethod(driver, xpathLastName, "Stark" , "Last Name");

        // Here I am passing in the zip code
        ReuasbleMethods.sendKeysMethod(driver, xpathZipCode, "11418", "Zip Code");

        // Here I am passing in the phone number
        ReuasbleMethods.sendKeysMethod(driver, xpathPhoneNumber, "1234567890", "Phone Number");

        // Here I am passing in the email address
        ReuasbleMethods.sendKeysMethod(driver, xpathEmail, "example@gmail.com", "Email");

        // Here I am clicking on the Contact me button
        ReuasbleMethods.clickMethod(driver, xpathContactMe, "Contact Me");

        // Here I am printing out the info we retrieved from the contact me element
        System.out.println(ReuasbleMethods.captureTextWithIndex(driver,xpathContactMe,0 , "Contact Me"));

    }

    // Here I am creating test case 3 which will be dependent upon the outcome of test case 2
    @Test(dependsOnMethods = "tc002_SendData")
    public void tc003_HelpfulHints(){

        // Here I am ensuring that the driver will switch to the correct tab to run the rest of the test case
        ReuasbleMethods.switchToTabByIndex(driver, 1);

        // Here I am clicking on the Login button using the clickMethodWithIndex which I created to select a Webelement from an arraylist of multiple web elements with the same xpath
        ReuasbleMethods.clickMethodWithIndex(driver, xpathLogin, 0, "Login");

        // Here I amd clicking on the member portal
        ReuasbleMethods.clickMethodWithIndex(driver, xpathMemberPortal, 0, "Member Portal");

        // Here I am ensuring that we switch to the correct tab in order to continue the test case
        ReuasbleMethods.switchToTabByIndex(driver, 2);

        // Here I am printing out the Helpful hint test
        System.out.println(ReuasbleMethods.captureText(driver, getXpathHelpfulHint, "Helpful Hint"));

        // Here I am printing out the test from the Helpful Hints section
        System.out.println(ReuasbleMethods.captureText(driver,xpathHelpfulHintPanel, "Helpful Hints Panel"));
    }

    // Here is the after suite code that will run once the test cases are completed
    @AfterSuite
    public void cleanUp() throws InterruptedException {

        // I included a 3 second wait just to make the process a little more user-friendly
        Thread.sleep(3000);

        // Here we close the driver and all of the tabs open in it.
        driver.quit();
    }
}
