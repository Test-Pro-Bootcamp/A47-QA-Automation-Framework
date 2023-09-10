package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.UUID;

public class UserProfilePage extends BasePage{
    public UserProfilePage(WebDriver givenDriver){ super(givenDriver); }

    By currentPasswordField = By.cssSelector("#inputProfileCurrentPassword");
    By usernameField = By.cssSelector("#inputProfileName");
    By emailField = By.cssSelector("#inputProfileEmail");
    By newPasswordField = By.cssSelector("#inputProfileNewPassword");
    By saveBtn = By.cssSelector(".btn-submit");

    public String generateUsername(){
        String name = UUID.randomUUID().toString().replace("-", "");
        return name.substring(0, 7);
    }
    public UserProfilePage enterCurrentPassword(String password){ findElement(currentPasswordField).sendKeys(password); return this; }
    public UserProfilePage enterNewUsername(String username){ findElement(usernameField).sendKeys(Keys.chord(Keys.CONTROL, "A"), Keys.BACK_SPACE, username); return this; }
    public UserProfilePage enterNewEmail(String email){ findElement(emailField).sendKeys(Keys.chord(Keys.CONTROL, "A"), Keys.BACK_SPACE, email); return this; }
    public UserProfilePage enterNewPassword(String password){ findElement(newPasswordField).sendKeys(password); return this; }
    public  UserProfilePage clickSave(){ click(saveBtn); return this; }
}
