import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTests extends BaseTest{

    @Test
    public void hoverOverPlayBtn()  {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login();
        homePage.hoverAction(homePage.sidePlayerControl);
//        Thread.sleep(2000);
        Assert.assertTrue(homePage.isPlayBtnDisplayed());
    }

}
