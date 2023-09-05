package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        //This method initializes the WebDriver using the super (givenDriver)
        super(givenDriver);
    }

    // Avatar icon on Homepage
    @FindBy(css = "img.avatar")
    private WebElement userAvatarIcon;

    // Locators: Search & Add Song to Playlist
    @FindBy(css = "[type='search']")
    private WebElement searchField;

    @FindBy(css = "[data-test ='view-all-songs-btn']")
    private WebElement viewAllButton;

    @FindBy(css = "section#songResultsWrapper tr.song-item td.title")
    private WebElement selectSong;

    @FindBy(css = "[data-test = 'add-to-btn']")
    private WebElement addToButton;

    @FindBy(xpath = "//section[@id='songResultsWrapper']//li[@class='playlist']")
    private WebElement choosePlaylist;

    @FindBy(css = "div.success.show")
    private WebElement notification;

    @FindBy(css = "li a.songs")
    private WebElement allSongsListLocator;

    @FindBy (xpath = "//span[@class='name']")
    private WebElement changeProfileBtn;

// User Avatar
//--------------------------------
    public WebElement getUserAvatar(){
        waitForOverlayToVanish();
        return findElementVisible(userAvatarIcon);
    }
    public boolean avatarIsDisplayed(){
        return (findElementVisible(userAvatarIcon)).isDisplayed();
    }

// Search song and add to playlist
//--------------------------------
    public void searchSong (String songText) {
        waitForOverlayToVanish();
        findElementVisible(searchField).click();
        findElementClickable(searchField).clear();
        findElementClickable(searchField).sendKeys(songText);
    }
    public void clickViewAllButton (){
        waitForOverlayToVanish();
        findElementClickable(viewAllButton).click();
        System.out.println("View All button is clicked");
    }
    public void clickFirstSong () {
        waitForOverlayToVanish();
        findElementClickable(selectSong).click();
        System.out.println("First Song is clicked");
    }
    public void clickAddToButton () {
        findElementClickable(addToButton).click();
        System.out.println("Add To button is clicked ");
    }
    public void clickPlaylist () {
        findElementVisible(choosePlaylist).click();
        System.out.println("Playlist is clicked ");
    }
    public String getNotification (){
        String Text = findElementVisible(notification).getText();
        System.out.println("Notification Text is: " + Text);
        return Text;
    }
    // Context Click- Play a Song
    public void chooseAllSongsList() {
        waitForOverlayToVanish();
        findElementClickable(allSongsListLocator).click();
    }
    public void clickProfileBtn(){
        waitForOverlayToVanish();
        waitForElement(changeProfileBtn);
        findElementClickable(changeProfileBtn).click();
    }
}
