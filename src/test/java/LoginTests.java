import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
public class LoginTests extends BaseTest {
    @Test
    public void LoginValidEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login();
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }
}
