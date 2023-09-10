import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

public class ProfileTests extends BaseTest {

    @Test
    public void updateProfileName ()  {
        String profileChangesConfirmedText = "Profile updated";
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        loginPage.login();
        homePage.clickProfileBtn();
        profilePage.enterCurrentPassword("te$t$tudent1");
        profilePage.changeProfileName("Matthew");
        profilePage.enterEmailAddress("matt.pierce@testpro.io");
        profilePage.clickSave();
        Assert.assertTrue(homePage.getConfirmationText().contains(profileChangesConfirmedText));
    }

    @Test
    public void updateProfileTheme() {
        String profileChangesConfirmedText = "Profile updated";
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        loginPage.login();
        homePage.clickProfileBtn();
        profilePage.enterCurrentPassword("te$t$tudent1");
        profilePage.changeBackgroundTheme();
        profilePage.clickSave();

       Assert.assertTrue((homePage.getConfirmationText().contains(profileChangesConfirmedText)));

    }
}
