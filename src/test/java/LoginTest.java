import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
public class LoginTest extends BaseTest {
    @Test
    public void LoginValidEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.login();
        Assert.assertTrue(homePage.isAvatarDisplayed());
    }
    @Test
    public void LoginInvalidEmailValidPasswordTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.provideEmail("invalid@email.com")
                .providePassword("te$t$tudent")
                .clickSubmit();
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }
    @Test
    public void loginValidEmailEmptyPasswordTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.provideEmail("demo@class.com")
                .providePassword("")
                .clickSubmit();
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }
    @Test
    public void loginEmptyEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.provideEmail("")
                .providePassword("te$t$tudent")
                .clickSubmit();
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }
}