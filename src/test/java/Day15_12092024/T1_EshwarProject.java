package Day15_12092024;

import Day13_12022024.TestParent;
import Day14_12032024.ReuasableMethodsLoggers;
import org.testng.annotations.Test;

public class T1_EshwarProject extends TestParent {

    String xpathForMenu = "//*[@id = 'nmx-nav-link-primary-insurance']";

    @Test
    public void tc001_verifyDifferentLifeInsurancePolicies() throws InterruptedException {
        //navigate to northwestern website
        driver.navigate().to("https://www.northwesternmutual.com/");
        // Hover over the insurance tab
        ReuasableMethodsLoggers.mouseActionHover(driver, "//*[@id = 'nmx-nav-link-primary-insurance']", logger, "Insurance Tab");
        //verify life insurance sub menu
        String actualLifeInsSubMenu = ReuasableMethodsLoggers.captureText(driver, "//*[@aria-label = 'Life Insurance Submenu']", logger, "LifeInsuranceSubMenu");
        //print out the life insurance sub menu
        System.out.println("Life insurance sub menu is " + actualLifeInsSubMenu);
        String expectedSubMenu = "WHOLE LIFE INSURANCE\n" +
                "UNIVERSAL LIFE INSURANCE\n" +
                "VARIABLE UNIVERSAL LIFE INSURANCE\n" +
                "TERM LIFE INSURANCE\n" +
                "LIFE INSURANCE CALCULATOR";
        //add assertion to check that the correct life insurance is displayed
        assertEqualsLogger(actualLifeInsSubMenu, expectedSubMenu);
    }//end of test case 1
    @Test
    public void tc002_verifyWholeLifeInsurancePolicy() throws InterruptedException {
        //navigate to northwestern website
        driver.navigate().to("https://www.northwesternmutual.com/");
        // Hover over the insurance tab
        ReuasableMethodsLoggers.mouseActionHover(driver, "//*[@id = 'nmx-nav-link-primary-insurance']", logger, "Insurance Tab");
        //click on whole life insurance
        ReuasableMethodsLoggers.clickMethod(driver, "//*[@id = 'nmx-nav-link-primary-sub-level2-whole-life-insurance']", logger, "Whole Life Insurance");
        //wait a bit for page to load
        Thread.sleep(1000);
        //verify header text for whole life insurance
        String expectedText = "Let's protect your (whole) life.";
        String actualText = ReuasableMethodsLoggers.captureText(driver, "//*[@id = 'hero-heading-text-whole-life-insurance-hero']", logger, "LifeInsuranceText");
        assertEqualsLogger(actualText, expectedText);
    }//end of test case 2
}
