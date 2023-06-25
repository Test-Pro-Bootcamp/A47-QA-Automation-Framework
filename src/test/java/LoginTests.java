import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void LoginValidEmailPasswordTest() {
        openLoginUrl();
        enterEmail("demo@class.com");
        enterPassword("te$t$tudent");
        clickSubmit();
    }


        @Test
        public void LoginEmptyEmailPasswordTest() {
            openLoginUrl();
            enterEmail("demo@class.com");
            enterPassword("te$t$tudent");
            clickSubmit();
            Assert.assertEquals(driver.getCurrentUrl(), url);
        }
}

