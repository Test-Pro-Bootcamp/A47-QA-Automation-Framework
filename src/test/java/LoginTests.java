
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test
    public void loginValidCredentialsTest() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        homePage.waitForOverlay(overlayLocator);

        Assert.assertTrue(homePage.getAvatarIcon().isDisplayed());
    }
}
