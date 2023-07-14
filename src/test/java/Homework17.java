import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework17 extends BaseTest{

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String notificationText = "Added 1 song into";
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login();
        homePage.searchSong("Epic");
        homePage.clickViewAll();
        homePage.selectFirstSongResult();
        homePage.clickAddTo();
        homePage.choosePlaylist();
        Assert.assertTrue(homePage.notificationMessage().contains(notificationText));
    }
}
