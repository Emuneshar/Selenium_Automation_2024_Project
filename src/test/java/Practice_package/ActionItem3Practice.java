package Practice_package;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class ActionItem3Practice {
    public static void main(String[] args) throws InterruptedException {

        String title = "WebMD - Better information. Better health.";
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11418");
        zipCode.add("11001");
        zipCode.add("11367");

        WebDriver driver = setUpDriver("start-maximized", "incognito");
        goToSite(driver);
        if (verification(driver, title)){
            System.out.println("verification match");
        }
        else{
            System.out.println("failed");
        }
        int x = 0;

        while(x < zipCode.size()){

            goToSite(driver);

            if(verification(driver, title)) {
                driver.findElement(By.xpath("//*[(text()= 'Find a Doctor')]")).click();

                backSpace(driver);

                driver.findElement(By.xpath("//*[contains(@class, 'zipcode-input')]")).sendKeys(zipCode.get(x));

                driver.findElement(By.xpath("//*[contains(@class, 'zipcode-input')]")).submit();

                Thread.sleep(3000);
                String results = driver.findElements(By.xpath("//*[@class = 'prov-name']")).get(0).getText();

                String experience = driver.findElements(By.xpath("//*[@class = 'prov-experience']")).get(0).getText();

                System.out.println("The provider name is " + results + " and their experience is " + experience);

                x++;
            }
        }

        // Closes the current driver
        driver.quit();

    }

    public static void backSpace(WebDriver driver){
        for (int i = 0; i < 50; i++) {
            driver.findElement(By.xpath("//*[contains(@class, 'zipcode-input')]")).sendKeys(Keys.BACK_SPACE);
        }
    }
    public static boolean verification(WebDriver driver, String title){
        boolean verification = false;
        String siteTitle = driver.getTitle();
        if (siteTitle.equals(title)){
            verification = true;
        }
        else{
            verification = false;
        }
        return verification;
    }
    public static WebDriver setUpDriver(String zero, String one){
        // Setting up new Chrome options for chrome window
        ChromeOptions options = new ChromeOptions();
        options.addArguments(zero);
        options.addArguments(one);

        // Creating a new Chrome window with the options from above
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }
    public static void goToSite(WebDriver string){
        string.navigate().to("https://www.webmd.com");
    }
}
