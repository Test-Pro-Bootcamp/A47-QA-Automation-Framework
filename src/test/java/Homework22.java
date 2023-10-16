import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;


 // homework 22 okay :)
public class Homework22  extends BaseTest{
    @Test

    public void renamePlaylist() {
        String newPlaylistName = "Test Pro Edited PlayList+";
        String updatedPlaylistMsg = "Updated playlist \"Test Pro Edited PlayList+.\"";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.Login();
        homePage.doubleClickPlayList();
        homePage.enterNewPlayListName(newPlaylistName);
        Assert.assertEquals(homePage.getRenamePlayListSuccessMsg(), updatedPlaylistMsg);


    }


}

