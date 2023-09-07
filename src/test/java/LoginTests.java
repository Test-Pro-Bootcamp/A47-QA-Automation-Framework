import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;



public class LoginTests extends BaseTest {
    @Test
    public void LoginEmptyEmailPasswordTest() {

        enterEmail("andrea.guevara@testpro.io");
        enterPassword("te$t$tudent");
        clickSubmit();
    }
    
}

