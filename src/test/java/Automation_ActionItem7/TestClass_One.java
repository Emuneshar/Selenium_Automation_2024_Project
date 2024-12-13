package Automation_ActionItem7;

import Day13_12022024.TestParent;
import Day14_12032024.ReuasableMethodsLoggers;
import org.testng.annotations.Test;

public class TestClass_One extends TestParent {

    // Strings and xpath storage
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

    // Test case 1 with priority 1
    @Test(priority = 1)
    public void tc001_enterAgeAndGender(){
        driver.navigate().to(url); // Navigate to url
        ReuasableMethodsLoggers.mouseActionHover(driver, xpathForMenu, logger, "Insurance Menu"); // Hover over menu, Insurance
        ReuasableMethodsLoggers.clickMethod(driver, xpathForDisabilityCalculator, logger, "Disability Calculator"); // click on Disability calculator
        ReuasableMethodsLoggers.clickMethod(driver, xpathForCalculateButton, logger, "Calculate Button"); // click on calculate button
        ReuasableMethodsLoggers.clickMethod(driver, xpathForAge, logger, "Age Field"); // click on the age field
        ReuasableMethodsLoggers.sendKeysMethod(driver, xpathForAge, "25", logger, "Age Field"); // send mock data for age
        ReuasableMethodsLoggers.clickMethod(driver, xpathForGender, logger, "Gender Field"); // click on the gender field
        ReuasableMethodsLoggers.clickMethod(driver, xpathSelectGender, logger, "Male"); // select the gender from the dropdown
        ReuasableMethodsLoggers.clickMethod(driver, xpathNextButton, logger, "Next Button"); // click on next button
    } // End of test case 1

    // Test case 2 depends on test case 1
    @Test(dependsOnMethods = "tc001_enterAgeAndGender")
    public void tc002_enterIncomeExpensesSavings() {
        ReuasableMethodsLoggers.clickMethod(driver, xpathIncome, logger, "Income Field"); // click on income field
        ReuasableMethodsLoggers.sendKeysMethod(driver, xpathIncome, "120000", logger, "Income Field"); // send mock data to income field
        ReuasableMethodsLoggers.clickMethod(driver, xpathMonthlyExpenses, logger, "Monthly Expenses"); // click on monthly expense field
        ReuasableMethodsLoggers.sendKeysMethod(driver, xpathMonthlyExpenses, "4000", logger, "Monthly Expenses"); // send mock data for monthly expenses
        ReuasableMethodsLoggers.clickMethod(driver, xpathCurrentSavings, logger, "Current Savings"); // click on current savings field
        ReuasableMethodsLoggers.sendKeysMethod(driver, xpathCurrentSavings, "400000", logger, "Current Savings"); // send mock data for savings
        ReuasableMethodsLoggers.clickMethod(driver, xpathNextButton, logger, "Next Button"); // click on next button
    } // End of test case 2

    // Test case 3 depends on test case 2
    @Test(dependsOnMethods = "tc002_enterIncomeExpensesSavings")
    public void tc003_getEstimate() throws InterruptedException {
        ReuasableMethodsLoggers.clickMethodWithIndex(driver, xpathJobDescription, 0, logger, "Description Type"); // clicks on the job description field
        ReuasableMethodsLoggers.clickMethod(driver, xpathDescriptionType, logger, "Description type"); // clicks on which job type to enter
        Thread.sleep(2000); // Sleep due HTML being dynamically changed
        ReuasableMethodsLoggers.clickMethodWithIndex(driver, xpathGroupCoverage, 1,logger, "Group Coverage"); // click on group coverage
        ReuasableMethodsLoggers.clickMethod(driver, xpathGroupCoverageChoice, logger, "Choice"); // click on choice
        ReuasableMethodsLoggers.clickMethod(driver, xpathNextButton, logger, "Next button"); // click on next button
        String estimate = ReuasableMethodsLoggers.captureText(driver, xpathEstimate, logger, "Estimate");
        System.out.println("Calculation successful, estimate is " + estimate);
    } // End of test case 3

} // End of Test class
