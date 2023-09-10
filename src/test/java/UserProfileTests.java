import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserProfileTests extends BaseTest{
    @Test
    public void changeUsernameTest(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        UserProfilePage userProfilePage = new UserProfilePage(driver);
        String name = userProfilePage.generateUsername();

        loginPage.login("daviyontae.floyd@testpro.io", "te$t$tudent");
        homePage.getUsername().click();
        userProfilePage.enterCurrentPassword("te$t$tudent").enterNewUsername(name).clickSave();

        Assert.assertEquals(homePage.getUsername().getText(), name);
    }
}
