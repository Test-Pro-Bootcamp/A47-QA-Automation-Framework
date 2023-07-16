import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void LoginInvalidEmailPasswordTest() {

         provideEmail("invalid@class.com");
         providePassword("te$t$tudent");
         clickSubmit();
         Assert.assertEquals(driver.getCurrentUrl(),url);
    }

    @Test
    public void loginValidEmailPasswordTest() {
        provideEmail("erika.olsen@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        WebElement avatarIcon = driver.findElement(By.cssSelector("[alt='Avatar of student']"));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }
}
