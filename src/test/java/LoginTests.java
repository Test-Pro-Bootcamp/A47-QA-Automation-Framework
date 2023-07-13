import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
public class LoginTests extends BaseTest {
    @Test
    public void LoginValidEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
}
