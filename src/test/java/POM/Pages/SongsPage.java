package POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SongsPage extends BasePage{

    @FindBy(css = "#sidebar > section.music > ul > li:nth-child(3) > a")
    private WebElement allSongs;
    @FindBy(css = "#songsWrapper > div > div > div.item-container > table > tr:nth-child(1) > td.title ")
    private WebElement fistSongSelection;
    @FindBy(css = "div.bars")
    private WebElement playBars;
    @FindBy(css = ".btn-add-to")
    private WebElement addButton;
    @FindBy(css = "#songsWrapper > header > div.song-list-controls > div > section.existing-playlists > ul > li:nth-child(6)")
    private WebElement playlistSelection;
    @FindBy(css = ".existing-playlists ul > li")
    private WebElement itemsList;

    public SongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public SongsPage selectRandom(){
        clickAddButton();
        for(int i = 5; i<11;i++){
            findElement(itemsList);
            List<WebElement> listItems = driver.findElements(By.cssSelector(".existing-playlists ul > li"));
            int size = listItems.size();
            int randomNumber = ThreadLocalRandom.current().nextInt(5, size);
            listItems.get(randomNumber).click();
        }
        return this;
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


