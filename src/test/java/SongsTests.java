import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import pages.BasePage;
import pages.LoginPage;
import pages.HomePage;
import pages.AllSongsPage;

public class SongsTests extends BaseTest{
    @Test
    public void playSong(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongs = new AllSongsPage(driver);

        loginPage.login();
        homePage.chooseAllSongsList();
        allSongs.contextClickFirstSong();
        allSongs.choosePlaySong();

        Assert.assertTrue(allSongs.isSongPlaying());

    }

    @Test
    public void addSongToPlaylist(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongs = new AllSongsPage(driver);

        String newSongAddedNotificationText = "Added 1 song into";
        loginPage.login();

        homePage.searchForSong("Dark Days");
        homePage.clickViewAllBtn();
        homePage.verifySearchUrl();
        allSongs.contextClickFirstSong();
        allSongs.clickAddToBtn();
        homePage.choosePlaylist();

        Assert.assertTrue((getNotificationText().contains(newSongAddedNotificationText)));

    }

    @Test
    public void renamePlaylist () {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongs = new AllSongsPage(driver);

        String editedPlaylistNameMessage = "Updated playlist";

        loginPage.login();
        homePage.choosePlaylist();
        homePage.editPlaylistName();

        // verifies that the Deletion Message contains the deletion text.
        Assert.assertTrue((homePage.getChangesText().contains(editedPlaylistNameMessage)));
    }

}
