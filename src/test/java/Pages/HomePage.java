package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css = "img.avatar")
    private WebElement userAvatarIcon;

    @FindBy(css = "li a.songs")
    private WebElement allSongs;

    @FindBy(css = "[data-testid='play-btn']")
    private WebElement playBtn;

    public WebElement getUserAvatar() {
        return userAvatarIcon;
    }


    //play song method
    public HomePage chooseAllSongList() {
        waitForOverlayToGoAway();
        allSongs.click();
        return this;

    }
   public HomePage hoverPlay() {
    hoverAction(playBtn);
    return this;
    }


}
