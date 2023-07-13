import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class SongsTests extends BaseTest{
    @Test
    private void playSong(){

        LoginPage.login();
        HomePage.chooseAllSongsList();
        HomePage.contextClickFirstSong();
        HomePage.choosePlayOption();

        Assert.assertTrue(isSongPlaying());

    }

}
