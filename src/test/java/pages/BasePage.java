package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    WebDriver driver;
    private WebDriverWait wait = null;
    private Actions actions = null;

    public BasePage (WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
    }
    @FindBy(css = ".overlay.loading")
    private WebElement overlayLocator;
    @FindBy(css = "div.success.show")
    private WebElement successMsg;
    @FindBy(css = "input[type='search']")
    private WebElement searchField;
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
    @FindBy(css = "i[title='Play next song']")
    private WebElement nextSongBtn;
    @FindBy(css = "i[title='Play previous song']")
    private WebElement prevSongBtn;
    @FindBy(css = "[name='name']")
    private WebElement playlistInputField;
    @FindBy(css = "i[title='Create a new playlist']")
    private WebElement addPlaylistBtn;
    @FindBy(css = "li[data-testid='playlist-context-menu-create-simple']")
    private WebElement newPlaylistBtn;
    @FindBy(css = "nav[tabindex='0'] li:nth-child(2)")
    private WebElement deletePlaylistBtn;
    @FindBy(css = "button.ok")
    private WebElement okBtn;
    private WebElement playlist;

    public BasePage clickAllSongs(){ click(allSongs); return this; }
    public BasePage clickUsername(){ click(username); return this; }
    public BasePage clickAddPlaylistBtn(){ click(addPlaylistBtn); return this; }
    public BasePage clickNewPlaylistBtn(){ click(newPlaylistBtn); return this; }
    public BasePage clickPrevSong(){ click(prevSongBtn); return this;}
    public BasePage clickNextSong(){ click(nextSongBtn); return this;}
    public BasePage clickDeletePlaylistBtn() { click(deletePlaylistBtn); clickOkBtn(); return this; }
    public BasePage enterPlaylistText(String newPlaylistName){ playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A"), Keys.BACK_SPACE); playlistInputField.sendKeys(newPlaylistName, Keys.ENTER); return this; }
    public BasePage doubleClickPlaylist(int x){ playlist = driver.findElement(By.cssSelector("#playlists ul > li:nth-child(" + x + ")")); doubleClick(playlist); return this;}
    public BasePage clickPlaylist(int x){ playlist = driver.findElement(By.cssSelector("#playlists ul > li:nth-child(" + x + ")")); click(playlist); return this; }
    public BasePage contextClickPlaylist(int x) { playlist = driver.findElement(By.cssSelector("#playlists ul > li:nth-child(" + x + ")")); contextClick(playlist); return this; }
    public BasePage clickOkBtn(){
        List<WebElement> btn = driver.findElements(By.cssSelector("button.ok"));
        if (btn.size() == 0) {
            return this;
        } else if (btn.size() == 1) {
            click(okBtn);
        }
        return this;
    }
    public BasePage waitForOverlay(){ wait.until(ExpectedConditions.invisibilityOf(overlayLocator)); return this;}
    public BasePage searchViaSearchBar(String song){ searchField.sendKeys(song); return this;}
    public BasePage click(WebElement e){ actions.click(wait.until(ExpectedConditions.elementToBeClickable(e))).perform(); return this;}
    public BasePage doubleClick(WebElement e){ actions.doubleClick(wait.until(ExpectedConditions.elementToBeClickable(e))).perform(); return this;}
    public BasePage contextClick(WebElement e){ actions.contextClick(wait.until(ExpectedConditions.elementToBeClickable(e))).perform(); return this;}
    public WebElement getSuccessMsg(){ return findElement(successMsg); }
    public WebElement findElement(WebElement e){ actions.moveToElement(e).perform(); return wait.until(ExpectedConditions.visibilityOf(e)); }
    public WebElement moveToElement(WebElement e){wait.until(ExpectedConditions.visibilityOf(e)); actions.moveToElement(e).perform(); return e;}
    public WebElement getAvatar(){ return findElement(avatarIcon); }
    public WebElement getUsername(){ return findElement(username); }
    public WebElement moveToPauseBtn(){ return findElement(pauseBtn); }
    public WebElement moveToPlayBtn(){ return findElement(playBtn); }
}
