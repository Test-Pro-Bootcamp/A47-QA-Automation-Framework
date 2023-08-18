package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlaySongPage extends BasePage {

    public PlaySongPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css ="[title='Play next song']" )
    WebElement playNextBtn;

    @FindBy (css ="span.play" )
    WebElement  playBtn;

    public PlaySongPage clickPlayNext() {
        playNextBtn.click();
        return this;
    }

    public PlaySongPage clickPlay() {
        playBtn.click();
        return this;
    }
}
