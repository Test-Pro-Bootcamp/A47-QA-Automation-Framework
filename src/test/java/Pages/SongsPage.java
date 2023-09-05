package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SongsPage extends BasePage{
    public SongsPage(WebDriver givenDriver) {super(givenDriver);}
    // Play song Locators - using context click
    //private By firstSongLocator = By.cssSelector(".all-songs tr.song-item:nth-child(1)");
    @FindBy(css = ".all-songs tr.song-item:nth-child(1)")
    private WebElement firstSong;

    //private By playOptionLocator = By.cssSelector("li.playback");
    @FindBy(css = "li.playback")
    private WebElement playOption;

    //private By soundBarVisualizer = By.cssSelector("[data-testid='sound-bar-play']");
    @FindBy(css = "[data-testid='sound-bar-play']")
    private WebElement soundBarVisualizer;

    // Play song using context click
    public void contextClickFirstSong() {
        contextClick( firstSong);
    }
    public void choosePlayOption() {
        (playOption).click();
    }
    public boolean isSongPlaying() {
        return (soundBarVisualizer).isDisplayed();
    }
}
