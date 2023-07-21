import POM.Pages.HomePage;
import POM.Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test
    public void registrationNavigation(){
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.getRegistered();
        Assert.assertTrue(loginPage.registerButton().isDisplayed());
    }

    @Test
    public void loginValidCredentials(String email, String password){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.enterEmail("angel.ayala@testpro.io").enterPassword("school!sc0").clickSubmit();
        Assert.assertTrue(homePage.avatar().isDisplayed());
    }
    @Test(dataProvider = "regressionTests", dataProviderClass = BaseTest.class)
    public void loginInvalidCredentials(String email, String password){
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.enterEmail(email).enterPassword(password).clickSubmit();
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }
}
