import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.HomePage;
import pagefactory.LoginPage;

public class Homework23  extends BaseTest{
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
