import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
public class LoginTest extends BaseTest {
    @Test
    public void LoginValidEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.provideEmail("teststudent@teststudent.com").providePW("te$t$tudent").clickSubmit();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
    @Test
    public void LoginValidEmailPassword() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
    @Test(dataProvider = "IncorrectLoginProviders", dataProviderClass = BaseTest.class)
    public void incorrectLoginTests(String email, String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail(email);
        loginPage.providePW(password);
        loginPage.clickSubmit();
        System.out.println("URL is " + url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
    @Test(dataProvider = "CorrectLoginProvider", dataProviderClass = BaseTest.class)
    public void correctLoginTests(String email, String password){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.provideEmail(email).providePW(password).clickSubmit();
        Assert.assertTrue(homePage.avatarIsDisplayed());
    }
}
