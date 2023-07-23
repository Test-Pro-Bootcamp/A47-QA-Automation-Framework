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
        Thread.sleep(2000);
        loginPage.login("angel.ayala@testpro.io", "school!sc0");
        Thread.sleep(2000);
        homePage.createPlaylist().newPlaylistSelection().enterNewPlaylistName("work1");
        Thread.sleep(3000);
        Assert.assertTrue(homePage.verificationMessage().contains("Created"));
    }
    @Test(priority = 4)
    public void deleteActivePlaylist() throws InterruptedException{
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        Thread.sleep(2000);
        loginPage.login("angel.ayala@testpro.io", "school!sc0");
        Thread.sleep(2000);
        homePage.clickFirstPlaylist().clickDeleteButton();
        if(homePage.areYouSureBox().isDisplayed()){
            homePage.areYouSureBox().click();}
        Thread.sleep(3000);
        Assert.assertTrue(homePage.verificationMessage().contains("Deleted"));
    }
    @Test(priority = 3)
    public void addSongToPlaylist() throws InterruptedException{
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        SongsPage songsPage = new SongsPage(getDriver());
        Thread.sleep(2000);
        loginPage.login("angel.ayala@testpro.io","school!sc0");
        Thread.sleep(2000);
        songsPage.goToAllSongs().clickFirstSong().clickAddButton().addToPlaylistSelection();
        Thread.sleep(3000);
        Assert.assertTrue(homePage.verificationMessage().contains("Added"));

    }
    @Test(priority = 1)
    public void renamePlaylist()throws InterruptedException{
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage =new HomePage(getDriver());

        Thread.sleep(3000);
        loginPage.login("angel.ayala@testpro.io", "school!sc0");
        Thread.sleep(2000);
        homePage.contextPlaylist().selectEdit().editName("z");
        Thread.sleep(3000);
        Assert.assertTrue(homePage.verificationMessage().contains("Updated"));
    }
}
