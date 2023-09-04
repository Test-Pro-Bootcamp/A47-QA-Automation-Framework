import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    @Test
    public void LoginValidEmailPassword() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();

        //loginPage.provideEmail("aimee.woodside@testpro.io").providePassword("te$t$tudent13").clickSubmit();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

}
