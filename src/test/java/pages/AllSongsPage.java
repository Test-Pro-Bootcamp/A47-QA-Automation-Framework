package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllSongsPage extends BasePage {
    public AllSongsPage (WebDriver givenDriver){ super(givenDriver); }
    private WebElement song;
    @FindBy(css = "nav.menu li.playback")
    private WebElement playbackBtn;

    public AllSongsPage contextClickSong(int x){
        song = driver.findElement(By.cssSelector("#songsWrapper tr.song-item:nth-child(" + x + ")"));
        contextClick(song); return this;}
    public AllSongsPage clickPlayback(){ click(playbackBtn); return this;}
}