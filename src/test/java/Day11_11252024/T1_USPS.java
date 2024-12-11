package Day11_11252024;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class T1_USPS {




    public static void main(String[] args) throws InterruptedException {


        // Use the helper method to save the driver
        WebDriver driver = ReuasbleMethods.setup();
        driver.navigate().to("https://www.usps.com");


        Thread.sleep(2000);

        String text = ReuasbleMethods.captureText(driver, "//*[@class = 'header-2']", "Holiday text");
        System.out.println(text);


        ReuasbleMethods.clickMethodWithIndex(driver, "//*[contains(text(), 'Receieve')]",1,"Quick tools");
        Thread.sleep(4000);
        //ReuasbleMethods.clickMethod(driver, "//*[text()= 'Track a Package']",  "Track a package");

        Thread.sleep(6000);
        driver.quit();
    } // End of main



} // End of class
