package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    By firstPlaylist = By.cssSelector(".playlist:nth-child(3)");
    By playlistNameField = By.cssSelector("[name = 'name']");
    By clickPlaylist = By.xpath("//li[@class='playlist playlist'][1]");
    By clickDelete = By.cssSelector(".del");
    By notification = By.cssSelector("div.success.show");
    By allSongs = By.cssSelector("li a.songs");
    By searchField = By.cssSelector("div#searchForm input[type = 'search']");
    By viewAllSearchResult = By.cssSelector("div.results section.songs h1 button");
    By firstSongResult = By.cssSelector("section#songResultsWrapper tr.song-item td.title");
    By addToButton = By.cssSelector("button.btn-add-to");
    By choosePlaylist = By.xpath("//section[@id = 'songResultsWrapper']//li[contains(text(), 'Epic Playlist')]");

    public void doubleClickPlaylist() {
        doubleClick(firstPlaylist);
    }
    public void newPlaylistName(String playlistName) {
        findElement(playlistNameField).sendKeys(playlistName);
        findElement(playlistNameField).sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.BACK_SPACE));
        findElement(playlistNameField).sendKeys(playlistName);
        findElement(playlistNameField).sendKeys(Keys.ENTER);
    }
    public boolean playlistIsDisplayed(String playlistName) {
        By newPlaylist = By.xpath("//a[text() = '"+playlistName+"']");
        return findElement(newPlaylist).isDisplayed();
    }
    public void openPlaylist() {
        click(clickPlaylist);
    }
    public  void deletePlaylistBtn() {
        click(clickDelete);
    }
    public void chooseAllSongsList() {
        waitForOverlay();
        click(allSongs);
    }
    public void searchSong (String songTitle) {
        findElement(searchField).sendKeys(songTitle);
    }
    public void clickViewAll () {
        click(viewAllSearchResult);
    }
    public void selectFirstSongResult() {
        click(firstSongResult);
    }
    public void clickAddTo() {
        click(addToButton);
    }
    public void choosePlaylist() {
        click(choosePlaylist);
    }
    public String notificationMessage() {
        return findElement(notification).getText();
    }
}
