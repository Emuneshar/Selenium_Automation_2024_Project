package Day10_11192024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class T2_ImplicitWait {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");

        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.usps.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement send = driver.findElement(By.xpath("//*[@id = 'mail-ship-width']"));
        Actions mouseActions = new Actions(driver);
        mouseActions.moveToElement(send).perform();


    }
}
