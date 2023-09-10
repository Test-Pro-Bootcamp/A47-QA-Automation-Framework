package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage extends BasePage{
    public SearchResultsPage(WebDriver givenDriver){ super(givenDriver); }

    By viewAllBtn = By.cssSelector("section.songs button[data-test='view-all-songs-btn']");
    By addToBtn = By.cssSelector("section#songResultsWrapper .btn-add-to");
    By newPlaylistField = By.cssSelector("#songResultsWrapper input");

    public void clickViewAll(){ click(viewAllBtn); }
    public void selectSong(int x){ click( By.cssSelector("#songResultsWrapper tr.song-item:nth-child(" + x + ")")); }
    public void addToList(int x){ click(addToBtn); click(By.cssSelector("#songResultsWrapper li:nth-child(" + x + ")")); }
    public void addToNewPlaylist(String newPlaylist){ click(addToBtn); findElement(newPlaylistField).sendKeys(newPlaylist, Keys.ENTER);}

}
