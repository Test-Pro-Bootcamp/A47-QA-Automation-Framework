import Pages.AllSongsPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaySongTests extends BaseTest{
    @Test
    public void playFromAllSongsTest(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);

        loginPage.login("daviyontae.floyd@testpro.io", "te$t$tudent");
        homePage.clickAllSongs();
        allSongsPage.contextClickSong();
        allSongsPage.clickPlayback();

        Assert.assertTrue(homePage.moveToPauseBtn().isDisplayed());
    }
}
