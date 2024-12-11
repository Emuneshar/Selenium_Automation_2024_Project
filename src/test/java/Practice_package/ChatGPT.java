package Practice_package;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.Random;

public class ChatGPT {
    public static void main(String[] args) throws InterruptedException {

        // Creates an array list and saves the zip codes
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11001");
        zipCode.add("11428");

        // Policy start dates
        ArrayList<String> policyStart = new ArrayList<>();
        policyStart.add("12/13/2024");
        policyStart.add("01/11/2025");

        // First names
        ArrayList<String> firstName = new ArrayList<>();
        firstName.add("Patrik");
        firstName.add("Tim");

        // Last names
        ArrayList<String> lastName = new ArrayList<>();
        lastName.add("Mahoes");
        lastName.add("Brad");

        // Addresses
        ArrayList<String> streetAdd = new ArrayList<>();
        streetAdd.add("8449 257st");
        streetAdd.add("93-21 214th St");

        // Date of birth
        ArrayList<String> dob = new ArrayList<>();
        dob.add("09/17/1994");
        dob.add("08/03/1976");

        // Set ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");

        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://plainproxies.com/resources/free-web-proxy");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@type= 'text']")).sendKeys("https://www.statefarm.com/");
        driver.findElement(By.xpath("//*[@type= 'text']")).submit();
        for (int i = 0; i < zipCode.size(); i++) {
            try {
                //driver.navigate().to("https://www.statefarm.com/");
                //randomDelay();

                // Click on "Get a Quote"
                WebElement getQuote = retryElement(driver, By.xpath("//*[contains(text(), 'Get a Quote')]"));
                getQuote.click();
                randomDelay();

                // Select product dropdown
                WebElement dropDown = retryElement(driver, By.xpath("//*[@id='product-select1']"));
                dropDown.click();

                // Select homeowners
                WebElement homeOwners = retryElement(driver, By.xpath("//*[@value='Homeowners']"));
                homeOwners.click();
                randomDelay();

                // Enter ZIP code
                WebElement zipCodeField = retryElement(driver, By.xpath("//*[@id='quote-main-zip-code-input1']"));
                zipCodeField.clear();
                zipCodeField.sendKeys(zipCode.get(i));
                randomDelay();

                // Click on start quote
                WebElement startQuote = retryElement(driver, By.xpath("//*[@id='quote-submit-button1']"));
                startQuote.click();
                randomDelay();

                // Enter policy start date
                WebElement startDate = retryElement(driver, By.xpath("//*[@id='effectiveDate']"));
                startDate.clear();
                startDate.sendKeys(policyStart.get(i));
                randomDelay();

                // Enter first name
                WebElement firstNameField = retryElement(driver, By.xpath("//*[@id='firstName']"));
                firstNameField.clear();
                firstNameField.sendKeys(firstName.get(i));
                randomDelay();

                // Enter last name
                WebElement lastNameField = retryElement(driver, By.xpath("//*[@id='lastName']"));
                lastNameField.clear();
                lastNameField.sendKeys(lastName.get(i));
                randomDelay();

                // Enter address
                WebElement addressField = retryElement(driver, By.xpath("//*[@id='street']"));
                addressField.clear();
                addressField.sendKeys(streetAdd.get(i));
                randomDelay();

                // Enter date of birth
                WebElement dateOfBirth = retryElement(driver, By.xpath("//*[@id='dateOfBirth']"));
                dateOfBirth.clear();
                dateOfBirth.sendKeys(dob.get(i));
                randomDelay();

                // Scroll to and click continue button
                WebElement continueButton = retryElement(driver, By.xpath("//*[@name='continue']"));
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                jse.executeScript("arguments[0].scrollIntoView(true);", continueButton);
                randomDelay();
                continueButton.click();
                randomDelay();

            } catch (Exception e) {
                System.out.println("An error occurred during automation: " + e.getMessage());
            }
        }

        // Quit the driver
        driver.quit();
    }

    /**
     * Retry locating an element with a delay.
     */
    private static WebElement retryElement(WebDriver driver, By by) throws InterruptedException {
        WebElement element = null;
        int attempts = 0;
        while (attempts < 3) {
            try {
                element = driver.findElement(by);
                break;
            } catch (Exception ignored) {
                Thread.sleep(2000); // Retry after 2 seconds
            }
            attempts++;
        }
        if (element == null) {
            throw new RuntimeException("Failed to locate element: " + by.toString());
        }
        return element;
    }

    /**
     * Introduce a randomized delay between actions.
     */
    private static void randomDelay() throws InterruptedException {
        Random rand = new Random();
        int delay = rand.nextInt(3000) + 2000; // Random delay between 2-5 seconds
        Thread.sleep(delay);
    }
}
