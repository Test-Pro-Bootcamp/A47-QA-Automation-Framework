import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test (dataProvider = "IncorrectLoginProviders")
    public void LoginInvalidEmailPasswordTest(String email, String password) throws InterruptedException {

        enterEmail(email);

        enterPassword(password);

        clickLogInbutton();

        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), url);

//        String url = "https://qa.koel.app/";
//        driver.get(url);
//        Assert.assertEquals(driver.getCurrentUrl(), url);
//        driver.quit();
    }
}
