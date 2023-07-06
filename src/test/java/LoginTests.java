import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test(dataProvider = "CorrectLoginProviders")
    public void LoginValidPasswordTest(String email, String password) throws InterruptedException{

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);

        openLoginUrl();
        enterEmail(email);
        enterPassword(password);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }
}
