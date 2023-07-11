package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.UUID;

public class UserProfilePage extends BasePage{
    public UserProfilePage(WebDriver givenDriver){ super(givenDriver); }
    @FindBy(css = "#inputProfileCurrentPassword")
    private WebElement currentPasswordField;
    @FindBy(css = "#inputProfileName")
    private WebElement usernameField;
    @FindBy(css = "#inputProfileEmail")
    private WebElement emailField;
    @FindBy(css = "#inputProfileNewPassword")
    private WebElement newPasswordField;
    @FindBy(css = ".btn-submit")
    private WebElement saveBtn;

    public String generateUsername(){
        String name = UUID.randomUUID().toString().replace("-", "");
        return name.substring(0, 7);
    }
    public UserProfilePage enterCurrentPassword(String password){ findElement(currentPasswordField).sendKeys(password); return this; }
    public UserProfilePage enterNewUsername(String username){ usernameField.sendKeys(Keys.chord(Keys.CONTROL, "A"), Keys.BACK_SPACE, username); return this; }
    public UserProfilePage enterNewEmail(String email){ emailField.sendKeys(Keys.chord(Keys.CONTROL, "A"), Keys.BACK_SPACE, email); return this; }
    public UserProfilePage enterNewPassword(String password){ newPasswordField.sendKeys(password); return this; }
    public void clickSave(){ click(saveBtn); }
}
