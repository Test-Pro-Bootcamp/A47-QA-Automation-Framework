import Pages.HomePage;
import Pages.LoginPage;
import Pages.PlayListPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class HomepageTest extends BaseTest {
    @Test(priority = 5, description = "Validate song is added to playlist")
    @Parameters({"Playlist"})
    public void addSongToPlaylist(String Playlist) {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
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

    @Test(priority = 6, description = "Validate song is deleted from playlist")
    @Parameters({"Playlist"})
    public void deleteSong(String Playlist) {
        LoginPage loginPage = new LoginPage(driver);
        PlayListPage playListPage = new PlayListPage(driver);
        loginPage.login();
        String msgText1 = "Removed 1 song from \"" + Playlist + ".\"";
        playListPage.selectPlaylist (Playlist);
        playListPage.deleteSongFromPlaylist();
        System.out.println("Message should be: " + msgText1);
        String msgReturn = playListPage.delSongNotificationMsg();
        Assert.assertTrue(msgReturn.contains(msgText1));
    }
    @Test(priority = 7, description = "Validate specified playlist is deleted")
    @Parameters({"Playlist"})
    public void deleteSelectedPlaylist(String Playlist) throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        PlayListPage playListPage = new PlayListPage(driver);

        loginPage.login();
        playListPage.selectDeletePlaylist(Playlist);
        Assert.assertTrue(playListPage.isPlaylistDeleted(Playlist));

        String notifyText = "Deleted playlist \"" + Playlist + ".\"";
        System.out.println("Message should be: " + notifyText);
        Assert.assertTrue(playListPage.deletedPlaylistNotify().contains(notifyText));
    }
}

