import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import pages.*;
import pages.LoginPage;

public class SongsTests extends BaseTest{
    @Test
    private void playSong(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongs = new AllSongsPage(driver);

        loginPage.login();
        homePage.chooseAllSongsList();
        allSongs.contextClickFirstSong();
        allSongs.choosePlayOption();

        Assert.assertTrue(allSongs.isSongPlaying());

    }

    @Test
    public void addSongToPlaylist(String email, String password) throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();

        //search for song
        searchForSong("Dark Days");
        //click View All Btn
        clickViewAllBtn();
        // verify on search results page
        verifySearchUrl();
        //select the first song returned in the search
        selectFirstSongResult();
        //click Add To Btn
        clickAddToBtn();
        //choose Playlist to add the song to
        choosePlaylist();
        //checking for success message notification
        Assert.assertTrue((getNotificationText().contains(newSongAddedNotificationText)));


    }

}
