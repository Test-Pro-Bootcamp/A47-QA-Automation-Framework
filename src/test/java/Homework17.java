import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class Homework17 extends BaseTest {

    @Test(priority = 1, description = "Validate new playlist is created")
    @Parameters({"Playlist"})
    public void createPlaylist(String Playlist) {
        openLoginURL();
        login("teststudent@teststudent.com", "te$t$tudent");
            String notificationText = "Created playlist \"" + Playlist + ".\"";
            createNewPlaylist(Playlist);
            newPlaylistNotification();
            Assert.assertTrue(newPlaylistIsDisplayed());
            Assert.assertTrue(newPlaylistNotification().contains(notificationText));
        }
    @Test (priority = 2, description = "Validate searched song is added to playlist")
    @Parameters({"Playlist"})
    public void addSongToPlaylist(String Playlist) {
        String notificationText = "Added 1 song into";
        openLoginURL();
        login("teststudent@teststudent.com", "te$t$tudent");
        searchSong ("Metre");
        searchSong ("Metre");
        clickViewAllButton ();
        clickFirstSong ();
        clickAddToButton ();
        clickPlaylist ();
        Assert.assertTrue(getNotification().contains(notificationText));
        //deleting the song added to playlist "Beta", to avoid failing while re-running code.
        selectPlaylistByName (Playlist);
        deleteFirstSongInPlaylist ();
        selectDeletePlaylist(Playlist);
    }
}