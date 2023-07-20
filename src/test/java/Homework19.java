import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework19 extends BaseTest {
    @Test
    public void deletePlaylist() {
        String deleteMsg = "Deleted playlist";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.login();
        homePage.openPlaylist();
        homePage.deletePlaylistBtn();
        homePage.getDeleteMsg();
        Assert.assertTrue(homePage.getDeleteMsg().contains(deleteMsg));
    }
}
