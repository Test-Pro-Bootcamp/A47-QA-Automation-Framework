package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver){ super(givenDriver); }

    By avatarIcon = By.cssSelector("img.avatar");
    By username = By.cssSelector("span.name");
    By allSongs = By.cssSelector("li a.songs");
    By pauseBtn = By.cssSelector(".pause .fa.fa-pause");
    By playBtn = By.cssSelector(".play .fa.fa-play");
    By searchField = By.cssSelector("input[type='search']");
    By nextSongBtn = By.cssSelector("i[title='Play next song']");
    By prevSongBtn = By.cssSelector("i[title='Play previous song']");
    By playlistInputField = By.cssSelector("[name='name']");



    public WebElement getAvatar(){ return findElement(avatarIcon); }
    public WebElement getUsername(){ return findElement(username); }
    public WebElement moveToPauseBtn(){ return moveToElement(pauseBtn); }
    public WebElement moveToPlayBtn(){ return moveToElement(playBtn); }
    public void clickAllSongs(){ click(allSongs); }
    public void clickPlaylist(int x){ click(By.cssSelector("#playlists ul > li:nth-child(" + x + ")")); }
    public void clickPrevSong(){ click(prevSongBtn);}
    public void clickNextSong(){ click(nextSongBtn); }
    public void searchSong(String song){ findElement(searchField).sendKeys(song);}
    public void renamePlaylist(int x, String newPlaylistname){
        doubleClick(By.cssSelector("#playlists ul > li:nth-child(" + x + ")"));
        findElement(playlistInputField).sendKeys(Keys.chord(Keys.CONTROL, "A"), Keys.BACK_SPACE, newPlaylistname, Keys.ENTER);
    }
}
