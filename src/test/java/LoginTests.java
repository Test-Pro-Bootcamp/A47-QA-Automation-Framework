import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import static java.sql.DriverManager.getDriver;

public class LoginTests extends BaseTest{

    @Test
    public void loginValidEmailPasswordTest(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

    }



}
