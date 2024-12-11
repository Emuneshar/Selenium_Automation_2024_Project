package Day8_11122024;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class T3_SelectByClick {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.mortgagecalculator.org");
        Thread.sleep(2000);

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        WebElement viewLoan = driver.findElement(By.xpath("//*[text()='View Loan Breakdown']"));
        jse.executeScript("arguments[0].scrollIntoView(true);", viewLoan);

        WebElement menu = driver.findElement(By.xpath("//*[@name='param[start_month]']"));
        menu.click();

        driver.findElement(By.xpath("//*[text() = 'Dec']")).click();

        menu.click();
        Thread.sleep(3000);
        driver.quit();
    }
}
