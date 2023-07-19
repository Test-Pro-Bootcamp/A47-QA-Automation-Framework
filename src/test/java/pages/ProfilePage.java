package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {

    public ProfilePage (WebDriver givenDriver) {

        super(givenDriver);
    }

    @FindBy (xpath = "//input[@id='inputProfileCurrentPassword']")
    private WebElement currentPasswordField;

    @FindBy (xpath = "//input[@id='inputProfileName']")
    private WebElement profileNameField;

    @FindBy (xpath = "//input[@id='inputProfileEmail']")
    private WebElement emailAddressField;

    @FindBy (xpath = "//input[@id='inputProfileNewPassword']")
    private WebElement newPasswordField;

    @FindBy (xpath = "//button[@class='btn-submit']")
    private WebElement saveBtn;


    @FindBy (xpath = "//div[@data-testid='theme-card-violet']")
    private WebElement changeTheme;

    public ProfilePage enterCurrentPassword(String currentPassword) {
        currentPasswordField.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        currentPasswordField.sendKeys(currentPassword);
        return this;
    }

    public ProfilePage changeProfileName(String name) {
        profileNameField.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        profileNameField.sendKeys(name);
        return this;
    }

    public ProfilePage enterEmailAddress(String email) {
        emailAddressField.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        emailAddressField.sendKeys(email);
        return this;
    }

    public ProfilePage changePassword(String newPassword) {
        newPasswordField.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        newPasswordField.sendKeys(newPassword);
        return this;
    }

    public ProfilePage clickSave() {
        saveBtn.click();
        return this;
    }

    public ProfilePage changeBackgroundTheme() {
        changeTheme.click();
        return this;
    }
}
