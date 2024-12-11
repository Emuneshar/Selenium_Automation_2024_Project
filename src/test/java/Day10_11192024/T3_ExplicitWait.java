package Day10_11192024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class T3_ExplicitWait {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");

        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.usps.com");
        WebElement send = driver.findElement(By.xpath("//*[@id = 'mail-ship-width']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(send));
        Actions mouseActions = new Actions(driver);
        mouseActions.moveToElement(send).perform();



        WebElement calculateButton = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class = 'tool-calc']"))));

        //Actions mouseActions = new Actions(driver);
        mouseActions.moveToElement(calculateButton).click().perform();

        driver.quit();

    }
}
