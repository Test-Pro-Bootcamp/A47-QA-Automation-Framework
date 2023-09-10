package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        //This method initializes the WebDriver using the super (givenDriver)
        super(givenDriver);
    }
    // Avatar icon on Homepage
    private By userAvatarIcon = By.cssSelector("img.avatar");
    // Locators: Add Song to Playlist
    private By searchField = By.cssSelector("[type='search']");
    private By viewAllButton = By.cssSelector("[data-test ='view-all-songs-btn']");
    private By selectSong = By.cssSelector("section#songResultsWrapper tr.song-item td.title");
    private By addToButton = By.cssSelector("[data-test = 'add-to-btn']");
    private By notification = By.cssSelector("div.success.show");
//  private By choosePlaylist =
//            By.xpath("//section[@id='songResultsWrapper']//li[contains(text(), 'Beta')]");
    public WebElement getUserAvatar(){
        waitForOverlayToVanish();
        return  findElementVisible(userAvatarIcon);
    }
    public boolean avatarIsDisplayed(){
        WebElement avatarElement = findElementVisible(userAvatarIcon);
        return avatarElement.isDisplayed();
    }

// Search song and add to playlist
//--------------------------------
    public void searchSong (String songText) {
        waitForOverlayToVanish();
        WebElement searchElement = findElementClickable(searchField);
        searchElement.click();
        waitForOverlayToVanish();
        searchElement.clear();
        searchElement.sendKeys(songText);
    }
    public void clickViewAllButton (){
        waitForOverlayToVanish();
        WebElement viewAllElement = findElementClickable(viewAllButton);
        viewAllElement.click();
        System.out.println("View All button is clicked ");
    }
    public void clickFirstSong () {
        waitForOverlayToVanish();
        WebElement clickSong = findElementClickable(selectSong);
        clickSong.click();
        System.out.println("First Song is clicked ");
    }
    public void clickAddToButton () {
        WebElement addToElement = findElementClickable(addToButton);
        addToElement.click();
        System.out.println("Add To button is clicked ");
    }
    public void clickPlaylist (String Playlist) {
        String choosePlaylist =
                "//section[@id='songResultsWrapper']//li[contains(text(), '" + Playlist + "')]";
        WebElement choosePlaylistElement = findElementClickable(By.xpath(choosePlaylist));
        choosePlaylistElement.click();
        System.out.println("Playlist " + Playlist + " is clicked");
    }

    public String getNotification (){
        WebElement notificationMessage = findElementVisible(notification);
        String Text = notificationMessage.getText();
        System.out.println("Notification Text is: " +Text);
        return Text;
    }
}
