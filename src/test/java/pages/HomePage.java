package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    By firstPlaylist = By.cssSelector(".playlist:nth-child(3)");
    By playlistNameFiled = By.cssSelector("[name='name']");

    public void doubleClickPlaylist() {
        doubleClick((WebElement) firstPlaylist);
    }

    public void enterNewPlaylistName(String playlistName) {

        findElement((WebElement) playlistNameFiled).sendKeys(playlistName);
        findElement((WebElement) playlistNameFiled).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        findElement((WebElement) playlistNameFiled).sendKeys(playlistName);
        findElement((WebElement) playlistNameFiled).sendKeys(Keys.ENTER);
    }

    public boolean doesPlaylistExist(String playlistName) {
        By newPlaylist = By.xpath("//a[text()'" + playlistName + "']");
        return findElement((WebElement) newPlaylist).isDisplayed();
    }

    By userAvatarIcon = By.cssSelector("img.avatar");
    By allSongs = By.cssSelector("li a.songs");

    public WebDriver getUserElement() {
        return (WebDriver) findElement((WebElement) userAvatarIcon);
    }


    public void chooseAllSongList(){
        waitForOverlayToGoAway();
        findElement((WebElement) allSongs).click();


    }

    public boolean isAvatarDisplayed() {
        return false;
    }
}