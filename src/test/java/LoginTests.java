import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void LoginValidEmailPasswordTest() {

        openLoginUrl();

        enterEmail();

        enterPassword();

        clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), url);

    }


}
