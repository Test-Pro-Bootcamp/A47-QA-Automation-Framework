import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class SongTests extends  BaseTest {
    @Test
    public void PlaySong(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        AllSongsPage allSongs = new AllSongsPage(getDriver());

        loginPage.provideEmail("victor.flores@testpro.io");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmit();

        homePage.chooseAllSongsList();
        allSongs.contextClickFirstSong();
        allSongs.choosePlayOption();
        Assert.assertTrue(allSongs.isSongPlaying());

    }

}
