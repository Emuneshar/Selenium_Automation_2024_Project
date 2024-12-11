package Day9_11182024;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T1_TryCatch {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");

        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("https://www.mortgagecalculator.org");

        try{
            WebElement homeValue = driver.findElement(By.xpath("//*[@id = 'homeval']"));
            homeValue.clear();
            Thread.sleep(1000);
            homeValue.sendKeys("900000");

        } catch (Exception e) {
            System.out.println("Unable to enter home value " + e);
        }

        try{
            WebElement downPayment = driver.findElement(By.xpath("//*[@id = 'downpayment']"));
            downPayment.clear();
            Thread.sleep(1000);
            downPayment.sendKeys("100000");

        } catch (Exception e) {
            System.out.println("Unable to enter a downpayment amount " + e);
        }

        WebElement calculate = driver.findElement(By.xpath("//*[@value = 'Calculate']"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", calculate);


        Thread.sleep(2000);
        calculate.click();

        Thread.sleep(3000);


        driver.quit();
    } // End of main method
} // End of class
