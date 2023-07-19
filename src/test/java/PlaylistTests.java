import pages.HomePage;
import pages.LoginPage;
import pages.PlaylistPage;
import pages.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaylistTests extends BaseTest{
    @Test (dataProvider = "ValidLoginData", dataProviderClass = BaseTest.class)
    public void changePlaylistNameTest(String email, String password){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        PlaylistPage playlistPage = new PlaylistPage(getDriver());

        loginPage.login(email, password);
        homePage.renamePlaylist(3, "New Playlist");
        Assert.assertTrue(playlistPage.getSuccessMsg().isDisplayed());
    }

    @Test (dataProvider = "ValidLoginData", dataProviderClass = BaseTest.class)
    public void addSongNewPlaylistTest(String email, String password){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        SearchResultsPage searchResultsPage = new SearchResultsPage(getDriver());
        PlaylistPage playlistPage = new PlaylistPage(getDriver());

        loginPage.login(email, password);
        homePage.searchSong("Birthday");
        searchResultsPage.clickViewAll().selectSong(1).addToNewPlaylist("Newest Playlist");
        Assert.assertTrue(playlistPage.getSuccessMsg().isDisplayed());
    }

    @Test (dataProvider = "ValidLoginData", dataProviderClass = BaseTest.class)
    public void deletePlaylistTest(String email, String password){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        PlaylistPage playlistPage = new PlaylistPage(getDriver());

        loginPage.login(email, password);
        homePage.selectPlaylist(3);
        playlistPage.deletePlaylist();
        Assert.assertTrue(homePage.getSuccessMsg().isDisplayed());
    }
}

