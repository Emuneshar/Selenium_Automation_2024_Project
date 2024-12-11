package Day4_10292024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_Split_Google_Search {
    public static void main(String[] args) throws InterruptedException {
        // Use Case: Get the number of results from the google results page

        // Start new Driver for chrome
        WebDriver driver = new ChromeDriver();

        // Tell the Driver to naviagte to google.com
        driver.navigate().to("https://www.google.com");

        // Tell the driver to search for cars
        driver.findElement(By.xpath("//*[@name = 'q']")).sendKeys("cars");

        // Maximize the windows
        driver.manage().window().maximize();

        // Tell the driver to submit the search
        driver.findElement(By.xpath("//*[@name = 'q']")).submit();

        // Tell the driver to click on the tools button on the results page
        driver.findElement(By.xpath("//*[@id = 'hdtb-tls']")).click();

        // Tell the driver to get the number of results from the results page
        String result = driver.findElement(By.xpath("//*[@id = 'result-stats']")).getText();

        String [] splitMessage = result.split(" ");


        // Prints out the number of results
        System.out.println("Number of results: " + splitMessage[1]);

        Thread.sleep(4000);
        driver.quit();
    }
}
