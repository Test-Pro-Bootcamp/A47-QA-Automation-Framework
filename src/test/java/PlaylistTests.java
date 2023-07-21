import POM.Pages.HomePage;
import POM.Pages.LoginPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaylistTests extends BaseTest{

    @Test
    public void createNewPlaylist(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login("angel.ayala@testpro.io", "school!sc0");
        homePage.createPlaylist().newPlaylistSelection().enterNewPlaylistName("playTest");

        Assert.assertTrue(homePage.verificationMessage().contains("Created"));
    }
    @Test
    public void deleteActivePlaylist(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login("angel.ayala@testpro.io", "school!sc0");
        homePage.selectFirstPlaylist().clickDeletePlaylist();
        Assert.assertTrue(homePage.verificationMessage().contains("Deleted"));
    }
    @Test
    public void addSongToPlaylist(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login("angel.ayala@testpro","school!sc0");
        homePage.selectFirstPlaylist()
    }
}
