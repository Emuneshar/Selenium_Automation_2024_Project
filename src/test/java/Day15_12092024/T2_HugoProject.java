package Day15_12092024;


import Day13_12022024.TestParent;
import Day14_12032024.ReuasableMethodsLoggers;
import org.testng.annotations.Test;

public class T2_HugoProject extends TestParent {
    @Test
    public void tc001_verifyPlanTravelSubMenu() throws InterruptedException {
        //navigate to united airlines
        driver.navigate().to("https://www.united.com/");
        //click on Book module
        ReuasableMethodsLoggers.clickMethod(driver, "//*[@data-name = 'id_book_3']", logger, "Book");
        //verify the sub menu for book a flight
        String actualText = ReuasableMethodsLoggers.captureText
                (driver, "//*[@class= 'app-components-GlobalHeader-NavbarSubMenuList-NavbarSubMenuList__subMenuItemContainer--KLYxw']", logger, "BookAFlightSubMenu");

        String expectedText = "Flights\n" +
                "Award travel\n" +
                "Map search\n" +
                "Personalize your trip\n" +
                "Book with travel credits\n" +
                "All booking options";
        //assert that both are equal
        assertEqualsLogger(actualText, expectedText);
        //wait a bit
        Thread.sleep(2000);
    }//end of test case 1
    @Test
    public void tc002_verifyPersonalizeYourTrip() throws InterruptedException {
        //navigate to united airlines
        driver.navigate().to("https://www.united.com/");
        //click on Book module
        ReuasableMethodsLoggers.clickMethod(driver, "//*[@data-name = 'id_book_3']", logger, "Book");
        //Click on personalize your flight sub menu
        ReuasableMethodsLoggers.clickMethod(driver, "//*[text() = 'Personalize your trip']", logger, "Trip");
        //wait a bit
        Thread.sleep(3000);
        //click on premium cabin
        ReuasableMethodsLoggers.clickMethod(driver, "//*[text() = 'Premium cabin']", logger, "PremiumCabin");
    }//end of test case 2
}
