import pages.HomePage;
import pages.LoginPage;
import pages.UserProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserProfileTests extends BaseTest{
    @Test (dataProvider = "ValidLoginData", dataProviderClass = BaseTest.class)
    public void changeUsernameTest(String email, String password){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        UserProfilePage userProfilePage = new UserProfilePage(driver);
        String name = userProfilePage.generateUsername();

        loginPage.login(email, password);
        homePage.clickUsername();
        userProfilePage.enterCurrentPassword("te$t$tudent").enterNewUsername(name).clickSave();

        Assert.assertEquals(homePage.getUsername().getText(), name);
    }
}
