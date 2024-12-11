package Day5_11042024;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T4_GetTitle {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com");
        String title = driver.getTitle();

        if(title.equals("Google")){
            System.out.println("The title matches");
        }
        else{
            System.out.println("Something went horribly wrong");
        }

        driver.quit();
    }
}
