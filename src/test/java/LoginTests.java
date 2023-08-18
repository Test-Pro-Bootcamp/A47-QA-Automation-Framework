import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test
    public void loginValidEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.logIn();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

    }
    @Test (dataProvider = "IncorrectLoginProviders")
    public void invalidLoginValidEmailPasswordTest(String email, String password) {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.IncorrectLogIn(email, password);
        Assert.assertEquals(getDriver().getCurrentUrl(),url);

    }

}
