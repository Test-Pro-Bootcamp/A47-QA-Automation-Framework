import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test (dataProvider = "ValidLoginData", dataProviderClass = BaseTest.class)
    public void successfulLoginTest(String email, String password) {

//        Enter email into the email field
        enterEmailField(email);

//        Enter password into the password field
        enterPasswordField(password);

//        Click the Login button
        clickSubmit();

//        Verify user is logged in by avatar display
        WebElement avatar = driver.findElement(By.cssSelector(".avatar"));
        Assert.assertTrue(avatar.isDisplayed());
    }

    @Test (dataProvider = "InvalidLoginData", dataProviderClass = BaseTest.class)
    public void invalidLoginTest(String email, String password) {

//        Enter email into the email field
        enterEmailField(email);

//        Enter password into the password field
        enterPasswordField(password);

//        Click the Login button
        clickSubmit();

//        Check that user is still on the Login page and the Login button is still displayed
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test (enabled = false)
    public void emptyPasswordFieldTest() {

//        Enter email into the email field
        enterEmailField("daviyontae.floyd@testpro.io");

//        Enter password into the password field
        enterPasswordField(" ");

//        Click the Login button
        clickSubmit();

//        Check that user is still on the Login page and the Login button is still displayed
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

}
