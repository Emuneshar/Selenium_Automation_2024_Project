package Day13_12022024;

import Day11_11252024.ReuasbleMethods;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class TestParent {

    public static WebDriver driver;

    // Creates a public instance of the extentreport class
    public static ExtentReports report;

    // Creates a public instance of the extentreport class
    public static ExtentTest logger;




    @BeforeSuite
    public void setUpExtentReport() {
        report = new ExtentReports("src/main/java/HTML_Report/AutomationReport.html");
    }//end of before suite

    @BeforeClass
    public void setUpChromeDriver(){
        driver = ReuasbleMethods.setup();
    }//end of before class

    @BeforeMethod
    public void setTestName(Method methodName) {
        logger = report.startTest(methodName.getName());
    }//end of before method

    

    @AfterClass
    public void cleanUpDriver(){
        driver.quit();
    }//end of after class

    @AfterSuite
    public void cleanUpReport() {
        //flush out the report
        report.flush();
    }//end of aftersuite






    public static void assertEqualsLogger(String actual, String expected){
        if (expected.equals(actual)){
            logger.log(LogStatus.PASS, "Actual result: " + actual + " matches expected " + expected);
            Assert.assertEquals(actual, expected);
        }
        else {
            logger.log(LogStatus.FAIL, "Actual result: " + actual + " matches expected " + expected);
            Assert.assertEquals(actual, expected);
        }
    }

    public static void assertTrueLogger(boolean bool){
        if (bool){
            logger.log(LogStatus.PASS, "Boolean condition is " + bool);
            Assert.assertTrue(bool);
        }
        else {
            logger.log(LogStatus.FAIL, "Boolean condition is " + bool);
            Assert.assertFalse(bool);
        }
    }
}
