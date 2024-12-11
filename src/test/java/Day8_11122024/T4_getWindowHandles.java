package Day8_11122024;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class T4_getWindowHandles {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.fideliscare.org/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id= 'root-3']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text() = 'Shop for a Plan']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[contains(@class, 'btn btn-outline-primary btn-external')]")).click();
        Thread.sleep(3000);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));


        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id='searchLocation']")).sendKeys("11001");
        driver.findElement(By.xpath("//*[@id='searchLocation']")).submit();

        // driver.close();
    }
}
