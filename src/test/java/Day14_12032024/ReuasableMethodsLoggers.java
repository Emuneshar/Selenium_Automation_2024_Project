package Day14_12032024;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class ReuasableMethodsLoggers {

    public static void clickMethod(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName );

        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName);
            logger.log(LogStatus.FAIL, "Unable to click on " + elementName );
        }
    }


    public static String captureText(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        String text = "";
        WebDriverWait pause = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement name = pause.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            text = name.getText();
            logger.log(LogStatus.PASS, "Successfully captured text from " + elementName);
        } catch (Exception e) {
            System.out.println("Sorry, couldn't get the " + e);
            logger.log(LogStatus.FAIL, "Couldn't get the text from " + elementName);
        }
        return text;
    }




    public static String captureTextWithIndex(WebDriver driver, String xpath, int index, ExtentTest logger, String elementName) {
        String text = "";

        try {
            WebDriverWait pause = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement name = driver.findElements(By.xpath(xpath)).get(index);
            text = name.getText();
            System.out.println(text);
            logger.log(LogStatus.PASS, "Successfully captured text with index from " + elementName);
        } catch (Exception e) {
            System.out.println("Sorry couldn't get the " + e);
            logger.log(LogStatus.FAIL, "Couldn't capture text with index from " + elementName);
        }
        return text;
    }


    public static void sendKeysMethod(WebDriver driver, String xpath, String text, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath)))).sendKeys(text);
            logger.log(LogStatus.PASS, "Succesfully sent keys to " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to send keys to element " + elementName);
            logger.log(LogStatus.FAIL, "Couldn't capture text with index from " + elementName);
        }
    }//end of send keys method


    public static void submitMethod(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath)))).submit();
            logger.log(LogStatus.PASS, "Succesfully submitted with the element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName);
            logger.log(LogStatus.FAIL, "Couldn't submit with the element " + elementName);
        }
    }//end of submit method


    public static WebDriver setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");

        WebDriver driver = new ChromeDriver(options);

        return driver;
    }





    // Here is the method declaration with the needed parameters
    public static void clickMethodWithIndex(WebDriver driver, String xpath, int index, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            ArrayList<WebElement> listOfThings = new ArrayList<>(driver.findElements(By.xpath(xpath)));
            WebElement first = listOfThings.get(index);
            wait.until(ExpectedConditions.visibilityOf(first)).click();
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName);
            logger.log(LogStatus.PASS, "Couldn't click on the element " + elementName);
        }
    }


    // Here is the method declaration with the needed parameters
    public static void switchToTabByIndex(WebDriver driver, int tab) {
        try {

            // Below we are getting the titles of all the tabs for our driver and saving them into an array list
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

            // Here we are switching to the tab number that was passed in as a parameter
            driver.switchTo().window(tabs.get(tab));
        } catch (Exception e) {

            // Here we are printing out any possible errors that may be thrown with the code above
            System.out.println("Unable to switch to the provided tab " + e);
        }
    }

    // Here is the method declaration with the needed parameters
    public static void scrollByPixel(WebDriver driver, int x, int y, ExtentTest logger) {
        try {

            // Here we are creating the Javascript Executor
            JavascriptExecutor jse = (JavascriptExecutor) driver;

            // Here I am concatenating a string to be passed in as the Javascript code to be executed, plugging in the values to be scrolled to
            String jsCode = "scroll(" + x + "," + y + ");";

            // Here I am telling Java to execute the Javascript code using the Javascript Executor
            jse.executeScript(jsCode);
            logger.log(LogStatus.PASS, "Successfully scrolled down");
        } catch (Exception e) {

            // Here we are printing out any possible errors that may be thrown with the code above
            System.out.println("Couldn't scroll due to " + e);
            logger.log(LogStatus.FAIL, "Couldn't scroll down");
        }
    }

    // Here is the method declaration with the needed parameters
    public static void selectByText(WebDriver driver, String xpath, String itemToSelect, ExtentTest logger) {
        try {

            // Creating a web element to save the dropdown menu into
            WebElement menu = driver.findElement(By.xpath(xpath));

            // Here we create a new instance of the Select class which we will pass in the previously created web element into
            Select dropdown = new Select(menu);

            // Here we are telling the new select object which item to choose from the options provided
            dropdown.selectByVisibleText(itemToSelect);
            logger.log(LogStatus.PASS, "Successfully selected by text");
        } catch (Exception e) {

            // Here we are printing out any possible errors that may be thrown with the code above
            System.out.println("Couldn't select item from menu due to " + e);
            logger.log(LogStatus.FAIL, "Couldn't select by text");
        }
    }

    public static void mouseActionHover(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement itemToHoverOver = driver.findElement(By.xpath(xpath));
            wait.until(ExpectedConditions.visibilityOf(itemToHoverOver));
            Actions mouseActions = new Actions(driver);
            mouseActions.moveToElement(itemToHoverOver).perform();
            logger.log(LogStatus.PASS, "Successfully hovered over item" + elementName);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Couldn't hover over item" + elementName);
        }

    }
}


