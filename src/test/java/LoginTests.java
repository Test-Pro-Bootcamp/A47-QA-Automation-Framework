import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Homepage;
import pages.LoginPage;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void LoginEmptyEmailPasswordTest() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);

        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }
    public void LoginValidEmailPassword() {
        LoginPage loginPage = new LoginPage(getDriver());
        Homepage homepage = new Homepage(getDriver());

loginPage.provideEmail("randy.davila@testpro.io");
loginPage.providePassword("te$t$tudent");
clickSubmit();

Assert.assertTrue(homepage.isAvatarDisplayed);
    }

    public void LoginInvalidEmailPassword() {
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("invalid@email.com");
        loginPage.providePassword("te$t$tudent");
        clickSubmit();
    }

}
