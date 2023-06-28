import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void LoginEmptyEmailPasswordTest() {
//     Added ChromeOptions argument below to fix websocket error
        openLoginUrl();
        enterEmail("yuliyakis85@gmail.com");
        enterPassword("te$t$tudent");
        clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), url);

    }
    @Test
    public void LoginValidEmailPasswordTest() {

//      Added ChromeOptions argument below to fix websocket error
        openLoginUrl();
        enterEmail("yuliyakis85@gmail.com");
        enterPassword("te$t$tudent");
        clickSubmit();
        WebElement userAvatar = driver.findElement(By.cssSelector(".avatar"));
        Assert.assertTrue(userAvatar.isDisplayed());

    }

}
