import POM.Pages.HomePage;
import POM.Pages.LoginPage;
import POM.Pages.SongsPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaylistTests extends BaseTest{

    @Test(priority = 2)
    public void createNewPlaylist() throws InterruptedException{
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.login("angel.ayala@testpro.io", "school!sc0");
        Thread.sleep(2000);
        homePage.createPlaylist().newPlaylistSelection().enterNewPlaylistName("work123");
        Assert.assertTrue(homePage.verificationMessage().contains("Created"));
    }
    @Test(priority = 4)
    public void deleteActivePlaylist() throws InterruptedException{
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());


        loginPage.login("angel.ayala@testpro.io", "school!sc0");
        Thread.sleep(2000);
        homePage.clickFirstPlaylist().clickDeleteButton();
        Thread.sleep(2000);
        if(homePage.areYouSureBox().isDisplayed()){
            homePage.areYouSureBox().click();}
        Assert.assertTrue(homePage.verificationMessage().contains("Deleted"));
    }
    @Test(priority = 3)
    public void addSongToPlaylist() throws InterruptedException{
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        SongsPage songsPage = new SongsPage(getDriver());

        loginPage.login("angel.ayala@testpro.io","school!sc0");
        Thread.sleep(2000);
        songsPage.goToAllSongs().clickFirstSong().clickAddButton().addToPlaylistSelection();
        Assert.assertTrue(homePage.verificationMessage().contains("Added"));

    }
    @Test(priority = 1)
    public void renamePlaylist()throws InterruptedException{
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage =new HomePage(getDriver());


        loginPage.login("angel.ayala@testpro.io", "school!sc0");
        Thread.sleep(2000);
        homePage.contextPlaylist().selectEdit().editName("z");

        Assert.assertTrue(homePage.verificationMessage().contains("Updated"));
    }
}
