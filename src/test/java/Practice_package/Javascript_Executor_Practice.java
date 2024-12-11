package Practice_package;

import Day13_12022024.TestParent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Javascript_Executor_Practice extends TestParent {
    public static void main(String[] args) {

        WebElement n = driver.findElement(By.xpath(""));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", n);
    }
}
