package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    By playButton = By.xpath("//span[@data-testid='play-btn']");
    By playNextButton = By.xpath("//i[@data-testid='play-next-btn']");
    By playlist = By.cssSelector(".playlist:nth-child(3)");
    By playlistInputField = By.cssSelector("[name='name']");


    public void playSong() {
        click(playButton);
    }
    public void playNextSong () {
        click(playNextButton);
    }
    public boolean isSongPlaying() {
        By soundbar =  By.xpath("//div[@data-testid= 'sound-bar-play']");
        WebElement soundBarElement = findElement(soundbar);
        return findElement(soundbar).isDisplayed();
//        return soundbar.isDisplayed();
    }

    public void doubleClickPlaylist() {
        doubleClick(playlist);
    }
    public void enterPlaylistName(String newPlaylistName) {
        findElement(playlistInputField).sendKeys(newPlaylistName);
        findElement(playlistInputField).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        findElement(playlistInputField).sendKeys(newPlaylistName);
        findElement(playlistInputField).sendKeys(Keys.ENTER);
    }
    public boolean doesPlaylistExist(String newPlaylistName) {
        By newPlaylist = By.cssSelector("body > .alertify-logs.right.top");
        return findElement(newPlaylist).isDisplayed();
    }
}