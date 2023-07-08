import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class Homework23 extends BaseTest{

    String message = "Updated playlist";
    public void renamePlaylist(){
        LoginPage loginPage = new LoginPage(driver);
          HomePage homePage = new HomePage(driver);

        loginPage.enterEmail("angel.ayala@testpro.io")
                 .enterPassword("school!sc0")
                 .clickSubmit();
         homePage.contextClickFirstPlaylist()
                 .clickEdit()
                 .renamePlaylist("testProTest");

        Assert.assertTrue(homePage.verificationMessage().contains(message));
    }
}
