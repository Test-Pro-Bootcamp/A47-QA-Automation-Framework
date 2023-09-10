import pages.HomePage;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTests extends BaseTest {
    @Test (dataProvider = "ValidLoginData", dataProviderClass = BaseTest.class)
    public void successfulLoginTest(String email, String password){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login(email, password);
        Assert.assertTrue(homePage.getAvatar().isDisplayed());
    }

    @Test (dataProvider = "InvalidLoginData", dataProviderClass = BaseTest.class)
    public void invalidLoginTest(String email, String password){
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.login(email, password);
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }
}
