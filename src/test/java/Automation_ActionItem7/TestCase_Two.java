package Automation_ActionItem7;

import Day13_12022024.TestParent;
import Day14_12032024.ReuasableMethodsLoggers;
import org.testng.annotations.Test;

public class TestCase_Two extends TestParent {
    String url = "https://www.northwesternmutual.com/";
    String xpathFinancialPlanning = "//*[@id = 'nmx-nav-link-primary-financial-planning']";

    @Test
    public void tc001_verifyConnectToAdvisor(){
        driver.navigate().to(url);
        ReuasableMethodsLoggers.mouseActionHover(driver, xpathFinancialPlanning, logger, "Financial Planning Menu");
    }
}
