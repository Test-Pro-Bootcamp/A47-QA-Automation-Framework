package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RenamePlaylistPage extends BasePage{
    public RenamePlaylistPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css ="a[href='#!/playlist/65758']" )
    WebElement option;

    @FindBy (css ="#playlists > ul > li:nth-child(3) > nav > ul > li:nth-child(1)" )
    WebElement  edit;

    @FindBy (css ="[name='name']")
    WebElement  naming;

    public RenamePlaylistPage openOption() {
        option.click();
        return this;
    }

    public RenamePlaylistPage clickEdit() {
        edit.click();
        return this;
    }
    public RenamePlaylistPage rename(String playlistName) {
        naming.sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.BACK_SPACE));
        naming.sendKeys(playlistName);
        naming.sendKeys(Keys.RETURN);
        return this;
    }
}
