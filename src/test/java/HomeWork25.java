import org.testng.annotations.Test;
import pages.LoginPage;

public class HomeWork25 extends BaseTest{
    @Test
    public void emailPasswordLoginTest () {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.provideEmail("beomseo.park@testpro.io").providePassword("te$t$tudent").clickSubmit();
    }
    @Test
    public void loginTest () {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginUrl();
        loginPage.login();
    }
}
