package POM.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SongsPage extends BasePage{

    @FindBy(css = "#sidebar > section.music > ul > li:nth-child(3) > a")
    private WebElement allSongs;
    @FindBy(css = "#songsWrapper > div > div > div.item-container > table > tr:nth-child(1) > td.title ")
    private WebElement fistSongSelection;
    @FindBy(css = "div.bars")
    private WebElement playBars;
    @FindBy(css = ".btn-add-to")
    private WebElement addButton;
    @FindBy(css = "#songsWrapper > header > div.song-list-controls > div > section.existing-playlists > ul > li:nth-child(5)")
    private WebElement playlistSelection;
    public SongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public SongsPage goToAllSongs(){
        findElement(allSongs);
        click(allSongs);
        return this;
    }
    public SongsPage doubleClickSong(){
        waitToClick(fistSongSelection);
        doubleClick(fistSongSelection);
        return this;
    }
    public SongsPage clickFirstSong(){
        findElement(fistSongSelection);
        click(fistSongSelection);
        return this;
    }
    public SongsPage clickAddButton(){
        findElement(addButton);
        click(addButton);
        return this;
    }
    public SongsPage addToPlaylistSelection(){
        findElement(playlistSelection);
        click(playlistSelection);
        return this;
    }
    public WebElement songIsPlaying(){
        return findElement(playBars);
    }

}
