import org.testng.Assert;
import org.testng.annotations.Test;

public class HOMEWORK22 extends BaseTest{

    @Test
    public void renamePlaylist(){
        String playlistName = "Hubba Bubba Jr";

        LOGIN LOGIN = new LOGIN(driver);
        HOME HOME = new HOME(driver);

        LOGIN.login();
        HOME.doubleClickPlaylist();
        HOME.enterNewPlaylistName(playlistName);
        Assert.assertTrue(HOME.doesPlaylistExist(playlistName));
    }
}
