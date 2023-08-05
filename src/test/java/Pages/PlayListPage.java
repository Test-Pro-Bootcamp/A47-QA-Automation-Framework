package Pages;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PlayListPage extends BasePage {

    public PlayListPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(xpath = "//a[text()='\" + NewPlaylistName + \"'] ")
    private WebElement isPlaylist;

    @FindBy(css = " section#playlists li.playlist:nth-child(3)")
    private WebElement selectedPlaylist;

//locators: Create a new playlist
    @FindBy(css = "i.fa.fa-plus-circle.create")
    private WebElement plusIcon;

    @FindBy(css = "li[data-testid='playlist-context-menu-create-simple']")
    private WebElement newSimplePlaylist;

    @FindBy(css = "input[name='name']")
    private WebElement playlistNameField;

    @FindBy(xpath = "//li[@class='playlist playlist']//a[@class='active']")
    private WebElement newPlaylist;

    // Locators: Delete a Playlist

    // Locators: Delete an existing Playlist
    //private By deletePlaylistBtn = By.cssSelector("button[title='Delete this playlist']");
    @FindBy(css = "button[title='Delete this playlist']")
    private WebElement deletePlaylistBtn;
    // By deletePlaylistBtn = By.xpath("//button[@class='del btn-delete-playlist']");

   // private By deletePlaylistOKLocator = By.cssSelector("button.ok");
    @FindBy(css = "button.ok")
    private WebElement deletePlaylistOK;

    //private By successNotifyLocator = By.cssSelector("div.success.show");
    @FindBy(css = "div.success.show")
    private WebElement successNotify;


    // Rename Playlist Locators
    //private By playlistLocator = By.cssSelector(".playlist:nth-child(3)");
    @FindBy(css = ".playlist:nth-child(3)")
    private WebElement playlist;

    //private By editMenuContextClickLocator = By.xpath("//*[@id='playlists']/ul/li[3]/nav/ul/li[1]");
    @FindBy(xpath = "//*[@id='playlists']/ul/li[3]/nav/ul/li[1]")
    private WebElement editMenuContextClick;

    //private By playListInputFieldLocator = By.cssSelector("[name='name']");
    @FindBy(xpath = "//input[@data-testid='inline-playlist-name-input']")
    private WebElement playListInputField;

    //private By playlistNameChangeMsgLocator = By.cssSelector("div.success.show");


            // By playlistLocator= By.xpath("//section[@id='playlists']//li[@class='playlist playlist'] /a");
            // editMenuContextClick= (By.cssSelector
            //                      ("nav.menu.playlist-item-menu li[data-testid='playlist-context-menu-edit-63429']")));
            //  editMenuContextClick= (By.xpath
            //          ("//nav[@class='menu playlist-item-menu']//li[data-testid='playlist-context-menu-edit-63429']")));

    // Delete Song from playlist Locators
    //private By selectSongLocator = By.cssSelector
    //        ("div[class='song-list-wrap main-scroll-wrap playlist'] td[class='title']");
    @FindBy(css = "div[class='song-list-wrap main-scroll-wrap playlist'] td[class='title']")
    private WebElement selectSong;
    //private By selectSong = By.cssSelector("section#songResultsWrapper tr.song-item td.title");



    //Create a new playlist
    //-------------------------
    public void createNewPlaylist(String Playlist) {
        waitForOverlayToVanish();
        findElementClickable(plusIcon).click();
        //
        findElementClickable(newSimplePlaylist).click();
        //
        findElementClickable(playlistNameField).sendKeys(Playlist);
        playlistNameField.sendKeys(Keys.ENTER);
        System.out.println("Playlist " + Playlist + " is created");
    }
    public String newPlaylistNotification() {
        String NewMsgText = findElementVisible(successNotify).getText();
        System.out.println("Msg Notification: " + NewMsgText);
        return NewMsgText;
    }
    public boolean newPlaylistIsDisplayed() {
        boolean isDisplayed = findElementVisible(newPlaylist).isDisplayed();
        System.out.println("Playlist is displayed = " + isDisplayed);
        return isDisplayed;
    }
    // Delete empty renamed Playlist
    //-------------------------
    public void selectDeleteRenamedPlaylist(String newPlaylistName) {
        selectPlaylist(newPlaylistName);
        deletePlaylist();
    }
// Delete empty Playlist
//-------------------------
    public void selectDeletePlaylist(String Playlist) {
        selectPlaylist(Playlist);
        deletePlaylist();
    }
// Delete Playlist that has songs
//-------------------------
    public void selectDeletePlaylistWithSong(String Playlist) {
        selectPlaylist(Playlist);
        deletePlaylistWithSong();
    }

    public void selectPlaylist (String Playlist){
        waitForOverlayToVanish();
        findElementClickable(selectedPlaylist).click();
        System.out.println("Playlist " + Playlist+ " has been selected");
    }
    public void deletePlaylist() {
        waitForOverlayToVanish();
        findElementClickable(deletePlaylistBtn).click();
        System.out.println("Playlist has been deleted");
    }

    public void deletePlaylistWithSong() {
        waitForOverlayToVanish();
        findElementClickable(deletePlaylistBtn).click();
        findElementClickable(deletePlaylistOK).click();
        System.out.println("Playlist has been deleted");
    }

    public String deletedPlaylistNotify() {
        String notifyText = findElementVisible(successNotify).getText();
        System.out.println("Message is: " + notifyText);
        return notifyText;
    }


//    public boolean isPlaylistDeleted(String Playlist){
////          WebElement  deletedPlaylist = findElementVisible
////          (By.xpath("//a[text()='" + Playlist + "']" ));
//
//            List<WebElement> deletedPlaylistElement = Collections.singletonList
//                    (driver.findElement
//                            (By.xpath("//a[text()='" + Playlist + "']")));
//            if (deletedPlaylistElement.size()==0){
//                return true;
//            }
//            else{
//                return false;
//            }
//        }

    public boolean isPlaylistDeleted(String Playlist) throws Exception {
        try {
            Thread.sleep(2000);
            if (driver.findElement(By.xpath("//a[text()='" + Playlist + "']")).isDisplayed()) {
                System.out.println("Playlist is still being displayed");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Exception encountered/ Confirmed Playlist is deleted");
            return true;
        }
        System.out.println("null");
       return false;
    }
// Delete Song From Playlist
//--------------------------
    public void deleteSongFromPlaylist() {
        Actions actions = new Actions(driver);
        findElementVisible(selectSong);
        actions.moveToElement(selectSong).click().sendKeys(Keys.DELETE).perform();
        System.out.println("Song is deleted");
    }
    public String delSongNotificationMsg() {
        String msgText1 = findElementVisible(successNotify).getText();
        System.out.println("Message is: " + msgText1);
        return msgText1;
    }

// Rename Playlist
//-------------------------
    public void doubleClickPlaylist (String Playlist) {
        waitForOverlayToVanish();
        doubleClick(playlist);
        System.out.println("Playlist " + Playlist + " is double clicked");
    }
    public void contextClickPlaylist (String Playlist){
        waitForOverlayToVanish();
        contextClick ( playlist);
        System.out.println("Playlist " + Playlist + " is right/context clicked");
    }
    public void clickEditMenu (){
        findElementVisible(editMenuContextClick).click();
        System.out.println("Edit is clicked");
    }
    public void enterNewPlaylistName (String newPlaylistName) {
        findElementVisible(playListInputField).sendKeys(Keys.chord(Keys.COMMAND, "A"));
        playListInputField.sendKeys(Keys.DELETE);
        playListInputField.sendKeys(newPlaylistName);
        playListInputField.sendKeys(Keys.ENTER);
        System.out.println("New playlist name " + newPlaylistName + " is entered");
    }
    public String playlistNameChangeNotify(){
        return findElementVisible(successNotify).getText();
    }
//    public boolean doesPlaylistExist(String NewPlaylistName){
//        return findElementVisible(isPlaylist).isDisplayed();
//    }
    public boolean doesPlaylistExist(String NewPlaylistName) throws Exception {
        try {
            Thread.sleep(2000);
            if (driver.findElement(By.xpath("//a[text()='" + NewPlaylistName + "']")).isDisplayed()) {
                System.out.println("Playlist is being displayed");
                return true;
            }
        } catch (Exception e) {
            System.out.println("Exception encountered/ Playlist is NOT displayed");
            return false;
        }
        System.out.println("null");
        return false;
    }
}
