import POM.Pages.HomePage;
import POM.Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTests extends BaseTest{

    @Test
    public void registrationNavigation(){
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.getRegistered();
        Assert.assertTrue(loginPage.registerButton().isDisplayed());
    }

    @Test(dataProvider = "validCredentials", dataProviderClass = BaseTest.class)
    public void loginValidCredentials(String email, String password){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.enterEmail(email).enterPassword(password).clickSubmit();
        Assert.assertTrue(homePage.avatar().isDisplayed());
    }
    
}
