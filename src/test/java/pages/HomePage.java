package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    By userAvatarIcon = By.cssSelector("img.avatar");
    By allSongs = By.cssSelector("li a.songs");
    By playBtn = By.cssSelector("[data-testid='play-btn']");

    public WebElement getUserAvatar() {
        return findElement(userAvatarIcon);
    }

    // Play Song methods
    public void chooseAllSongsList() {
        waitForOverlayToGoAway();
        findElement(allSongs).click();
    }

    public WebElement hoverPlay() {
        hoverAction(playBtn);
        return findElement(playBtn);
    }
}
