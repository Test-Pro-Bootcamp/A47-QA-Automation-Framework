import Pages.AllSongsPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AllSongsTests extends BaseTest{

    @Test
    public void playSong() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongs = new AllSongsPage(driver);

        loginPage.provideEmail("trianasahlin@gmail.com").providePassword("te$t$tudent").clickSubmit();

        homePage.chooseAllSongList();

        allSongs.contextClickFirstSong().choosePlayOption();

        Assert.assertTrue(allSongs.isSongPlaying());


    }



}
