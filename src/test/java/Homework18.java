import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework18 extends BaseTest {
    @Test
    public void playSong() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login();
        homePage.playASong();
        Assert.assertTrue(homePage.soundBarIsDisplayed());
        Assert.assertTrue(homePage.pauseBtnIsDisplayed());
    }
}
