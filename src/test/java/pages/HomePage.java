package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

    public HomePage(WebDriver givenDriver){
        super(givenDriver);
    }

    By userAvatarIcon = By.cssSelector("img.avatar");
    By playListOne = By.cssSelector(".playlist:nth-child(3)");

    By playlistNameGiven = By.cssSelector("[name= 'name']");
    By allSongs = By.cssSelector("li a.songs");
    public void doubleClickPlaylist(){
        doubleClickPlaylist(playListOne);
    }
    public void enterNewPlaylistName(String playlistName){

        findElement(playlistNameGiven).sendKeys(playlistName);
        findElement(playlistNameGiven).sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        findElement(playlistNameGiven).sendKeys(playlistName);
        findElement(playlistNameGiven).sendKeys(Keys.ENTER);
    }

    public boolean doesPlaylistExist(String playlistName){
        By newPlaylist = By.xpath("//a[text()='" + playlistName + "' ]");
        return findElement(newPlaylist).isDisplayed();
    }

    public WebElement getUserAvatar(){
        return findElement(userAvatarIcon);
    }

    public void chooseAllSongsList(){
        waitForOverlayToGoAway();
        findElement(allSongs).click();
    }

}
