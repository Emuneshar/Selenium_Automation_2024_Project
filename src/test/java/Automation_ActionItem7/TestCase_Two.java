package Automation_ActionItem7;

import Day13_12022024.TestParent;
import Day14_12032024.ReuasableMethodsLoggers;
import org.testng.annotations.Test;

public class TestCase_Two extends TestParent {
    String url = "https://www.northwesternmutual.com/";
    String xpathFinancialPlanning = "//*[@id = 'nmx-nav-link-primary-investments']";
    String xpathCollegeSavings = "//*[@id = 'nmx-nav-link-primary-sub-investments-private-wealth-management']";
    String xpathStartPlanning = "//*[@id = 'college-savings-plans-page-flexible-hero-cta-primary']";
    //String xpathSaveFoorCollege = "//*[@id = 'fafa-interactive-flow-goal-card-save-for-college']";
    String xpathSaveForCollege = "//*[@id='fafa-interactive-flow-goal-card-save-for-college']";

    String xpathNext = "//*[@id = 'in-page-lead-step-1-next-button']";

    @Test
    public void tc001_verifyPrivateWealthManagementPartners() throws InterruptedException {
        driver.navigate().to(url);
        ReuasableMethodsLoggers.mouseActionHover(driver, xpathFinancialPlanning, logger, "Financial Planning Menu");
        ReuasableMethodsLoggers.clickMethod(driver, xpathCollegeSavings, logger, "College Savings");
        
        Thread.sleep(4000);
    }

}
