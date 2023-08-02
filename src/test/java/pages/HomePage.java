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
    @FindBy(css = ".playlist:nth-child(3)")
    private WebElement firstPlaylist;
    @FindBy(css = "[name='name']")
    private WebElement playlistNameField;
    @FindBy(xpath = "//li[@class='playlist playlist'][1]")
    private WebElement clickPlaylist;
    @FindBy(css = ".del")
    private WebElement clickDelete;
    @FindBy(css = "div.success.show")
    private WebElement notification;
    @FindBy(css = "li a.songs")
    private WebElement allSongs;
    @FindBy(xpath = "//a[text() = 'Testing Playlist']")
    private WebElement newPlaylist;
    @FindBy(css = "div#searchForm input[type = 'search']")
    private WebElement searchField;
    @FindBy(css = "div.results section.songs h1 button")
    private WebElement viewAllSearchResult;
    @FindBy(css = "section#songResultsWrapper tr.song-item td.title")
    private WebElement firstSongResult;
    @FindBy(css = "button.btn-add-to")
    private WebElement addToButton;
    @FindBy(xpath = "//section[@id = 'songResultsWrapper']//li[contains(text(), 'Test Pro Edited Playlist 2')]")
    private WebElement choosePlaylist;
    @FindBy(css = "img[class='avatar']")
    private WebElement avatarIcon;
    @FindBy(css = "div[class='dialog']>div>nav>button[class='ok']")
    private WebElement confirmationOkBtn;
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
        return findElement(newPlaylist).isDisplayed();
    }
    public HomePage openPlaylist() {
        click(firstPlaylist);
        return this;
    }
    public HomePage deletePlaylistBtn() {
        click(clickDelete);
        return this;
    }
    public String getDeleteMsg() {
        return findElement(notification).getText();
    }
    public HomePage chooseAllSongsList() {
        waitForOverlay();
        click(allSongs);
        return this;
    }
    public HomePage searchSong (String songTitle) throws InterruptedException {
        findElement(searchField).sendKeys(songTitle);
        return this;
    }
    public HomePage clickViewAll () throws InterruptedException {
        click(viewAllSearchResult);
        return this;
    }
    public HomePage selectFirstSongResult() throws InterruptedException {
        click(firstSongResult);
        return this;
    }
    public HomePage clickAddTo() throws InterruptedException {
        click(addToButton);
        return this;
    }
    public HomePage choosePlaylist() throws InterruptedException {
        click(choosePlaylist);
        return this;
    }
    public HomePage clickonConfirmationOkBtn() throws InterruptedException {
        click(confirmationOkBtn);
        return this;
    }
    public String notificationMessage() {
        return findElement(notification).getText();
    }
    public boolean isAvatarDisplayed() {
        return findElement(avatarIcon).isDisplayed();
    }
}
