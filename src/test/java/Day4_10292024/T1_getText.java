package Day4_10292024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_getText {
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

        // Prints out the number of results
        System.out.println(result);

        // add wait so we can see it
        Thread.sleep(2000);

        // quit session
        driver.quit();
    }// End of Main method
}// Enf of class
