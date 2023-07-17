import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test
    public void loginInvalidEmailValidPasswordTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.provideEmail("invalid@email.com")
                .providePassword("te$t$tudent")
                .clickSubmit();
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }
    @Test
    public void loginValidEmailPasswordTest (){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("demo@class.com")
                .providePassword("te$t$tudent")
                .clickSubmit();
        Assert.assertTrue(homePage.isAvatarDisplayed());


    }
    @Test
    public void LoginEmptyEmailPasswordTest() {

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.provideEmail("")
                .providePassword("te$t$tudent")
                .clickSubmit();
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }
}
