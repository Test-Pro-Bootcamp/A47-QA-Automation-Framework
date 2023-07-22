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
        System.out.println(name);
        return name.substring(0, 7);
    }
    public UserProfilePage enterCurrentPasswordText(String password){ findElement(currentPasswordField).sendKeys(password); return this; }
    public UserProfilePage enterUsernameText(String username){ usernameField.sendKeys(Keys.chord(Keys.CONTROL, "A"), Keys.BACK_SPACE); usernameField.sendKeys(username); return this; }
    public UserProfilePage enterEmailText(String email){ emailField.sendKeys(Keys.chord(Keys.CONTROL, "A"), Keys.BACK_SPACE, email); return this; }
    public UserProfilePage enterNewPasswordText(String password){ newPasswordField.sendKeys(password); return this; }
    public void clickSave(){ click(saveBtn); }
}
