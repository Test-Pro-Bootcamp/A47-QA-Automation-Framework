import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;

import java.util.Collection;
import java.util.List;

public class SongsTests extends BaseTest{

    @Test
    public void playSong(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongs = new AllSongsPage(driver);
        loginPage.logIn();
        homePage.chooseAllSongsList();
        allSongs.contextClickFirstSong();
        allSongs.choosePlayOption();
        Assert.assertTrue(allSongs.isSongPlaying());
    }

    @Test
    public void hoverOverPlayButton(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.logIn();
        homePage.chooseAllSongsList();
        homePage.hoverPlay();
        Assert.assertTrue(homePage.hoverPlay().isDisplayed());
    }
    @Test
    public void countSongsInPlaylist(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.logIn();
        homePage.choosePlaylistByName("Happy Holidays");
        homePage.displayAllSongs();
        Assert.assertTrue(homePage.getPlaylistDetails().contains(String.valueOf(homePage.countSongs())));

    }


}
