import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BaseTest {
        @Test()
        public void updateProfileName () {

            String profileUpdatedMsg = "Profile updated.";
            LoginPage loginPage = new LoginPage(driver);
            HomePage homePage = new HomePage(driver);
            ProfilePage profilePage = new ProfilePage(driver);

            loginPage.login();
            homePage.clickProfileBtn();
            profilePage.enterCurrentPassword("te$t$tudent");
            profilePage.changeProfileName("Random");
           // profilePage.enterNewEmailAddress("teststudent@teststudent.com");
           // profilePage.changePassword("testProPassword");
            profilePage.clickSave();
           // Assert.assertTrue(homePage.getConfirmationText().contains(profileUpdatedText));
            Assert.assertEquals(homePage.getConfirmationText(), profileUpdatedMsg);
        }

        @Test
        public void updateProfileTheme() {
            LoginPage loginPage = new LoginPage(driver);
            HomePage homePage = new HomePage(driver);
            ProfilePage profilePage = new ProfilePage(driver);
            loginPage.login();
            homePage.clickProfileBtn();
            profilePage.changeBackgroundTheme();
            Assert.assertTrue(profilePage.themeChanged());
        }
    }

