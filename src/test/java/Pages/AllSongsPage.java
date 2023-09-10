package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllSongsPage extends BasePage {
    public AllSongsPage (WebDriver givenDriver){ super(givenDriver); }

    int i = 1;
    By song = By.cssSelector("#songsWrapper tr.song-item:nth-child(" + i + ")");
    By playbackBtn = By.cssSelector("nav.menu li.playback");

    public void contextClickSong(){ contextClick(song); }
    public void clickPlayback(){ click(playbackBtn); }
}
