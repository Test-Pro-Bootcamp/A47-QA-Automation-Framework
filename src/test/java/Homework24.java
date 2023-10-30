import org.testng.annotations.Test;
import org.testng.Assert;
import pagefactory.HomePage;
import pagefactory.LoginPage;
import java.util.Random;



public class Homework24 extends  BaseTest{
    @Test

    public void renamePlaylist() throws InterruptedException{
        Random rand = new Random();

    String newPlaylistName = "Test Pro Edited PlayList+" + rand.nextInt(100);
        String updatedPlaylistMsg = "Updated playlist \"Test Pro Edited PlayList+.\"";

    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);

        loginPage.Login();
        homePage.doubleClickPlayList();
        homePage.enterNewPlayListName(newPlaylistName);
        Assert.assertEquals(homePage.getRenamePlayListSuccessMsg(), updatedPlaylistMsg);


}
}

