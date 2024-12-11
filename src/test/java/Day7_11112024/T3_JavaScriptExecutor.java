package Day7_11112024;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T3_JavaScriptExecutor {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.mortgagecalculator.org");

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0,500);");



        Thread.sleep(2000);
        jse.executeScript("scroll(0,-500);");
        Thread.sleep(2000);
        driver.quit();
    }
}
