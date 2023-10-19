
import org.testng.annotations.Test;
import pagefactory.HomePage;
import pagefactory.LoginPage;



public class LoginTests extends BaseTest {
    @Test
    public void LoginEmptyEmailPasswordTest() {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);


        loginPage.provideEmail("andrea.guevara@testpro.io")
                 .providePassword("te$t$tudent")
                 .clickSubmit();


    }

}
