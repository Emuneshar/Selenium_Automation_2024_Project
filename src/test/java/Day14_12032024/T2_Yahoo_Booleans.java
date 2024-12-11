package Day14_12032024;

import Day13_12022024.TestParent;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_Yahoo_Booleans extends TestParent {

    String checkBoxXPath = "//*[@id = 'persistent']";

    @Test
    public void tc001_verifyCheckBoxSelected(){
        driver.navigate().to("https://www.yahoo.com");
        ReuasableMethodsLoggers.clickMethod(driver, "//*[text() = 'Sign in']", logger, "Sign In Button");
        boolean isChecked = driver.findElement(By.xpath(checkBoxXPath)).isSelected();
        Assert.assertTrue(isChecked, "The checkbox is checked " + isChecked);
    } // End of test case

    @Test
    public void tc002_verifySignInOptionIsUnchecked() {
        //click on the checkbox to uncheck it
        ReuasableMethodsLoggers.clickMethod(driver, "//*[@class = 'stay-signed-in checkbox-container']", logger,"CheckBox");
        //check the state of the checkbox (it should be unchecked now)
        boolean isChecked = driver.findElement(By.xpath(checkBoxXPath)).isSelected();
        assertTrueLogger(isChecked);
    }//end of test case 2, should fail because user unchecked the checkbox
    
    
    
}// end of child test class
