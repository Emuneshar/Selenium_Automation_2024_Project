package Automation_ActionItem7;

import Day13_12022024.TestParent;
import Day14_12032024.ReuasableMethodsLoggers;
import org.testng.annotations.Test;

public class TestCase_One extends TestParent {
    String url = "https://www.northwesternmutual.com/";
    String xpathForMenu = "//*[@id = 'nmx-nav-link-primary-insurance']";
    String xpathForDisabilityCalculator = "//*[@id = 'nmx-nav-link-primary-sub-level2-disability-insurance-calculator']";
    String xpathForCalculateButton = "//*[@id = 'calculate-it']";
    String xpathForAge = "//*[@id = 'age']";
    String xpathForGender = "//*[@class = 'dropdown--target']";
    String xpathSelectGender = "//*[@id = 'male']";
    String xpathNextButton = "//*[@id = 'next-screen']";
    String xpathIncome = "//*[@id = 'income']";
    String xpathMonthlyExpenses = "//*[@id = 'monthly-expenses']";
    String xpathCurrentSavings = "//*[@id = 'current-savings']";
    String xpathJobDescription = "//*[@class = 'dropdown--target']";
    String xpathDescriptionType = "//*[text()='Professional']";
    String xpathGroupCoverage = "//*[@class = 'dropdown--target']";
    String xpathGroupCoverageChoice = "//*[text()='Yes']";
    String xpathEstimate = "//*[@class = 'results-header--di-calc__cov-estimate']";


    @Test(priority = 1)
    public void tc001_enterAgeAndGender() throws InterruptedException {
        driver.navigate().to(url);
        ReuasableMethodsLoggers.mouseActionHover(driver, xpathForMenu, logger, "Insurance Menu");
        ReuasableMethodsLoggers.clickMethod(driver, xpathForDisabilityCalculator, logger, "Disability Calculator");
        ReuasableMethodsLoggers.clickMethod(driver, xpathForCalculateButton, logger, "Calculate Button");
        ReuasableMethodsLoggers.clickMethod(driver, xpathForAge, logger, "Age Field");
        ReuasableMethodsLoggers.sendKeysMethod(driver, xpathForAge, "25", logger, "Age Field");
        ReuasableMethodsLoggers.clickMethod(driver, xpathForGender, logger, "Gender Field");
        ReuasableMethodsLoggers.clickMethod(driver, xpathSelectGender, logger, "Male");
        ReuasableMethodsLoggers.clickMethod(driver, xpathNextButton, logger, "Next Button");

    }

    @Test(dependsOnMethods = "tc001_enterAgeAndGender")
    public void tc002_enterIncomeExpensesSavings() {
        ReuasableMethodsLoggers.clickMethod(driver, xpathIncome, logger, "Income Field");
        ReuasableMethodsLoggers.sendKeysMethod(driver, xpathIncome, "120000", logger, "Income Field");
        ReuasableMethodsLoggers.clickMethod(driver, xpathMonthlyExpenses, logger, "Monthly Expenses");
        ReuasableMethodsLoggers.sendKeysMethod(driver, xpathMonthlyExpenses, "4000", logger, "Monthly Expenses");
        ReuasableMethodsLoggers.clickMethod(driver, xpathCurrentSavings, logger, "Current Savings");
        ReuasableMethodsLoggers.sendKeysMethod(driver, xpathCurrentSavings, "400000", logger, "Current Savings");
        ReuasableMethodsLoggers.clickMethod(driver, xpathNextButton, logger, "Next Button");

    }

    @Test(dependsOnMethods = "tc002_enterIncomeExpensesSavings")
    public void tc003_getEstimate() throws InterruptedException {
        ReuasableMethodsLoggers.clickMethodWithIndex(driver, xpathJobDescription, 0, logger, "Description Type");
        ReuasableMethodsLoggers.clickMethod(driver, xpathDescriptionType, logger, "Description type");
        Thread.sleep(2000);
        ReuasableMethodsLoggers.clickMethodWithIndex(driver, xpathGroupCoverage, 1,logger, "Group Coverage");
        ReuasableMethodsLoggers.clickMethod(driver, xpathGroupCoverageChoice, logger, "Choice");
        ReuasableMethodsLoggers.clickMethod(driver, xpathNextButton, logger, "Next button");
        String estimate = ReuasableMethodsLoggers.captureText(driver, xpathEstimate, logger, "Price");
        System.out.println(estimate);
        Thread.sleep(4000);
    }




}
