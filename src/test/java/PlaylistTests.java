import POM.Pages.HomePage;
import POM.Pages.LoginPage;
import POM.Pages.SongsPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;


public class PlaylistTests extends BaseTest {

    @Test(priority = 1)
    public void createNewPlaylist(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login("angel.ayala@testpro.io", "school!sc0");
        homePage.createPlaylist().newPlaylistSelection().enterNewPlaylistName("work123");
        Assert.assertTrue(homePage.verificationMessage().contains("Created"));
    }
    @Test(priority = 4)
    public void deleteActivePlaylist(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
            try{
           loginPage.login("angel.ayala@testpro.io", "school!sc0");
        List<WebElement> listItems = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#playlists > ul > li")));
        Thread.sleep(3000);
        System.out.println(listItems.size());
//           homePage.selectRandomPlaylistHomePg();}
//            catch (IndexOutOfBoundsException e){}
//            finally {homePage.clickDeleteButton();}
//            try{
//           if (homePage.displayMessage().isDisplayed()) {
//               Assert.assertTrue(homePage.verificationMessage().contains("Deleted"));
//           }
           }
       catch (Exception e){
            homePage.areYouSureBox().click();
            Assert.assertTrue(homePage.verificationMessage().contains("Deleted"));
        }
        }
        @Test(priority = 2)
        public void addSongToPlaylist() throws ElementNotInteractableException {
            LoginPage loginPage = new LoginPage(getDriver());
            HomePage homePage = new HomePage(getDriver());
            SongsPage songsPage = new SongsPage(getDriver());
            try{
            loginPage.login("angel.ayala@testpro.io", "school!sc0");
            songsPage.goToAllSongs().selectRandomSong().clickAddButton();
            songsPage.selectRandomPlaylistDrpDwn();}
            catch (ElementNotInteractableException e){
            Assert.assertTrue(homePage.verificationMessage().contains("Added"));}
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
