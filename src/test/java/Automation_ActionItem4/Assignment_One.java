package Automation_ActionItem4;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
public class Assignment_One {
    public static void main(String[] args) throws InterruptedException {

        // Create our array list of zipCodes
        ArrayList<String> zipCodes = new ArrayList<>();

        // Adding zip codes to the array list
        zipCodes.add("90001");
        zipCodes.add("11001");
        zipCodes.add("77010");

        // Setting up the options for chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");

        // Setting up the driver/browser window
        WebDriver driver = new ChromeDriver(options);

        // Using the loop to run the test
        for(int i = 0; i < zipCodes.size(); i++){
            // Navigating to the site
            driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop/");

            // Added a sleep to let the site load properly
            Thread.sleep(2000);

            // Clicks on the option to search for in person sessions
            driver.findElement(By.xpath("//*[text() = 'In-Person']")).click();

            // Stores the location search field into a Webelement, clears the field if needed, then sends the zipcode that  matches with the current loop iteration
            WebElement search = driver.findElement(By.xpath("//*[@id = 'location-search']"));
            search.clear();
            search.sendKeys(zipCodes.get(i));

            // Clicks on the arrow button on the page to submit the search query
            driver.findElement(By.xpath("//*[@class = 'rightArrow-C_sUu']")).click();
            Thread.sleep(2000); // Added sleep time to let the results load

            // Here we are storing the search results that show up into an ArrayList
            ArrayList<WebElement> results = new ArrayList<>(driver.findElements(By.xpath("//*[@class = 'wrapperLink-rmsRn']")));

            if(i == 0){ // We are saying if this is the first zipcode we searched then click on the second studio link
                results.get(1).click();
            }
            else if (i ==1){ // if this is the second zipcode we searched then click on the third studio link
                results.get(2).click();
            }
            else{ // otherwise click on the first studio link
                results.get(0).click();
            }

            // I created a divider to make the results more readable
            System.out.println("*+*+*+*+*+*+*+*++*+*++*+*+*+*++*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+**+*+*+*++*");

            // Get the address of the studio and save it into a variable
            String address = driver.findElement(By.xpath("//*[@class = 'address-FnT8k']")).getText();

            // Printing out the address
            System.out.println("Address " + (i+1) + " is: " + address);

            // Creating a Javascript Executor
            JavascriptExecutor jse = (JavascriptExecutor) driver;

            // Storing the location of the element we want to scroll to
            WebElement viewSchedule = driver.findElement(By.xpath("//*[contains(text(), 'Upcoming In-Person Workshops')]"));

            // Added a sleep so we can see the scrolling happen otherwise it would be too fast
            Thread.sleep(2000);

            // Using the jse to scroll down to the element we saved
            jse.executeScript("arguments[0].scrollIntoView(true);", viewSchedule);

            // Added a sleep so we can see the scrolling happen otherwise it would be too fast
            Thread.sleep(2000);

            // Getting the scheduled availability sand saving it to a variable
            String availability = driver.findElement(By.xpath("//*[@class = 'scheduleContainerMobile-ps6Rm']")).getText();

            // Here we are printing out the availability
            System.out.println(availability);
        }
        System.out.println("The script is complete, the browser will now be closed in 3 seconds");
        Thread.sleep(3000);
        driver.quit(); // Here we are closing the driver after the script is complete
    } // End of main method
}// End of class
