import POM.Pages.HomePage;
import POM.Pages.LoginPage;
import POM.Pages.SongsPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaylistTests extends BaseTest{

    @Test
    public void createNewPlaylist(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login("angel.ayala@testpro.io", "school!sc0");
        homePage.createPlaylist().newPlaylistSelection().enterNewPlaylistName("playTest12");

        Assert.assertTrue(homePage.verificationMessage().contains("Created"));
    }
    @Test
    public void deleteActivePlaylist(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login("angel.ayala@testpro.io", "school!sc0");
        homePage.clickFirstPlaylist().clickDeleteButton();
        Assert.assertTrue(homePage.verificationMessage().contains("Deleted"));
    }
    @Test
    public void addSongToPlaylist(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        SongsPage songsPage = new SongsPage(getDriver());

        loginPage.login("angel.ayala@testpro.io","school!sc0");
        songsPage.goToAllSongs().clickFirstSong().clickAddButton().addToPlaylistSelection();
        Assert.assertTrue(homePage.verificationMessage().contains("Added"));
    }
}
