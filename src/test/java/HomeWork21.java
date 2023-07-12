import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class HomeWork21 extends BaseTest{
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
@Test(priority = 2, description = "Validate playlist is renamed")
@Parameters({"Playlist", "NewPlaylistName"})
    public void renamePlaylist(String Playlist, String NewPlaylistName){
        login("teststudent@teststudent.com", "te$t$tudent");
        doubleClickPlaylist(Playlist);
        enterNewPlaylistName(NewPlaylistName);
        String messageText = "Updated playlist \"" + NewPlaylistName +".\"";
    Assert.assertEquals(doesPlaylistExists(), messageText);
    }
@Test(priority = 3, description = "Validate empty renamed playlist is deleted")
@Parameters({"NewPlaylistName"})
    public void deleteSelectedPlaylist(String NewPlaylistName) {
        login("teststudent@teststudent.com", "te$t$tudent");
        selectDeletePlaylist(NewPlaylistName);
        String notifyText = "Deleted playlist \"" + NewPlaylistName + ".\"";
        System.out.println("Message should be: " + notifyText);
        Assert.assertTrue(deletedPlaylistNotify().contains(notifyText));
    }
}
