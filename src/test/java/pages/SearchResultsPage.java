package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static java.sql.DriverManager.getDriver;

public class SearchResultsPage extends BasePage{
    public SearchResultsPage(WebDriver givenDriver){ super(givenDriver); }
    @FindBy(css = "section.songs button[data-test='view-all-songs-btn']")
    private WebElement viewAllBtn;
    @FindBy(css = "section#songResultsWrapper .btn-add-to")
    private WebElement addToBtn;
    @FindBy(css = "#songResultsWrapper input")
    private WebElement newPlaylistField;
    @FindBy(xpath = "//tr[@class='song-item playing selected']/td[2]")
    private WebElement songTitle;
    @FindBy(css = "#progressPane h3")
    private WebElement songPlaying;
    private WebElement song;
    private WebElement list;

    public SearchResultsPage clickViewAll(){ click(viewAllBtn); return this; }
    public SearchResultsPage clickAddTo(){ click(addToBtn); return this; }
    public SearchResultsPage addToNewPlaylist(String newPlaylist){ findElement(newPlaylistField).sendKeys(newPlaylist, Keys.ENTER); return this;}
    public SearchResultsPage selectSong(int x){ song = driver.findElement(By.cssSelector("#songResultsWrapper tr.song-item:nth-child(" + x + ")")); click(song); return this;}
    public SearchResultsPage selectAList(int x){ list = driver.findElement(By.cssSelector("#songResultsWrapper li:nth-child(" + x + ")")); click(list); return this;}
    public SearchResultsPage confirmResultsFound(){ Assert.assertTrue(viewAllBtn.isDisplayed()); return this; }
    public SearchResultsPage confirmSongTopQueued(){ Assert.assertEquals(songTitle.getText(), songPlaying.getText()); return this;}
}
