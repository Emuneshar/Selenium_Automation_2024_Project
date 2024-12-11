package Day10_11192024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class T1_MouseActions {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.navigate().to("https://www.usps.com");
            WebElement send = driver.findElement(By.xpath("//*[@id = 'mail-ship-width']"));
            Actions mouseActions = new Actions(driver);
            mouseActions.moveToElement(send).perform();
        } catch (Exception e) {
            System.out.println("Couldn't locate the send menu " + e);
        }
        Thread.sleep(1000);
        try {
            WebElement calculatePrice = driver.findElement(By.xpath("//*[@class = 'tool-calc']"));
            Actions mouseActions = new Actions(driver);
            mouseActions.moveToElement(calculatePrice).click().perform();

        } catch (Exception e) {
            System.out.println("Couldn't click on calculate button due to " + e);
        }

        Thread.sleep(2000);

        driver.quit();


    }// end of the main method
}// end of the class
