import POM.Pages.HomePage;
import POM.Pages.LoginPage;
import POM.Pages.SongsPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.sql.DriverManager.getDriver;

public class PlaylistTests extends BaseTest {

    @FindBy(css = "div.show.success")
    private WebElement messageBox;
    @Test(priority = 1)
    public void createNewPlaylist(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login("angel.ayala@testpro.io", "school!sc0");
        homePage.createPlaylist().newPlaylistSelection().enterNewPlaylistName("work123");
        Assert.assertTrue(homePage.verificationMessage().contains("Created"));
    }

    @Test(priority = 4)
    public void deleteActivePlaylist() throws Exception{
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login("angel.ayala@testpro.io", "school!sc0");
        homePage.clickFirstPlaylist();
        homePage.clickDeleteButton();
        try {
             if(homePage.areYouSureBox().isDisplayed()) {
                 homePage.areYouSureBox().click();
                 Assert.assertTrue(homePage.verificationMessage().contains("Deleted"));
             }
        }
        catch (Exception e){}
        }
        @Test(priority = 2)
        public void addSongToPlaylist(){
            LoginPage loginPage = new LoginPage(getDriver());
            HomePage homePage = new HomePage(getDriver());
            SongsPage songsPage = new SongsPage(getDriver());

            loginPage.login("angel.ayala@testpro.io", "school!sc0");
            songsPage.goToAllSongs().clickFirstSong().clickAddButton().addToPlaylistSelection();
            Assert.assertTrue(homePage.verificationMessage().contains("Added"));

        }
        @Test(priority = 3)
        public void renamePlaylist (){
            LoginPage loginPage = new LoginPage(getDriver());
            HomePage homePage = new HomePage(getDriver());

            loginPage.login("angel.ayala@testpro.io", "school!sc0");
            homePage.contextPlaylist().selectEdit().editName("z");
            Assert.assertTrue(homePage.verificationMessage().contains("Updated"));
        }
}
