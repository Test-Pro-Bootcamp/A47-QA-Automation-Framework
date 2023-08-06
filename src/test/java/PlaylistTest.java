import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class PlaylistTest extends BaseTest {
        @Test(priority = 1, description = "Validate new playlist is created")
        @Parameters({"Playlist"})
        public void createPlaylist (String Playlist) {
            LoginPage loginPage = new LoginPage(driver);
            PlayListPage playListPage = new PlayListPage(driver);
            loginPage.login();

            String notificationText = "Created playlist \"" + Playlist + ".\"";
            playListPage.createNewPlaylist(Playlist);
            playListPage.newPlaylistNotification();
            Assert.assertTrue(playListPage.newPlaylistIsDisplayed());
            Assert.assertTrue(playListPage.newPlaylistNotification().contains(notificationText));
        }
        @Test(priority = 2, description = "Validate playlist is renamed using doubleClick")
        @Parameters({"Playlist", "NewPlaylistName"})
        public void renamePlaylist(String Playlist, String NewPlaylistName)  {
            LoginPage loginPage = new LoginPage(driver);
            PlayListPage playListPage = new PlayListPage(driver);
            loginPage.login();
            playListPage.doubleClickPlaylist(Playlist);
            playListPage.enterNewPlaylistName(NewPlaylistName);
               String messageText = "Updated playlist \"" + NewPlaylistName +".\"";
               Assert.assertEquals(playListPage.playlistNameChangeNotify(), messageText);
         //   Assert.assertTrue(playListPage.doesPlaylistExist(NewPlaylistName));
        }
    @Test(priority = 3, description = "Validate empty renamed playlist is deleted")
    @Parameters({"NewPlaylistName"})
    public void deleteRenamedPlaylist(String NewPlaylistName) {
        LoginPage loginPage = new LoginPage(driver);
        PlayListPage playListPage = new PlayListPage(driver);
        loginPage.login();

        playListPage.selectDeleteRenamedPlaylist(NewPlaylistName);
        String notifyText = "Deleted playlist \"" + NewPlaylistName + ".\"";
        System.out.println("Message should be: " + notifyText);
        Assert.assertTrue(playListPage.deletedPlaylistNotify().contains(notifyText));
    }
    @Test(priority = 4, description = "Validate playlist is renamed using contextClick")
    @Parameters({"Playlist", "NewPlaylistName"})
    public void renamePlaylistContextClick (String Playlist, String NewPlaylistName) throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        PlayListPage playListPage = new PlayListPage(driver);
        loginPage.login();

        playListPage.createNewPlaylist(NewPlaylistName);
        playListPage.contextClickPlaylist(NewPlaylistName);
        playListPage.clickEditMenu();
        playListPage.enterNewPlaylistName(Playlist);
        Assert.assertTrue(playListPage.doesPlaylistExist(Playlist));
        //  String messageText = "Updated playlist \"" + NewPlaylistName +".\"";
        //   Assert.assertEquals(playlistNameChangeNotify(), messageText);
    }
}


