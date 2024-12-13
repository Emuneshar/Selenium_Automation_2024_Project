package Automation_ActionItem7;

import Day13_12022024.TestParent;
import Day14_12032024.ReuasableMethodsLoggers;
import org.testng.annotations.Test;

public class TestCase_Two extends TestParent {

    // Strings and xpath storage
    String url = "https://www.northwesternmutual.com/";
    String xpathInvestments = "//*[@id = 'nmx-nav-link-primary-investments']";
    String xpathWealthManagement = "//*[@id = 'nmx-nav-link-primary-sub-investments-private-wealth-management']";
    String xpathFindClientGroup = "//*[@id = 'private-wealth-management-pcg-directory-cta']";
    String xpathSelectAState = "//*[@id = 'private-wealth-management-pcg-directory-select']";
    String xpathResults = "//*[@class = 'sc-gJryWy leQuMl']";
    String xpathFinancialPlanning = "//*[@id = 'nmx-nav-link-primary-financial-planning']";
    String xpathEstatePlanning = "//*[@id = 'nmx-nav-link-primary-sub-estate-planning']";
    String xpathPopupClose = "//*[@id = 'onetrust-accept-btn-handler']";
    String xpathAboutPlanning = "//*[@id = 'hero-description-text-estate-planning-hero']";
    String xpathBrokerageAccounts = "//*[@id = 'nmx-nav-link-primary-sub-brokerage-accounts-services']";
    String xpathQuestionAnswer = "//*[@class = 'sc-gKseQn gNzQkc']";
    String expectedResult = "Aspen Park Financial\n" +
            "Blue Column Capital\n" +
            "Cannataro Family Capital Partners\n" +
            "DBJ Wealth Management\n" +
            "Derrenbacker, Peter\n" +
            "DiNardo, James\n" +
            "Eidlitz, David\n" +
            "Feehan Financial Services\n" +
            "Johnson Financial Planning\n" +
            "Lucas Stein, Sarah\n" +
            "Luchetta, Kevin\n" +
            "Parisi, John\n" +
            "Park Avenue Capital\n" +
            "Pioneer Financial\n" +
            "Point Wealth Management\n" +
            "Scholar Financial Group\n" +
            "SFG Wealth Management\n" +
            "Shields, Tim\n" +
            "Small World Wealth Management\n" +
            "Smith, Brad\n" +
            "Spring Street Financial\n" +
            "Stein, Kevin\n" +
            "Strategic Planning Associates\n" +
            "Tennant Financial\n" +
            "The Anderson Financial Group\n" +
            "The Atrium Financial Group";

    String textToCompare = "Having a plan for your estate—your home, your wealth, your possessions-means you can leave the legacy you want, whether that's to help your family, a charity, or an institution.";
    String textFromBrokerageAccount = "Questions about brokerage accounts and services? We've got answers.";


    // Test Case 1
    @Test
    public void tc001_verifyPrivateWealthManagementPartners() throws InterruptedException {
        driver.navigate().to(url); // Navigate to url
        ReuasableMethodsLoggers.mouseActionHover(driver, xpathInvestments, logger, "Investments"); // Hover over menu item to show hidden menu
        ReuasableMethodsLoggers.clickMethod(driver, xpathWealthManagement, logger, "Private Wealth Management"); // clicks on item from submenu, Private Wealth Management
        Thread.sleep(3000); // Sleep so the page can load before scrolling
        ReuasableMethodsLoggers.scrollByPixel(driver, 0, 300, logger); // Scroll down so the needed element wil be visible
        ReuasableMethodsLoggers.clickMethod(driver, xpathFindClientGroup, logger, "Find A Private Client Group Advisor"); // click on find an advisor
        ReuasableMethodsLoggers.selectByText(driver, xpathSelectAState, "New York",logger); // Enters state to drop down menu
        String actualResult = ReuasableMethodsLoggers.captureText(driver, xpathResults, logger, "Results"); // get slist of partners in that state
        assertEqualsLogger(actualResult, expectedResult); // checks if the list is matched to what should be there
    } // End of test case 1

    // Test Case 2
    @Test
    public void tc002_WhoNeedsAnEstatePlan(){
        driver.navigate().to(url); // Navigate to url
        ReuasableMethodsLoggers.mouseActionHover(driver, xpathFinancialPlanning, logger, "Financial Planning"); // Hover over menu item to show hidden menu
        ReuasableMethodsLoggers.clickMethod(driver, xpathEstatePlanning, logger, "Estate Planning"); // clicks on item from submenu, Estate planning
        ReuasableMethodsLoggers.clickMethod(driver, xpathPopupClose, logger,"Close pop up"); // closes pop up on the bottom of the page
        String actualText = ReuasableMethodsLoggers.captureText(driver, xpathAboutPlanning, logger, "Text to check"); // gets the text from the site
        assertEqualsLogger(actualText, textToCompare); // compares text from the site against what should be there
    } // End of test case 2

    // Test Case 3
    @Test
    public void tc003_VerifyTextBrokerageAccount(){
        driver.navigate().to(url); // Navigate to url
        ReuasableMethodsLoggers.mouseActionHover(driver, xpathInvestments, logger, "Investments"); // Hover over menu item to show hidden menu
        ReuasableMethodsLoggers.clickMethod(driver, xpathBrokerageAccounts, logger, "Brokerage accounts"); // clicks on item from submenu, Brokerage accounts
        String actualText = ReuasableMethodsLoggers.captureText(driver, xpathQuestionAnswer, logger, "Hero Text"); // gets the text from the site
        assertEqualsLogger(actualText, textFromBrokerageAccount); // compares text from the site against what should be there
    } // End of test case 3

} // End of test class
