import Pages.LoginPage;
import Pages.PlayControlsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
public class PlayControlsTest extends BaseTest {

    @Test (description = "Validate a song is playing")
    public void playSong() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        PlayControlsPage playControlsPage = new PlayControlsPage(driver);
        loginPage.login();
        playControlsPage.hoverOverPlayControl();
        playControlsPage.clickPlayNextSong();
        playControlsPage.clickPlaySong();
        Assert.assertTrue(playControlsPage.pauseButtonDisplay());
        Assert.assertTrue(playControlsPage.soundBarVisualizerDisplay());
        Assert.assertTrue(playControlsPage.progressBarDisplay());
    }
    @Test (description = "Validate Hover Over Play Control is working")
    public void hoverOverPlayCtrl () throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        PlayControlsPage playControlsPage = new PlayControlsPage(driver);
        loginPage.login();
        playControlsPage.hoverOverPlayControl();
        Assert.assertTrue(playControlsPage.isPlayHoveredOver().isDisplayed());
    }
}
