package Day3_10282024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_Xpath_UserActions {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver(); // Create a new Instance of the WebDriver class
        driver.navigate().to("https://www.google.com"); // Tells Java which site to open
        driver.manage().window().maximize(); // sets the screen to fullscreen
        driver.findElement(By.xpath("//*[@name = 'q']")).sendKeys("cars"); // inputs text into search box
        driver.findElement(By.xpath("//*[@class = 'gNO89b']")).submit(); // submits the search using the submit function
        Thread.sleep(6000); // Java command for sleep statement
        driver.quit();
    }
}
