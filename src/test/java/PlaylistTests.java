import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;

public class PlaylistTests extends BaseTest{

    @Test

    public void createNewPlaylist()  {

        String confirmationText = "Created playlist";
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongs = new AllSongsPage(driver);

        loginPage.login();
        allSongs.createNewPlaylist();
        allSongs.clickNewPlaylistBtn();
        homePage.editPlaylistName("New Test Playlist");

        Assert.assertTrue(homePage.getConfirmationText().contains((confirmationText)));
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

        // verifies that the Deletion Message contains the deletion text.
        Assert.assertTrue((homePage.getConfirmationText().contains(editedPlaylistNameMessage)));
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
        allSongs.selectFirstSongResult();
        allSongs.clickAddToBtn();
        homePage.choosePlaylist();

        //delete song from the playlist or add a different song for every test execution
        Assert.assertTrue((homePage.getConfirmationText().contains(newSongAddedNotificationText)));
    }

    @Test
    public void deletePlaylist() {

        String deletedPlaylistMessage = "Deleted playlist";
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongs = new AllSongsPage(driver);

        loginPage.login();
        homePage.choosePlaylistFromPlaylistPane();
        homePage.clickDeleteBtn();

        Assert.assertTrue(homePage.getConfirmationText().contains(deletedPlaylistMessage));

    }


}
