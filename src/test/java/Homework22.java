import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework22  extends BaseTest{
    @Test

    public void renamePlaylist() {
        String newPLayListName = "Test Pro Edited PlayList";
        String updatedPlayList = "Updated playlist \"Rename PlayList done\"";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.Login();
        homePage.doubleClickPlayList();
        homePage.enterNewPlayListName(newPLayListName);
        Assert.assertEquals(homePage.getRenamePlayListSuccessMsg(), updatedPlayList);


    }



    }