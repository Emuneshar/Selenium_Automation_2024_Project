package Practice_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelemiunStuff {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        String url = "https://www.google.com";
        String keys = "cars";
        open(driver, url);
        search(driver, keys);
    }

    public static void open(WebDriver driver, String url)  throws InterruptedException{
        driver.navigate().to(url);
        Thread.sleep(4000);
    }

    public static void search(WebDriver driver, String keysToSend)throws InterruptedException{
        driver.findElement(By.xpath("//*[@name = 'q']")).sendKeys("cars");
        driver.findElement(By.xpath("//*[@class = 'gNO89b']")).submit();
        Thread.sleep(6000); // Java command for sleep statement
    }
}
