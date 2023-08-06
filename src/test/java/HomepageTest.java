import Pages.HomePage;
import Pages.LoginPage;
import Pages.PlayListPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class HomepageTest extends BaseTest {
    @Test(priority = 4, description = "Validate playlist is created")
    @Parameters({"Playlist"})
    public void createPlaylist(String Playlist) {
        LoginPage loginPage = new LoginPage(driver);
        PlayListPage playListPage = new PlayListPage(driver);
        loginPage.login();
        playListPage.createNewPlaylist(Playlist);
        playListPage.newPlaylistNotification();
        Assert.assertTrue(playListPage.newPlaylistIsDisplayed());
    }
    @Test(priority = 5, description = "Validate song is added to playlist")
    @Parameters({"Playlist"})
    public void addSongToPlaylist(String Playlist) {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        PlayListPage playListPage = new PlayListPage(driver);
        loginPage.login();

        homePage.searchSong ("Metre");
        homePage.searchSong ("Metre");
        homePage.clickViewAllButton ();
        homePage.clickFirstSong ();
        homePage.clickAddToButton ();
        homePage.clickPlaylist ();
        String notificationText = "Added 1 song into";
        // String notificationText = "Added 1 song into \"" + Playlist + ".\"";
        Assert.assertTrue(homePage.getNotification().contains(notificationText));
    }
    @Test(priority = 6, description = "Validate specified playlist containing song is deleted")
    @Parameters({"Playlist"})
    public void deleteSelectedPlaylistWithSong(String Playlist) throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        PlayListPage playListPage = new PlayListPage(driver);

        loginPage.login();
        playListPage.selectDeletePlaylistWithSong(Playlist);
        Assert.assertTrue(playListPage.isPlaylistDeleted(Playlist));

        String notifyText = "Deleted playlist \"" + Playlist + ".\"";
        System.out.println("Message should be: " + notifyText);
        Assert.assertTrue(playListPage.deletedPlaylistNotify().contains(notifyText));
    }
}

