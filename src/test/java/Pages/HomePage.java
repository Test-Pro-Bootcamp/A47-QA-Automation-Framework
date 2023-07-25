package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css = "img.avatar")
    private WebElement userAvatarIcon;

    @FindBy(css = "li a.songs")
    private WebElement allSongs;

    @FindBy(css = "[data-testid='play-btn']")
    private WebElement playBtn;

    @FindBy(css = ".playlist:nth-child(3)")
    private WebElement choosePlayList;

    @FindBy(css = "[name='name']")
    private WebElement playListInputField;

    @FindBy(css = "div.success.show")
    private WebElement playlistElement;

    @FindBy(css = "[type='search']")
    private WebElement searchField;

    @FindBy(css = "div.results section.songs h1 button")
    private WebElement viewAllSearchResult;

    @FindBy(css = "section#songResultsWrapper tr.song-item td.title")
    private WebElement firstSong;

    @FindBy(css = "button.btn-add-to")
    private WebElement clickAdd;

    @FindBy(xpath = "//section[@id='songResultsWrapper']//li[contains(text(),'Olof Triana Playlist')]")
    private WebElement choosePlaylist;

    @FindBy(css = "#songResultsWrapper section.existing-playlists li:nth-child(5)")
    private WebElement firstUserPlaylistSongResult;

    @FindBy(css = "div.success.show")
    private WebElement notificationElement;

    @FindBy(css = "#playlists ul li:nth-child(4) a")
    private WebElement clickPlayList;

    @FindBy(css = "span > button.del.btn-delete-playlist")
    private WebElement deleteThisPlaylist;

    @FindBy(css = "body > div.alertify > div > div > nav > button.ok")
    private WebElement okButton;

    @FindBy(css = "div.success.show")
    private WebElement deletedPlaylistNotification;


    public WebElement getUserAvatar() {
        return userAvatarIcon;
    }


    //play song method
    public HomePage chooseAllSongList() {
        waitForOverlayToGoAway();
        allSongs.click();
        return this;

    }
   public HomePage hoverPlay() {
    hoverAction(playBtn);
    return this;
    }

    public HomePage doubleClickPlaylist() {
        doubleClick(choosePlayList);
        return this;
    }
    public HomePage changePlaylistInputField() {
        // added find element helper to implement wait
        findElement(playListInputField).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        findElement(playListInputField).sendKeys("NewPlaylistNamessss");
        findElement(playListInputField).sendKeys(Keys.ENTER);
        return this;
    }
    public String doesPlaylistExist() {
        return findElement(playlistElement).getText();//added helper method for wait
    }
    public HomePage openSearchField(String songName) {
        searchField.click();
        searchField.clear();
        searchField.sendKeys(songName);
        return this;
    }
    public HomePage clickViewAllSearchResult() {
        viewAllSearchResult.click();
        return this;
    }
    public HomePage clickFirstSong()  {
        firstSong.click();
        return this; }

    public HomePage clickAddButton() {
        clickAdd.click();
        return this;
    }
    public HomePage addToPlayList() {
        firstUserPlaylistSongResult.click();
        return this;
    }
    public String getNotificationText() {
        return notificationElement.getText();
        //Thread.sleep(2000);
    }
    public HomePage clickOnPlaylist() {
        choosePlayList.click();
        return this;
    }
    public HomePage removePlaylist() {
        deleteThisPlaylist.click();
        return this;
    }
    public HomePage clickOkInPopUp() {
        okButton.click();
        return this;
    }
    public String confirmPlaylistDeleted() {
        return deletedPlaylistNotification.getText();
    }

}
