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
        doubleClick(firstPlaylist);
    }

    public void enterNewPlaylistName(String playlistName) {

        findElement(playlistNameFiled).sendKeys(playlistName);
        findElement(playlistNameFiled).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        findElement(playlistNameFiled).sendKeys(playlistName);
        findElement(playlistNameFiled).sendKeys(Keys.ENTER);
    }

    public boolean doesPlaylistExist(String playlistName) {
        By newPlaylist = By.xpath("//a[text()'" + playlistName + "']");
        return findElement(newPlaylist).isDisplayed();
    }

    By userAvatarIcon = By.cssSelector("img.avatar");
    By allSongs = By.cssSelector("li a.songs");

    public WebDriver getUserElement() {
        return (WebDriver) findElement(userAvatarIcon);
    }


    public void chooseAllSongList(){
        waitForOverlayToGoAway();
        findElement(allSongs).click();


    }
}