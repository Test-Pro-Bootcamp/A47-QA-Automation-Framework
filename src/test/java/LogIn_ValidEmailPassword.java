import org.testng.Assert;
import org.testng.annotations.Test;

public class LogIn_ValidEmailPassword extends BaseTest {
    @Test
    public void LogIn_ValidEmailPassword() {

        openLoginUrl();

        enterEmail("aimee.woodside@testpro.io");

        enterPassword("te$t$tudent13");

        clickLogInbutton();

        displayAvatarIcon();
    }
}
