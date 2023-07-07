import Pages.HomePage;
import Pages.LoginPage;
import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.*;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void LoginValidCredentialsTest() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();

        Assert.assertTrue(homePage.getAvatarIcon().isDisplayed());
    }
}
