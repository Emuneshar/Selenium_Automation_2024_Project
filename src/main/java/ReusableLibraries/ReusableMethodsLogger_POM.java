package ReusableLibraries;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class ReusableMethodsLogger_POM {

    public static WebDriver setUpChromeDriver() {
        //declare chrome options variable
        ChromeOptions options = new ChromeOptions();
        //maximize for windows
        options.addArguments("start-maximized");
        //open in incognito mode
        options.addArguments("incognito");
        //define the webdriver
        WebDriver driver = new ChromeDriver(options);
        //return the driver so it can be used in other classes
        return driver;
    }//end of setupchrome driver

    public static void sendKeysMethod(WebDriver driver, WebElement element, String text, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
            logger.log(LogStatus.PASS, "Successfully sent keys on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to send keys to element " + elementName);
            logger.log(LogStatus.FAIL, "Unable to send keys to element " + elementName);
            getScreenShot(driver,elementName,logger);
        }
    }//end of send keys method

    public static void submitMethod(WebDriver driver, WebElement element,ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(element)).submit();
            logger.log(LogStatus.PASS, "Successfully submit on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName);
            logger.log(LogStatus.FAIL, "Unable to submit on element " + elementName);
        }
    }//end of submit method

    public static void getScreenShot(WebDriver driver, String imageName, ExtentTest logger) {
        try {
            String fileName = imageName + ".png";
            String directory = null;
            String snPath = null;
            directory = "src/main/java/HTML_Report/sc";
            snPath = "Screenshots//";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture(snPath + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error Occured while taking SCREENSHOT!!!");
            e.printStackTrace();
        }
    }//end of getScreenshot method
}
