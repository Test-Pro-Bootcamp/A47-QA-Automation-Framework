import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void successfulLoginTest() {

        openLoginLink();

//        Enter email into the email field
        enterEmailField("daviyontae.floyd@testpro.io");

//        Enter password into the password field
        enterPasswordField("te$t$tudent");

//        Click the Login button
        clickSubmit();

//        Verify user is logged in by avatar display
        WebElement avatar = driver.findElement(By.cssSelector(".avatar"));
        Assert.assertTrue(avatar.isDisplayed());
    }

    @Test
    public void incorrectLoginTest() {

        openLoginLink();

//        Enter email into the email field
        enterEmailField("invalid.email@testpro.io");

//        Enter password into the password field
        enterPasswordField("te$t$tudent");

//        Click the Login button
        clickSubmit();

//        Check that user is still on the Login page and the Login button is still displayed
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void emptyPasswordFieldTest() {

        openLoginLink();

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
