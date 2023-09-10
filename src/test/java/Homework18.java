import Pages.AllSongsPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{

    @Test
    public void playSong() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        AllSongsPage allSongs = new AllSongsPage(getDriver());

        loginPage.provideEmail("trianasahlin@gmail.com").providePassword("te$t$tudent").clickSubmit();

        homePage.chooseAllSongList();

        allSongs.contextClickFirstSong().choosePlayOption();

        Assert.assertTrue(allSongs.isSongPlaying());


    }



}
