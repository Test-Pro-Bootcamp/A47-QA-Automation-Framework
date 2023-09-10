package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllSongsPage extends BasePage {
    public AllSongsPage (WebDriver givenDriver){
        super(givenDriver);
    }
    @FindBy(css =".all-songs tr.song-item:nth-child(1)")
    WebElement firstSong;
    @FindBy(css = "[class='playback']")
    WebElement playSong;
    @FindBy(css = "[alt='Sound bars']")
    WebElement soundBar;
    public void contextClickFirstSong() {
        contextClick(firstSong);
    }
    public void choosePlayOption() {
        playSong.click();
    }
    public boolean isSongPlaying(){
        return soundBar.isDisplayed();
    }

}
