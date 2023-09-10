import org.testng.annotations.Test;

public class Homework23 extends BaseTest{
    @Test(dataProvider = "IncorrectLoginProviders")
    public void LoginTest (String email, String password) throws InterruptedException {
        openLoginUrl();
        LoginPage login= new LoginPage(driver);
        login.provideEmail("demo@class.com");
        login.providePassword("te$t$tudent");
        login.clickSubmit();

    }



}
