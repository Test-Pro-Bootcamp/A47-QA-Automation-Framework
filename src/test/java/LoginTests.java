import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void LoginEmptyEmailPasswordTest() {

        // Open the URL for the web page on the Chrome Browser
        openLoginUrl();

        // Put the email field inside the web page
        enterEmail("andrea.guevara@testpro.io");

        // Put the password field inside the web page
        enterPassword("te$t$tudent");

        //click on the submit button
        clickSubmit();

    }
}

