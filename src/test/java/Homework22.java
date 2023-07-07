import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework22 extends BaseTest {
    String message = "Updated playlist";

    @Test
    public void renamePlaylist(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        homePage.avatar();
        homePage.selectPlaylist();
        homePage.enterName("anyName1");

        Assert.assertTrue(homePage.verificationMessage().contains(message));
    }
}
