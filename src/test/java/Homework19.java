import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class Homework19 extends BaseTest {
    @Test
    @Parameters({"Playlist"})
    public void deletePlaylist(String Playlist) {
        login("teststudent@teststudent.com", "te$t$tudent");
        deleteSelectedPlaylist(Playlist);
        String msgText = "Deleted playlist \"" + Playlist + ".\"";
        System.out.println("Message should be: " + msgText);
        Assert.assertTrue(deletedPlaylistNotify().contains(msgText));
    }
}
