import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

public class ProfileTests extends BaseTest {

    @Test
    public void updateProfileName (){
        String profileChangesConfirmedText = "Profile Updated";
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        loginPage.login();
        profilePage.clickProfileBtn();
        profilePage.enterCurrentPassword("te$t$tudent");
        profilePage.changeProfileName("Matt");
        profilePage.enterEmailAddress("mattpierce.testpro.io");
        profilePage.changePassword("test password");
        profilePage.clickSave();

        Assert.assertTrue((homePage.getNotificationText().contains(profileChangesConfirmedText)));
    }

    @Test
    public void updateProfileTheme() {
        String profileChangesConfirmedText = "Profile Updated";
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        loginPage.login();
        profilePage.clickProfileBtn();
        profilePage.changeBackgroundTheme();
        profilePage.clickSave();

        Assert.assertTrue((homePage.getNotificationText().contains(profileChangesConfirmedText)));

    }
}
