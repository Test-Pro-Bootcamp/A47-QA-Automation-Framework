import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework21 extends BaseTest {
    @Test
    public void renamePlaylist() {
        String playlistName = "Testing Playlist";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.login();
        homePage.doubleClickPlaylist();
        homePage.newPlaylistName(playlistName);
        Assert.assertTrue(homePage.playlistIsDisplayed(playlistName));
    }
}
