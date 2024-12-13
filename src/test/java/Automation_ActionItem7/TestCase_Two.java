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
    String xpathFinancialPlanning = "//*[@id = 'nmx-nav-link-primary-financial-planning']";
    String xpathEstatePlanning = "//*[@id = 'nmx-nav-link-primary-sub-estate-planning']";
    String xpathPopupClose = "//*[@id = 'onetrust-accept-btn-handler']";
    String xpathAboutPlanning = "//*[@id = 'hero-description-text-estate-planning-hero']";
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

    @Test
    public void tc001_verifyPrivateWealthManagementPartners() throws InterruptedException {
        driver.navigate().to(url);
        ReuasableMethodsLoggers.mouseActionHover(driver, xpathInvestments, logger, "Investments");
        ReuasableMethodsLoggers.clickMethod(driver, xpathWealthManagement, logger, "Private Wealth Management");
        Thread.sleep(3000);
        ReuasableMethodsLoggers.scrollByPixel(driver, 0, 300, logger);
        ReuasableMethodsLoggers.clickMethod(driver, xpathFindClientGroup, logger, "Find A Private Client Group Advisor");
        ReuasableMethodsLoggers.selectByText(driver, xpathSelectAState, "New York",logger);
        String actualResult = ReuasableMethodsLoggers.captureText(driver, xpathResults, logger, "Results");
        assertEqualsLogger(actualResult, expectedResult);
    }

    @Test
    public void tc002_WhoNeedsAnEstatePlan() throws InterruptedException {
        driver.navigate().to(url);
        ReuasableMethodsLoggers.mouseActionHover(driver, xpathFinancialPlanning, logger, "Financial Planning");
        ReuasableMethodsLoggers.clickMethod(driver, xpathEstatePlanning, logger, "Estate Planning");
        Thread.sleep(4000);
        ReuasableMethodsLoggers.clickMethod(driver, xpathPopupClose, logger,"Close pop up");
        String actualText = ReuasableMethodsLoggers.captureText(driver, xpathAboutPlanning, logger, "Text to check");
        assertEqualsLogger(actualText, textToCompare);
    }

}
