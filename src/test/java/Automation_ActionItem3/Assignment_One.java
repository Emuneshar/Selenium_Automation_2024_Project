package Automation_ActionItem3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Assignment_One {
    public static void main(String[] args) throws InterruptedException {
        // User Story: As a customer, I would like to find a doctor with their full name and years of experience, searching by zip code so that I could find a doctor near me

        // Creating an ArrayList to hold 3 zipcodes
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11418");
        zipCode.add("11001");
        zipCode.add("11367");

        // Setting up new Chrome options for chrome window
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");

        // Creating a new Chrome window with the options from above
        WebDriver driver = new ChromeDriver(options);


        // The following code will verify that we have navigated to the correct site. If we have then the rest of the code will run

        int x = 0; // This is where we declare our counter variable


        while (x < zipCode.size()) { // This loop will iterate for the entire size of our zipCode arraylist

            // Navigating to webMD site
            driver.navigate().to("https://www.webmd.com");

            // Getting the title of the site to use for verification
            String title = driver.getTitle();

            if (title.equals("WebMD - Better information. Better health.")) {
                System.out.println("Verification complete, the website is a match"); // This line will let the tester know that we successfully navigated to the site
            } else {
                System.out.println("Something went wrong, try again, the actual title was " + title); // if the verification failed we tell the tester the title of the site we are currently on
            }

            driver.navigate().to("https://www.webmd.com"); // This line will navigate to the webMD page

            driver.findElement(By.xpath("//*[(text()= 'Find a Doctor')]")).click(); // Here we click on the field to enter a zipcode to locate a doctor

            for (int i = 0; i < 50; i++) {
                driver.findElement(By.xpath("//*[contains(@class, 'zipcode-input')]")).sendKeys(Keys.BACK_SPACE); // This for loop will backspace characters from the text field
            }

            driver.findElement(By.xpath("//*[contains(@class, 'zipcode-input')]")).sendKeys(zipCode.get(x)); // Sending the current zipcode to the field to be submitted

            driver.findElement(By.xpath("//*[contains(@class, 'zipcode-input')]")).submit(); // Submitting the query to be searched on the site

            Thread.sleep(3000); // Added a pause for the system to load the results

            String providerName = driver.findElements(By.xpath("//*[@class = 'prov-name']")).get(0).getText(); // accessing the first doctors name from the results

            String experience = driver.findElements(By.xpath("//*[@class = 'prov-experience']")).get(0).getText(); // accessing their experience data

            System.out.println("The provider name is " + providerName + " and they have " + experience); // Displays the name of the first doctor along with their years of experience

            x++; // Increments the loop to the next number so we can find a provider for the next zipcode
        } // End of loop

        System.out.println("Process completed. Browser will now be closed"); // Lets the tester know the window will be closed

        driver.quit(); // Closes the current driver

    }// End of Main Method
}// Enf of class
