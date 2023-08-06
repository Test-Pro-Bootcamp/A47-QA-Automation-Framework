package Pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.UUID;

public class ProfilePage extends BasePage{
    public ProfilePage(WebDriver givenDriver) { super(givenDriver);}

        @FindBy(xpath = "//input[@id='inputProfileCurrentPassword']")
        private WebElement currentPasswordField;

        @FindBy (xpath = "//input[@id='inputProfileName']")
        private WebElement profileNameField;

        @FindBy (xpath = "//input[@id='inputProfileEmail']")
        private WebElement emailAddressField;

        @FindBy (xpath = "//input[@id='inputProfileNewPassword']")
        private WebElement newPasswordField;

        @FindBy (xpath = "//button[@class='btn-submit']")
        private WebElement saveBtn;

        @FindBy (xpath = "//div[@data-testid='theme-card-cat']")
        private WebElement changeTheme;

    @FindBy (xpath = "//html[@data-theme='cat']")
    private WebElement changeThemeConfirmation;

        public ProfilePage enterCurrentPassword(String currentPassword) {
            findElementClickable(currentPasswordField).sendKeys(currentPassword);
            return this;
        }

        public ProfilePage changeProfileName(String name) {
            findElementVisible(profileNameField).sendKeys(Keys.chord(Keys.COMMAND,"A"));
            findElementClickable(profileNameField).sendKeys(Keys.DELETE);
            findElementClickable(profileNameField).sendKeys(name);
            return this;
        }
    public ProfilePage generateRandomName() {
        String name =UUID.randomUUID().toString().replace("-", "");
        System.out.println(name);
        return this;
    }

        public ProfilePage enterNewEmailAddress(String email) {
            findElementClickable(emailAddressField).sendKeys(Keys.chord(Keys.COMMAND,"A",Keys.BACK_SPACE));
            emailAddressField.sendKeys(email);
            return this;
        }

        public ProfilePage changePassword(String newPassword) {
            findElementClickable(newPasswordField).sendKeys(Keys.chord(Keys.COMMAND,"A", Keys.BACK_SPACE));
            newPasswordField.sendKeys(newPassword);
            return this;
        }

        public ProfilePage clickSave() {
            findElementClickable(saveBtn).click();
            return this;
        }

        public ProfilePage changeBackgroundTheme() {
            findElementClickable(changeTheme).click();
            System.out.println("New Theme is clicked");
            return this;
        }
        public boolean themeChanged(){
            return    findElementVisible(changeThemeConfirmation).isDisplayed();
        }

    }

