import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void LoginEmptyEmailPasswordTest() {
        openLoginUrl();
        enterEmail("");
        enterPassword("");
        clickSubmit();
        //Confirm we are still on login page
        Assert.assertEquals(driver.getCurrentUrl(), url);
        //Assert.assertTrue(submitLogin.isDisplayed()); Why is submitLogin red?
    }

    @Test
    public void LoginValidEmailValidPasswordTest() {
        openLoginUrl();
        enterEmail("demo@class.com");
        enterPassword("te$t$tudent");
        clickSubmit();
        //Make sure Avatar on homepage is displayed (successful login)
        WebElement avatar = driver.findElement(By.cssSelector(".avatar"));
        Assert.assertTrue(avatar.isDisplayed());
    }


    @Test
    public void LoginNonExistantEmailValidPasswordTest() {
        openLoginUrl();
        enterEmail("nonexistentemail@class.com");
        enterPassword("te$t$tudent");
        clickSubmit();
        //Make sure we are still on login page(not a successful login)
        Assert.assertEquals(driver.getCurrentUrl(), url);

    }

    @Test
    public void LoginValidEmailInvalidPasswordTest() {

        openLoginUrl();
        enterEmail("demo@class.com");
        enterPassword("te$t$tudentttttttt");
        clickSubmit();
        //Make sure we are still on login page(not a successful login)
        Assert.assertEquals(driver.getCurrentUrl(), url);

    }

}


