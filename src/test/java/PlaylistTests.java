import POM.Pages.HomePage;
import POM.Pages.LoginPage;
import POM.Pages.SongsPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaylistTests extends BaseTest{

    @Test(priority = 1)
    public void createNewPlaylist() throws InterruptedException{
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login("angel.ayala@testpro.io", "school!sc0");
        homePage.createPlaylist().newPlaylistSelection().enterNewPlaylistName("work");
        Thread.sleep(2000);
        Assert.assertTrue(homePage.verificationMessage().contains("Created"));
    }
    @Test(priority = 4)
    public void deleteActivePlaylist() throws InterruptedException{
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login("angel.ayala@testpro.io", "school!sc0");
        homePage.clickFirstPlaylist().clickDeleteButton();
        Thread.sleep(2000);
        Assert.assertTrue(homePage.verificationMessage().contains("Deleted"));
    }
    @Test(priority = 2)
    public void addSongToPlaylist() throws InterruptedException{
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        SongsPage songsPage = new SongsPage(getDriver());

        loginPage.login("angel.ayala@testpro.io","school!sc0");
        songsPage.goToAllSongs().clickFirstSong().clickAddButton().addToPlaylistSelection();
        Thread.sleep(2000);
        Assert.assertTrue(homePage.verificationMessage().contains("Added"));

    }
    @Test(priority = 3)
    public void renamePlaylist()throws InterruptedException{
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage =new HomePage(getDriver());

        loginPage.login("angel.ayala@testpro.io", "school!sc0");
        homePage.contextPlaylist().selectEdit().editName("editName1");
        Thread.sleep(2000);
        Assert.assertTrue(homePage.verificationMessage().contains("Updated"));
    }
}
