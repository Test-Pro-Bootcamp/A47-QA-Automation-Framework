import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserProfileTests extends BaseTest{
    @Test
    public void changeUsernameTest() throws InterruptedException{
                            /*LOGIN*/
        openLoginLink();

//        Enter email into the email field
        enterEmailField("daviyontae.floyd@testpro.io");

//        Enter password into the password field
        enterPasswordField("te$t$tudent");

//        Click the Login button
        clickSubmit();
        Thread.sleep(5000);

                            /*REDIRECT TO USER PROFILE PAGE & EDIT*/
        clickUsername();

//        Enter current password
        currentPassword("te$t$tudent");

//        Enter a new username
        String name = generateUsername();
        changeUsername(name);

        clickSave();
        Thread.sleep(5000);

//        Verify profile update
        WebElement username = driver.findElement(By.cssSelector("span.name"));
        Assert.assertEquals(username.getText(), name);
    }
}
