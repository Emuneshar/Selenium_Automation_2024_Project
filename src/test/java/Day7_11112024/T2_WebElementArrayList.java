package Day7_11112024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class T2_WebElementArrayList {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");

        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("https://www.google.com");


        ArrayList <WebElement> bigButtons = new ArrayList<>(driver.findElements(By.xpath("//*[@class= 'MV3Tnb']")));
        // Click on about and store links
        bigButtons.get(0).click();

        // allows to go back to the previous page
        driver.navigate().back();


        bigButtons.get(1).click();

        driver.quit();
    }
}
