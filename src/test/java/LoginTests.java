import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void LoginValidEmailPasswordTest() throws InterruptedException {
        openLoginUrl();
        enterEmail("demo@class.com");
        enterPassword("te$t$tudent");
        clickSubmit();

Thread.sleep(5000);
    }


        @Test
        public void LoginEmptyEmailPasswordTest() throws InterruptedException{
            openLoginUrl();
            enterEmail("demo@class.com");
            enterPassword("te$t$tudent");
            clickSubmit();
            Assert.assertEquals(driver.getCurrentUrl(), url);
            Thread.sleep(5000);

        }
}

