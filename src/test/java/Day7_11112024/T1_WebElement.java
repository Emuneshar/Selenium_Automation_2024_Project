package Day7_11112024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T1_WebElement {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://mlcalc.com");
        Thread.sleep(2000);

        WebElement pPrice = driver.findElement(By.xpath("//*[@name='ma']"));
        WebElement dPayment = driver.findElement(By.xpath("//*[@name='dp']"));

        pPrice.clear();
        pPrice.sendKeys("200000");
        dPayment.clear();
        dPayment.sendKeys("25");
        Thread.sleep(2000);
        driver.quit();
    } // End of main method
} // End of class
