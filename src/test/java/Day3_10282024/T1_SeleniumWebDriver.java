package Day3_10282024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class T1_SeleniumWebDriver  {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver(); // Create a new Instance of the WebDriver class
        driver.navigate().to("https://www.google.com"); // Tells Java which site to open
        driver.manage().window().fullscreen(); // sets the screen to fullscreen
        driver.findElement(By.xpath("//*[@name = 'q']"));
        Thread.sleep(4000); // Java command for sleep statement
        driver.quit(); // Quits the current session
    } // End of Main Method

}// End of Class
