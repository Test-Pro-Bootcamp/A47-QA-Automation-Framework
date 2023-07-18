import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;

public class SongsTests extends BaseTest{
    @Test
    public void playSong() {
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
    public void hoverOverPlayBtn(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        homePage.chooseAllSongsList();
        homePage.hoverOverPlayBtn();

        Assert.assertTrue(homePage.hoverOverPlayBtn().isDisplayed());

    }

    @Test

    public void createNewPlaylist(){

        String confirmationText = "Created playlist";
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongs = new AllSongsPage(driver);

        loginPage.login();
        allSongs.createNewPlaylist();
        allSongs.clickNewPlaylistBtn();
        homePage.editPlaylistName("New Test Playlist");

        Assert.assertTrue(homePage.getNotificationText().contains(confirmationText));


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
        allSongs.contextClickFirstSong();
        allSongs.clickAddToBtn();
        homePage.choosePlaylist();

        Assert.assertTrue((homePage.getNotificationText().contains(newSongAddedNotificationText)));

    }

    @Test
    public void renamePlaylist () {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongs = new AllSongsPage(driver);

        String editedPlaylistNameMessage = "Updated playlist";

        loginPage.login();
        homePage.doubleClickChoosePlaylist();
        homePage.editPlaylistName("Test Playlist");
        homePage.getNotificationText();

        // verifies that the Deletion Message contains the deletion text.
        Assert.assertTrue((homePage.getChangesText().contains(editedPlaylistNameMessage)));
    }
    @Test
    public void deletePlaylist() {

        String deletedPlaylistMessage = "Deleted playlist";
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongs = new AllSongsPage(driver);

        loginPage.login();
        homePage.choosePlaylist();
        homePage.clickDeleteBtn();
        homePage.getDeletionText();

    }


}
