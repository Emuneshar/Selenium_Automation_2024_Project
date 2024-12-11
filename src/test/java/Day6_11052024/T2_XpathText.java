package Day6_11052024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T2_XpathText {
    public static void main(String[] args) throws InterruptedException {
        // Initialize your chrome option to set up preconditions on your web driver/browser

        // Create a new ChromeOptions instance
        ChromeOptions options = new ChromeOptions();

        // Tells chrome driver to open start maximized and incognito
        options.addArguments("start-maximized");
        options.addArguments("incognito");

        // Creates chrome driver
        WebDriver driver = new ChromeDriver(options);

        // Navigates to yahoo
        driver.navigate().to("https://www.uhc.com");

        Thread.sleep(3000);

        // get element
        driver.findElement(By.xpath("//*[text()= 'Shop insurance']")).click();
        // Tells the driver to sleep
        Thread.sleep(3000);

        // quits the driver
        driver.quit();
    }
}
