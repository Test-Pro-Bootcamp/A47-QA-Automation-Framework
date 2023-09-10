import Pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;
public class RegistrationTest extends BaseTest{
    @Test(description = "Validate Registration Navigation")
    public void registrationNavigation() {
        String registerUrl = "https://qa.koel.app/registration.php";
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registrationNavigate();
        Assert.assertEquals(driver.getCurrentUrl(), registerUrl);
        Assert.assertTrue(registerPage.registerBtnIsDisplayed());
    }
}
