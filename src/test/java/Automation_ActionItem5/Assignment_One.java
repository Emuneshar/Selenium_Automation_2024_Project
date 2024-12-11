package Automation_ActionItem5;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class Assignment_One {
    public static void main(String[] args) throws InterruptedException {

        // Creates an array list and saves the zipcodes
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11427");
        zipCode.add("11428");

        // Creates an array list and saves in policy start date
        ArrayList<String> policyStart = new ArrayList<>();
        policyStart.add("12/13/2024");
        policyStart.add("01/11/2025");


        // Creates an array list and saves in first names
        ArrayList<String> firstName = new ArrayList<>();
        firstName.add("Patrick");
        firstName.add("Tom");

        // Creates an array list and saves in last names
        ArrayList<String> lastName = new ArrayList<>();
        lastName.add("Mahomes");
        lastName.add("Brady");

        // Creates an array list and saves in address
        ArrayList<String> streetAdd = new ArrayList<>();
        streetAdd.add("89-23 216th Street");
        streetAdd.add("93-21 214th Street");

        // Creates an array list to save the date of birth for applicants
        ArrayList<String> dob = new ArrayList<>();
        dob.add("09/17/1994");
        dob.add("08/03/1976");

        // Creates an array list and saves the coApplicant first names
        ArrayList<String> coFirstName = new ArrayList<>();
        coFirstName.add("Brittany");
        coFirstName.add("Taylor");

        // Creates an array list and saves the coApplicant last names
        ArrayList<String> coLastName = new ArrayList<>();
        coLastName.add("Mahomes");
        coLastName.add("Swift");

        // Sets the chrome options for our driver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");

        // Creates the driver for our testing and passing in the options as a parameter
        WebDriver driver = new ChromeDriver(options);

        // Here we set an implicit wait that will delay the code by up to 10 seconds or until the web elements load
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Here we use a for loop to repeat our automation steps for the number of mock data sets we have
        for (int i = 0; i < zipCode.size(); i++) {

            driver.navigate().to("https://www.statefarm.com/"); // Here we are navigating to the state farm site

            // Here I use a try and catch statement to store the 'Get a quote' menu option into a web element and attempt to click on it. If it doesn't work I print out a reason why
            try{
                WebElement getQuoteButton = driver.findElement(By.xpath("//*[contains(text(), 'Get a Quote')]"));
                getQuoteButton.click();
            }
            catch (Exception e) {
                System.out.println("Couldn't click on get a quote " + e);
            }

            // Here I use a try and catch statement to toggle the menu by click on it. If it doesn't work I print out a reason why
            try{
                WebElement dropDown = driver.findElement(By.xpath("//*[@id = 'product-select1']"));
                dropDown.click();
            }
            catch (Exception e) {
                System.out.println("Couldn't click on the drop down " + e);
            }

            // Here I use a try and catch statement to Select Homeowners insruance from the menu. If it doesn't work I print out a reason why
            try{
                WebElement homeOwners = driver.findElement(By.xpath("//*[@value = 'Homeowners']"));
                homeOwners.click();
            }
            catch (Exception e) {
                System.out.println("Couldn't select homeowners from the drop down");
            }

            // Here I use a try and catch statement to send in our mock zipcode. If it doesn't work I print out a reason why
            try{
                WebElement zipCodeField = driver.findElement(By.xpath("//*[@id = 'quote-main-zip-code-input1']"));
                zipCodeField.clear();
                zipCodeField.sendKeys(zipCode.get(i));
            }
            catch (Exception e) {
                System.out.println("Couldn't send the zip code " + e);
            }

            // Here I use a try and catch statement to save the start quote button into a WebElement and click on it. If it doesn't work I print out a reason why
            try{

                WebElement startQuote = driver.findElement(By.xpath("//*[@id = 'quote-submit-button1']"));
                startQuote.click();
            }
            catch (Exception e) {
                System.out.println("Couldn't Click on the submit button " + e);
            }

            // Here I use a try and catch statement to send the date we would like the policy to start. If it doesn't work I print out a reason why
            try{
                WebElement startDate = driver.findElement(By.xpath("//*[@id = 'effectiveDate']"));
                startDate.clear();
                startDate.sendKeys(policyStart.get(i));
            }
            catch (Exception e) {
                System.out.println("Couldn't send policy start date " + e);
            }

            // Here I use a try and catch statement to send the first name from our mock data. If it doesn't work I print out a reason why
            try{
                WebElement firstNameField = driver.findElement(By.xpath("//*[@id = 'firstName']"));
                firstNameField.clear();
                firstNameField.sendKeys(firstName.get(i));
            } catch (Exception e) {
                System.out.println("Couldn't send the first name " + e);
            }

            // Here I use a try and catch statement to send the last name from our mock data. If it doesn't work I print out a reason why
            try{
                WebElement lastNameField = driver.findElement(By.xpath("//*[@id = 'lastName']"));
                lastNameField.clear();
                lastNameField.sendKeys(lastName.get(i));
            } catch (Exception e) {
                System.out.println("Couldn't send the last name " + e);
            }

            // Here I use a try and catch statement to send the address from our mock data. If it doesn't work I print out a reason why
            try{
                WebElement addressField = driver.findElement(By.xpath("//*[@id = 'street']"));
                addressField.clear();
                addressField.sendKeys(streetAdd.get(i));
            } catch (Exception e) {
                System.out.println("Couldn't send the address " + e);
            }

            // Here I use a try and catch statement to send the date of birth from our mock data. If it doesn't work I print out a reason why
            try{
                WebElement dateOfBirth = driver.findElement(By.xpath("//*[@id = 'dateOfBirth']"));
                dateOfBirth.clear();
                dateOfBirth.sendKeys(dob.get(i));
            } catch (Exception e) {
                System.out.println("Couldn't send the date of birth  " + e);
            }

            JavascriptExecutor jse = (JavascriptExecutor) driver; // Here I created a Javascript executor to scroll down to the next button on the current page

            // Here I use a try and catch statement to scroll into view of the continue button. If it doesn't work I print out a reason why
            try{
                WebElement continueButton = driver.findElement(By.xpath("//*[@name = 'continue']"));
                jse.executeScript("arguments[0].scrollIntoView(true);", continueButton);

            }
            catch (Exception e) {
                System.out.println("Couldn't locate button to scroll to " + e);
            }

            // Here I use a try and catch statement to click on the continue button. If it doesn't work I print out a reason why
            try{
                WebElement continueButton = driver.findElement(By.xpath("//*[@name = 'continue']"));
                continueButton.click();
            }
            catch (Exception e) {
                System.out.println("Couldn't click continue  " + e);
            }

            // Here I use a try and catch statement to select the correct town name from the drop down menu. If it doesn't work I print out a reason why
            try{
                WebElement menu = driver.findElement(By.xpath("//*[@id = 'fireProtectionAreaNameSelectId']"));
                Select dropDown = new Select(menu);
                dropDown.selectByIndex(1);
            }
            catch (Exception e) {
                System.out.println("Couldn't select item from menu " + e);
            }

            // Here I use a try and catch statement to click on the continue button to go to the next page. If it doesn't work I print out a reason why
            try{
                WebElement continueButton = driver.findElement(By.xpath("//*[@id = 'continue']"));
                continueButton.click();
            }
            catch (Exception e) {
                System.out.println("Couldn't click on the continue button " + e);
            }

            // Here I use a try and catch statement to get the message information from the Applicant info section and print it out. If it doesn't work I print out a reason why
            try{
                WebElement applicantInfo = driver.findElement(By.xpath("//*[@class = 'sfx-pageDescription']"));
                String info = applicantInfo.getText();
                System.out.println("Personal info message: " + info);
            }
            catch (Exception e) {
                System.out.println("Can't get the applicant info " + e);
            }

            // Here I use a try and catch statement to get the message from the email message section and print it out. If it doesn't work I print out a reason why
            try{
                WebElement emailInfo = driver.findElements(By.xpath("//*[@class = 'help-block']")).get(0);
                String info = emailInfo.getText();
                System.out.println("Email info message: " + info);
            }
            catch (Exception e) {
                System.out.println("Can't get the email info message " + e);
            }

            // Here I use a try and catch statement to scroll down on the page using a javascript executor and get the description from the add applicant section. If it doesn't work I print out a reason why
            try {
                WebElement element = driver.findElement(By.xpath("//*[@id = 'addApplicantDescription']"));
                jse.executeScript("arguments[0].scrollIntoView(true);", element);
                String info = element.getText();
                System.out.println("Add applicant info message: " + info);
            } catch (Exception e) {
                System.out.println("Couldn't get the info for the add applicant section: " + e.getMessage());
            }

            // Here I use a try and catch statement to click on the add applicant button. If it doesn't work I print out a reason why
            try{
                WebElement addApplicantButton = driver.findElement(By.xpath("//*[@id = 'addApplicantModuleNewAdd']"));
                addApplicantButton.click();
            }
            catch (Exception e) {
                System.out.println("Can't click on the add applicant button " + e );
            }

            // Here I use a try and catch statement to send the coApplicant first name. If it doesn't work I print out a reason why
            try {
                WebElement coApplicantFirstName = driver.findElement(By.xpath("//*[@id  = 'sfx_additionalApplicants[0].client.firstName_input']"));
                coApplicantFirstName.clear();
                coApplicantFirstName.sendKeys(coFirstName.get(i));
            }
            catch (Exception e) {
                System.out.println("Couldn't send over the coapplicant first name at line 248" );
            }

            // Here I use a try and catch statement to send the coApplicant last name. If it doesn't work I print out a reason why
            try{
                WebElement coApplicantLastName = driver.findElement(By.xpath("//*[@id = 'sfx_additionalApplicants[0].client.lastName_input']"));
                coApplicantLastName.clear();
                coApplicantLastName.sendKeys(coLastName.get(i));
            } catch (Exception e) {
                System.out.println("Line 256: Couldn't send the co applicant last name due to " + e);
            }

            // Here I use a try and catch statement to click on the continue button after scrolling down to it. If it doesn't work I print out a reason why
            try{
                //JavascriptExecutor ex = (JavascriptExecutor)driver;
                WebElement continueButton = driver.findElement(By.xpath("//*[@id = 'continue']"));
                jse.executeScript("arguments[0].scrollIntoView(true);", continueButton);
                Thread.sleep(2000);
                continueButton.click();
            } catch (Exception e) {
                System.out.println("Line 264: Couldn't click on the continue button due to " + e);
            }

            // Here I use a try and catch statement to get the error message that pops up on the screen if we try to proceed. If it doesn't work I print out a reason why
            try{
                String error = driver.findElement(By.xpath("//*[@id = 'sfx_global_alert']")).getText();
                System.out.println("The error from Statefarm site: " + error);
            } catch (Exception e) {
                System.out.println("Couldn't get the error message due to " + e);
            }

        } // end of loop

        // Here we close the current driver window once the process is completed.
        Thread.sleep(3000);
        System.out.println("Process is complete, the browser will close now");
        driver.quit();

    } // End of main method
} // End of class
