package Automation_ActionItem2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Assignment_One {
    public static void main(String[] args) throws InterruptedException {
        // Here we are creating an Arraylist with 5 sports
        ArrayList<String> sports = new ArrayList<>();
        sports.add("Football");
        sports.add("Baseball");
        sports.add("Hockey");
        sports.add("Basketball");
        sports.add("Golf");

        // Here we are creating a new instance of the WebDriver class and starting a chrome automation window
        WebDriver driver = new ChromeDriver();

        for(int i = 0; i < sports.size(); i++){

            // Navigates to Bing.com
            driver.navigate().to("https://www.bing.com");

            // Here we are telling the code to wait for 3 seconds
            Thread.sleep(3000);

            // This line enters the Query to be searched into the search bar
            driver.findElement(By.xpath("//*[@id='sb_form_q']")).sendKeys(sports.get(i));

            // This line submits the search
            driver.findElement(By.xpath("//*[@id='sb_form_q']")).submit();

            // Here we are telling the code to wait for 3 seconds
            Thread.sleep(3000);

            // This line will get the number of search results and save it into a String variable
            String results = driver.findElement(By.xpath("//*[@class='sb_count']")).getText();

            // Here we are splitting the results string into words by passing an empty space to the split function
            String [] splitResults = results.split(" ");

            System.out.println("Search number for " + sports.get(i) + " is " + splitResults[1]);
        }
        // Here we are quitting the driver
        driver.quit();
    }// End of main method
}// End of class
