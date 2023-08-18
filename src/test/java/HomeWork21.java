import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class HomeWork21 extends BaseTest{
    @Test
    public void renamePlaylist(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.logIn();
        homePage.doubleClickPlaylist();
        homePage.enterNewPlaylistName();
        Assert.assertTrue(homePage.doesPlaylistExists());
    }
}
