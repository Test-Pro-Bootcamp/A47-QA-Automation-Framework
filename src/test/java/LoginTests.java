import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public static void LoginValidEmailPasswordTest() {


        openLoginUrl();

        enterEmail("dulcealergica@yahoo.com");


        enterPassword("te$t$tudent");

        clickSubmit();

        WebElement avatar = driver.findElement(By.cssSelector(".avatar"));
        Assert.assertTrue(avatar.isDisplayed());

    }

}



