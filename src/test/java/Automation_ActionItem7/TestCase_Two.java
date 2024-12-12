package Automation_ActionItem7;

import Day13_12022024.TestParent;
import Day14_12032024.ReuasableMethodsLoggers;
import org.testng.annotations.Test;

public class TestCase_Two extends TestParent {
    String url = "https://www.northwesternmutual.com/";
    String xpathFinancialPlanning = "//*[@id = 'nmx-nav-link-primary-financial-planning']";
    String xpathCollegeSavings = "//*[@id = 'nmx-nav-link-primary-sub-college-savings-plans']";
    String xpathStartPlanning = "//*[@id = 'college-savings-plans-page-flexible-hero-cta-primary']";

    @Test
    public void tc001_verifyConnectToAdvisor() throws InterruptedException {
        driver.navigate().to(url);
        ReuasableMethodsLoggers.mouseActionHover(driver, xpathFinancialPlanning, logger, "Financial Planning Menu");
        ReuasableMethodsLoggers.clickMethod(driver, xpathCollegeSavings, logger, "College Savings");
        ReuasableMethodsLoggers.clickMethod(driver, xpathStartPlanning, logger, "Start Planning");
        Thread.sleep(4000);
    }

}
