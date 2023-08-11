import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
public class LoginTest extends BaseTest {
    @Test
    public void LoginValidEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail("teststudent@teststudent.com").providePW("te$t$tudent").clickSubmit();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
    @Test
    public void LoginValidEmailPassword() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.login();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
    @Test(dataProvider = "IncorrectLoginProviders", dataProviderClass = BaseTest.class)
    public void incorrectLoginTests(String email, String password){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.provideEmail(email);
        loginPage.providePW(password);
        loginPage.clickSubmit();
        System.out.println("URL is " + url);
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }
    @Test(dataProvider = "CorrectLoginProvider", dataProviderClass = BaseTest.class)
    public void correctLoginTests(String email, String password){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail(email).providePW(password).clickSubmit();
        Assert.assertTrue(homePage.avatarIsDisplayed());
    }
}
