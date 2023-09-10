import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void LoginEmptyEmailPasswordTest() {



        // Open the URL for the web page on the Chrome Browser
        openLoginUrl();

        // Put the email field inside the web page
        enterEmail("andrea.guevara@testpro.io");

        // Put the password field inside the web page
        enterPassword("te$t$tudent");

        //click on the submit button
        clickSubmit();


        // check if the user avatar is displaying
        WebElement avatar = driver.findElement(By.cssSelector(".avatar"));
        Assert.assertTrue(avatar.isDisplayed());

    }

}
