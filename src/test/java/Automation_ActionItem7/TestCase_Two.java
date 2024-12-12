package Automation_ActionItem7;

import Day13_12022024.TestParent;
import Day14_12032024.ReuasableMethodsLoggers;
import org.testng.annotations.Test;

public class TestCase_Two extends TestParent {
    String url = "https://www.northwesternmutual.com/";
    String xpathInvestments = "//*[@id = 'nmx-nav-link-primary-investments']";
    String xpathWealthManagement = "//*[@id = 'nmx-nav-link-primary-sub-investments-private-wealth-management']";
    String xpathFindClientGroup = "//*[@id = 'private-wealth-management-pcg-directory-cta']";
    String xpathSelectAState = "//*[@id = 'private-wealth-management-pcg-directory-select']";
    String xpathResults = "//*[@class = 'sc-gJryWy leQuMl']";

    @Test
    public void tc001_verifyPrivateWealthManagementPartners() throws InterruptedException {
        driver.navigate().to(url);
        ReuasableMethodsLoggers.mouseActionHover(driver, xpathInvestments, logger, "Financial Planning Menu");
        ReuasableMethodsLoggers.clickMethod(driver, xpathWealthManagement, logger, "College Savings");
        Thread.sleep(3000);
        ReuasableMethodsLoggers.scrollByPixel(driver, 0, 300, logger);
        ReuasableMethodsLoggers.clickMethod(driver, xpathFindClientGroup, logger, "Find A Private Client Group Advisor");
        ReuasableMethodsLoggers.selectByText(driver, xpathSelectAState, "New York",logger);
        ReuasableMethodsLoggers.captureText(driver, xpathResults, logger, "Results");
        Thread.sleep(4000);
    }

}
