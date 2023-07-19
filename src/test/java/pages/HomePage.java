package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver){ super(givenDriver); }
    @FindBy(css = "img.avatar")
    private WebElement avatarIcon;
    @FindBy(css = ".view-profile")
    private WebElement username;
    @FindBy(css = "li a.songs")
    private WebElement allSongs;
    @FindBy(css = "span.pause")
    private WebElement pauseBtn;
    @FindBy(css = "span.play")
    private WebElement playBtn;
    @FindBy(css = "input[type='search']")
    private WebElement searchField;
    @FindBy(css = "i[title='Play next song']")
    private WebElement nextSongBtn;
    @FindBy(css = "i[title='Play previous song']")
    private WebElement prevSongBtn;
    @FindBy(css = "[name='name']")
    private WebElement playlistInputField;
    private WebElement playlist;

    public WebElement getAvatar(){ return findElement(avatarIcon); }
    public WebElement getUsername(){ return findElement(username); }
    public WebElement moveToPauseBtn(){ return findElement(pauseBtn); }
    public WebElement moveToPlayBtn(){ return findElement(playBtn); }
    public void clickAllSongs(){ click(allSongs); }
    public void clickUsername(){ click(username); }
    public void selectPlaylist(int x){
        playlist = driver.findElement(By.cssSelector("#playlists ul > li:nth-child(" + x + ")"));
        click(playlist); }
    public HomePage clickPrevSong(){ click(prevSongBtn); return this;}
    public HomePage clickNextSong(){ click(nextSongBtn); return this;}
    public HomePage searchSong(String song){ searchField.sendKeys(song); return this;}
    public HomePage renamePlaylist(int x, String newPlaylistName){
        playlist = driver.findElement(By.cssSelector("#playlists ul > li:nth-child(" + x + ")"));
        doubleClick(playlist);
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A"), Keys.BACK_SPACE);
        playlistInputField.sendKeys(newPlaylistName, Keys.ENTER);
        return this;
    }
}
