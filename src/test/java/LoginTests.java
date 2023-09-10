
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTests extends BaseTest {
    @Test
    public void LoginEmptyEmailPasswordTest() {

       // openLoginUrl();
        enterEmail("andrea.guevara@testpro.io");
        enterPassword("te$t$tudent");
        clickSubmit();
    }
}
