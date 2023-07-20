package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllSongsPage extends BasePage {

    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    @FindBy(css = ".all-songs tr.song-item:nth-child(1)")
    private WebElement firstSong;
    @FindBy(css = "li.playback")
    private WebElement playSong;
    @FindBy(className = "bars")
    private WebElement soundBar;
    public AllSongsPage contextClickFirstSong() {
        contextClick(firstSong);
        return this;
    }
    public AllSongsPage choosePlayOption() {
        click(playSong);
        return this;
    }
    public boolean isSongPlaying() {
        return findElement(soundBar).isDisplayed();
    }
}
