import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework22 extends BaseTest{
    @Test
    public void renamePlayList()
    {
        String playlistName="Test pro Playlist";
        LoginPage loginPage=new LoginPage(driver);
        HomePage homePage=new HomePage(driver);
        loginPage.login();
        homePage.doubleClickPlaylist();
        homePage.enterNewPlaylistName(playlistName);
        Assert.assertTrue(homePage.doesPlaylistExist(playlistName));
    }





}
