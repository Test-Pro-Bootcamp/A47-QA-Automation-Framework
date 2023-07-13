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
    private void addSongToPlaylist(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongs = new AllSongsPage(driver);

        String newSongAddedNotificationText = "Added 1 song into"
        loginPage.login();
        homePage.searchForSong("Dark Days");
        homePage.clickViewAllBtn();
        homePage.verifySearchUrl();
        allSongs.selectFirstSongResult();
        allSongs.clickAddToBtn();
        homePage.choosePlaylist();

        Assert.assertTrue((getNotificationText().contains(newSongAddedNotificationText)));
        
    }

    @Test
    private void renamePlaylist () {

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
