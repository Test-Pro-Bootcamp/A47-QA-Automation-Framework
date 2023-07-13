package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    @FindBy(css = ".playlist:nth-child(3)")
    private WebElement firstPlaylist;
    @FindBy(css = "[name='name']")
    private WebElement playlistNameField;
    @FindBy(css = ".next")
    private WebElement playNextSongBtn;
    @FindBy(xpath = "//span[@data-testid = 'play-btn']")
    private WebElement playSongBtn;
    @FindBy(xpath = "//li[@class='playlist playlist'][1]")
    private WebElement clickPlaylist;
    @FindBy(css = ".del")
    private WebElement clickDelete;
    @FindBy(css = "div.success.show")
    private WebElement deleteMsg;
    @FindBy(className = "bars")
    private WebElement soundBar;
    @FindBy(className = "pause")
    private WebElement pauseBtn;
    public HomePage doubleClickPlaylist() {
        doubleClick(firstPlaylist);
        return this;
    }
    public HomePage newPlaylistName(String playlistName) {
        findElement(playlistNameField).sendKeys(playlistName);
        findElement(playlistNameField).sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.BACK_SPACE));
        findElement(playlistNameField).sendKeys(playlistName);
        findElement(playlistNameField).sendKeys(Keys.ENTER);
        return this;
    }
    public boolean playlistIsDisplayed(String playlistName) {
        WebElement newPlaylist = driver.findElement(By.xpath("//a[text() = '"+playlistName+"']"));
        return findElement(newPlaylist).isDisplayed();
    }
    public HomePage playASong() {
        playNextSongBtn.click();
        playSongBtn.click();
        return this;
    }
    public HomePage openPlaylist() {
        clickPlaylist.click();
        return this;
    }
    public HomePage deletePlaylistBtn() {
        clickDelete.click();
        return this;
    }
    public String getDeleteMsg() {
        return deleteMsg.getText();
    }
    public boolean soundBarIsDisplayed() {
        return soundBar.isDisplayed();
    }
    public boolean pauseBtnIsDisplayed() {
        return pauseBtn.isDisplayed();
    }


}
