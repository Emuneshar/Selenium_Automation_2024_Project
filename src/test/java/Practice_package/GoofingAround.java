package Practice_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GoofingAround {
    public static void main(String[] args) throws InterruptedException {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new FirefoxDriver(options);

        driver.navigate().to("https://www.instagram.com");

        Thread.sleep(2000);

        WebElement username = driver.findElement(By.xpath("//*[contains(@aria-label, 'Phone number, username, or email')]"));
        username.click();
        username.sendKeys("nyc.pinetart94");

        WebElement password = driver.findElement(By.xpath("//*[@aria-label='Password']"));

        password.click();
        password.sendKeys("Shiva2194**");
        password.submit();

        Thread.sleep(20000);

        ArrayList<WebElement> sideBar = new ArrayList<>(driver.findElements(By.xpath("//*[contains(@class, 'x9f619 x3nfvp2 xr9ek0c xjpr12u')]")));

        sideBar.get(7).click();
        Thread.sleep(20000);
        ArrayList<WebElement> followerCount = new ArrayList<>(driver.findElements(By.xpath("//*[contains(@class, 'x5n08af x1s688f')]")));

        followerCount.get(1).click();

        ArrayList<WebElement> elements = new ArrayList<>(driver.findElements(By.xpath("//span[contains(@class, 'x1dm5mii') and contains(@class, 'x16mil14') and contains(@class, 'xiojian') and contains(@class, 'x1yutycm') and contains(@class, 'x1lliihq') and contains(@class, 'x193iq5w') and contains(@class, 'xh8yej3')]")));

        Thread.sleep(20000);
        for(int i = 0; i < elements.size(); i++){
            System.out.println(elements.get(i));
        }
    }
}
