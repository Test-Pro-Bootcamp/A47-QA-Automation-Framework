package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllSongsPage extends BasePage {
    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css = ".all-songs tr.song-item:nth-child(1)")
    WebElement firstSong;

    @FindBy(css = "li.playback")
    WebElement playSong;

    @FindBy(xpath = "//*[@id='mainFooter']/div[2]/div[2]/div/button[1]/div")
    WebElement soundBar;

    public void contextClickFirstSong() {
        contextClick((By) firstSong);
    }

    public void choosePlayOption() {
        findElement((By) playSong).click();
    }

    public Boolean isSongPlaying() {
        return findElement((By) soundBar).isDisplayed();
    }
}
