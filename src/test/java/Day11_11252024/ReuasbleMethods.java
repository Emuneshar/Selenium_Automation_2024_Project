package Day11_11252024;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class ReuasbleMethods {
    public static void clickMethod(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath)))).click();

        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName);
        }
    }





    public static String captureText(WebDriver driver, String xpath, String elementName) {
        String text = "";
        WebDriverWait pause = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement name = driver.findElement(By.xpath(xpath));
            pause.until(ExpectedConditions.visibilityOf(name));
            text = name.getText();
        } catch (Exception e) {
            System.out.println("Sorry, couldn't get the " + e);
        }
        return text;
    }

    public static String captureTextWithIndex(WebDriver driver, String xpath, int index, String elementName) {
        String text = "";

        try {
            WebDriverWait pause = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement name = driver.findElements(By.xpath(xpath)).get(index);
            text = name.getText();
        } catch (Exception e) {
            System.out.println("Sorry couldn't get the " + e);
        }
        return text;
    }


    public static void sendKeysMethod(WebDriver driver, String xpath, String text, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath)))).sendKeys(text);
        } catch (Exception e) {
            System.out.println("Unable to send keys to element " + elementName);
        }
    }//end of send keys method


    public static void submitMethod(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath)))).submit();
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName);
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
    public static void clickMethodWithIndex(WebDriver driver, String xpath, int index, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            ArrayList<WebElement> listOfThings = new ArrayList<>(driver.findElements(By.xpath(xpath)));
            WebElement first = listOfThings.get(index);
            wait.until(ExpectedConditions.visibilityOf(first)).click();
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName);
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
    public static void scrollByPixel(WebDriver driver, int x, int y) {
        try {

            // Here we are creating the Javascript Executor
            JavascriptExecutor jse = (JavascriptExecutor) driver;

            // Here I am concatenating a string to be passed in as the Javascript code to be executed, plugging in the values to be scrolled to
            String jsCode = "scroll(" + x + "," + y + ");";

            // Here I am telling Java to execute the Javascript code using the Javascript Executor
            jse.executeScript(jsCode);
        } catch (Exception e) {

            // Here we are printing out any possible errors that may be thrown with the code above
            System.out.println("Couldn't scroll due to " + e);
        }
    }

    // Here is the method declaration with the needed parameters
    public static void selectByText(WebDriver driver, String xpath, String itemToSelect) {
        try {

            // Creating a web element to save the dropdown menu into
            WebElement menu = driver.findElement(By.xpath(xpath));

            // Here we create a new instance of the Select class which we will pass in the previously created web element into
            Select dropdown = new Select(menu);

            // Here we are telling the new select object which item to choose from the options provided
            dropdown.selectByVisibleText(itemToSelect);
        } catch (Exception e) {

            // Here we are printing out any possible errors that may be thrown with the code above
            System.out.println("Couldn't select item from menu due to " + e);
        }
    }


}
