import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;

public class SongsTests extends BaseTest{
    @Test
    public void playSong() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        AllSongsPage allSongs = new AllSongsPage(getDriver());

        loginPage.login();
        allSongs.waitForOverlay(homePage.overlayLocator);
        homePage.chooseAllSongsList();
        allSongs.doubleClick(allSongs.firstSong);

        Assert.assertTrue(allSongs.isSongPlaying());
    }
}
