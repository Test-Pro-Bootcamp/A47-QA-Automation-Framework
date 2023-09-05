import Pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;
public class RegistrationTest extends BaseTest{
    @Test(description = "Validate Registration Navigation")
    public void registrationNavigation() {
        String registerUrl = "https://qa.koel.app/registration";
        RegisterPage registerPage = new RegisterPage(getDriver());
        registerPage.registrationNavigate();
        Assert.assertEquals(getDriver().getCurrentUrl(), registerUrl);
        Assert.assertTrue(registerPage.registerBtnIsDisplayed());
    }
}
