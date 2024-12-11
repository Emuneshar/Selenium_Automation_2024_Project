package Day4_10292024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class T4_Google_Search_Loop {
    public static void main(String[] args) {
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Queens");
        cities.add("Brooklyn");
        cities.add("Bronx");

        WebDriver driver = new ChromeDriver();
        String url = "https://www.google.com";

        for(int i = 0; i < cities.size(); i++){
            String currentCity = cities.get(i);
            driver.navigate().to(url);

            driver.findElement(By.xpath("//*[@name = 'q']")).sendKeys(cities.get(i));
            driver.findElement(By.xpath("//*[@name = 'q']")).submit();
            driver.findElement(By.xpath("//*[@id = 'hdtb-tls']")).click();

            // Tell the driver to get the number of results from the results page
            String result = driver.findElement(By.xpath("//*[@id = 'result-stats']")).getText();

            String [] splitMessage = result.split(" ");

            System.out.println("The city is " + currentCity + " and the number of results are " + splitMessage[1] );
        }

        driver.quit();
    }
}
