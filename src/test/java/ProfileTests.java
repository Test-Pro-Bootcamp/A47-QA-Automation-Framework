import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class ProfileTests extends BasePage{

    @Test
    public void deletePlaylist (){

        String deletedPlaylistMessage = "Deleted playlist";
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongs = new AllSongsPage(driver);

        loginPage.login();
        //choose playlist
        homePage.openPlaylist();
        // click delete that playlist
        allSongs.clickDeleteBtn();

        //gets deletion text
        homePage.getDeletionText();

        // verifies that the Deletion Message contains the deletion text.
        Assert.assertTrue((getDeletionText().contains(deletedPlaylistMessage)));
    }



}
