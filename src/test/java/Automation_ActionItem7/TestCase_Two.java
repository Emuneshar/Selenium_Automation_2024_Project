package Automation_ActionItem7;

import Day13_12022024.TestParent;
import org.testng.annotations.Test;

public class TestCase_Two extends TestParent {
    String url = "https://www.northwesternmutual.com/";

    @Test
    public void tc001_verifyConnectToAdvisor(){
        driver.navigate().to(url);
        
    }
}
