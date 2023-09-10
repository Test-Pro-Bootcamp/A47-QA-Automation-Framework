import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.LoginPage;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void validLoginTest1 () {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.provideEmail("beomseo.park@testpro.io").providePassword("te$t$tudent").clickSubmit();
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }
    @Test
    public void validLoginTest2 () {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login();
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }
}
