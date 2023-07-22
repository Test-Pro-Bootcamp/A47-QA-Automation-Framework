import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class PlaylistTest extends BaseTest {
    @Test
    public void renamePlaylist() {
        String playlistName = "Testing Playlist";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.login();
        homePage.doubleClickPlaylist()
                .newPlaylistName(playlistName);
        Assert.assertTrue(homePage.playlistIsDisplayed(playlistName));
    }
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
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String notificationText = "Added 1 song into";

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login();
        homePage.searchSong("Lobo");
        homePage.clickViewAll();
        homePage.selectFirstSongResult();
        homePage.clickAddTo();
        homePage.choosePlaylist();
        Assert.assertTrue(homePage.notificationMessage().contains(notificationText));
    }
}
