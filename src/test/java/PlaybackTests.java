import POM.Pages.HomePage;
import POM.Pages.LoginPage;
import POM.Pages.SongsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaybackTests extends BaseTest{

    @Test
    public void playSongDoubleClick() throws InterruptedException{
        LoginPage loginPage = new LoginPage(getDriver());
        SongsPage songsPage = new SongsPage(getDriver());

        loginPage.login("angel.ayala@testpro.io", "school!sc0");
        Thread.sleep(2000);
        songsPage.goToAllSongs();
        Thread.sleep(2000);
        songsPage.doubleClickSong();
        Thread.sleep(2000);
        Assert.assertTrue(songsPage.songIsPlaying().isDisplayed());
    }
}
