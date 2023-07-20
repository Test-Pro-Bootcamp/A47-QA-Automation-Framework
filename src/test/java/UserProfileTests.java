import pages.HomePage;
import pages.LoginPage;
import pages.UserProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserProfileTests extends BaseTest{
    @Test (dataProvider = "ValidLoginData", dataProviderClass = BaseTest.class)
    public void changeUsernameTest(String email, String password){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        UserProfilePage userProfilePage = new UserProfilePage(getDriver());
        String name = userProfilePage.generateUsername();

        loginPage.login(email, password);
        homePage.clickUsername();
        userProfilePage.enterCurrentPassword("te$t$tudent").enterNewUsername(name).clickSave();

        Assert.assertEquals(homePage.getUsername().getText(), name);
    }
}
