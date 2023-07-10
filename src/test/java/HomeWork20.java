import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomeWork20 extends BaseTest{

    @Test (description = "Validate Registration Navigation")
    public void registrationNavigation() {
        String registerUrl = "https://qa.koel.app/registration.php";
        registrationNavigate();
        Assert.assertEquals(driver.getCurrentUrl(), registerUrl);
       Assert.assertTrue(registerBtnIsDisplayed());
    }
    @Test (description = "Validate Login")
    public void login(){
        provideEmail("teststudent@teststudent.com");
        providePW("te$t$tudent");
        clickSubmit();
    }
    @Test(priority = 1, description = "Validate new playlist is created")
    @Parameters({"Playlist"})
    public void createPlaylist( String Playlist) throws InterruptedException {
        login("teststudent@teststudent.com", "te$t$tudent");
        String notificationText = "Created playlist \"" + Playlist + ".\"";
        createNewPlaylist(Playlist);
        newPlaylistNotification();
        Assert.assertTrue(newPlaylistIsDisplayed());
        Assert.assertTrue(newPlaylistNotification().contains(notificationText));
    }
    @Test(priority = 2, description = "Validate song is added to playlist")
    @Parameters({"Playlist"})
    public void addSongToPlaylist(String Playlist) {
      //  String notificationText = "Added 1 song into";
        String notificationText = "Added 1 song into \"" + Playlist + ".\"";
        login("teststudent@teststudent.com", "te$t$tudent");
        searchSong ("Metre");
        searchSong ("Metre");
        clickViewAllButton ();
        clickFirstSong ();
        clickAddToButton ();
        clickPlaylist (Playlist);
        Assert.assertTrue(getNotification().contains(notificationText));
    }
    @Test (priority = 2, description = "Validate a song is playing")
    public void playSong() {
        login("teststudent@teststudent.com", "te$t$tudent");
        clickPlayNextSong();
        clickPlaySong();
        Assert.assertTrue(pauseButtonDisplay());
        Assert.assertTrue(soundBarVisualizerDisplay());
        Assert.assertTrue(progressBarDisplay());
    }
    @Test(priority = 3, description = "Validate song is deleted from playlist ")
    @Parameters({"Playlist"})
    public void deleteSong(String Playlist) {
        login("teststudent@teststudent.com", "te$t$tudent");
        String msgText1 = "Removed 1 song from \"" + Playlist + ".\"";
        selectPlaylist (Playlist);
        deleteSongFromPlaylist();
        System.out.println("Message should be: " + msgText1);
        String msgReturn = delSongNotificationMsg();
        Assert.assertTrue(msgReturn.contains(msgText1));
    }
    @Test(priority = 4, description = "Validate existing/specified & empty playlist is deleted")
    @Parameters({"Playlist"})
    public void deleteSelectedPlaylist(String Playlist) {
        login("teststudent@teststudent.com", "te$t$tudent");
        selectDeletePlaylist(Playlist);
        String notifyText = "Deleted playlist \"" + Playlist + ".\"";
        System.out.println("Message should be: " + notifyText);
        Assert.assertTrue(deletedPlaylistNotify().contains(notifyText));
    }
}
