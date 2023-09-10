package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    @FindBy(css = "img.avatar")
    private WebElement userAvatarIcon;

    public WebElement getUserAvatar(){
        waitForOverlayToVanish();
        return findElementVisible(userAvatarIcon);
    }
    public boolean avatarIsDisplayed(){
        return (findElementVisible(userAvatarIcon)).isDisplayed();
    }
}
