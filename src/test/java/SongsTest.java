import Pages.HomePage;
import Pages.LoginPage;
import Pages.SongsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
public class SongsTest extends BaseTest{
    @Test(priority = 7, description = "Validate song is playing/ using contextClick")
    public void PlaySong () {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        SongsPage songsPage = new SongsPage(getDriver());

        loginPage.login();
        homePage.chooseAllSongsList();
        songsPage.contextClickFirstSong();
        songsPage.choosePlayOption();
        Assert.assertTrue(songsPage.isSongPlaying());
    }
}
