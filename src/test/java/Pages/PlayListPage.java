package Pages;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
public class PlayListPage extends BasePage {
    public PlayListPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //locators: Create a new playlist
    By plusIconLocator = By.cssSelector("i.fa.fa-plus-circle.create");
    By newSimplePlaylistLocator = By.cssSelector("li[data-testid='playlist-context-menu-create-simple']");
    By playlistNameFieldLocator = By.cssSelector("input[name='name']");
    By newPlaylistMsgLocator = By.xpath
            ("//div[@class='alertify-logs top right']//div[@class='success show']");
    By newPlaylistLocator = By.xpath("//li[@class='playlist playlist']//a[@class='active']");

    // Locators: Delete a Playlist
    By deletePlaylistBtnLocator = By.cssSelector("button[title='Delete this playlist']");
    // By deletePlaylistBtnLocator = By.xpath("//button[@class='del btn-delete-playlist']");
    By deletePlaylistOKLocator = By.cssSelector("button.ok");
    By deleteNotifyLocator = By.cssSelector("div.success.show");

    // Rename Playlist Locators
    By playlistLocator = By.cssSelector(".playlist:nth-child(3)");
    By editMenuContextClickLocator = By.xpath("//*[@id='playlists']/ul/li[3]/nav/ul/li[1]");
    By playListInputFieldLocator = By.cssSelector("[name='name']");
    By playlistNameChangeMsgLocator = By.cssSelector("div.success.show");
            // By playlistLocator= By.xpath("//section[@id='playlists']//li[@class='playlist playlist'] /a");
            // editMenuContextClick= (By.cssSelector
            //                      ("nav.menu.playlist-item-menu li[data-testid='playlist-context-menu-edit-63429']")));
            //  editMenuContextClick= (By.xpath
            //          ("//nav[@class='menu playlist-item-menu']//li[data-testid='playlist-context-menu-edit-63429']")));

    // Play song Locators - using context click
    By allSongsListLocator = By.cssSelector("li a.songs");
    By firstSongLocator = By.cssSelector(".all-songs tr.song-item:nth-child(1)");
    By playOptionLocator = By.cssSelector("li.playback");

    // Delete Song from playlist Locators
    By selectSongLocator = By.cssSelector
            ("div[class='song-list-wrap main-scroll-wrap playlist'] td[class='title']");
    //By selectSong = By.cssSelector("section#songResultsWrapper tr.song-item td.title");



    //Create a new playlist
    //-------------------------
    public void createNewPlaylist(String Playlist) throws InterruptedException {
        waitForOverlayToVanish();
        WebElement plusIconElement = findElementPresence(plusIconLocator);
        Thread.sleep(2000);
        plusIconElement.click();
        //
        WebElement newSimplePlaylistMenuElement = findElementClickable(newSimplePlaylistLocator);
        newSimplePlaylistMenuElement.click();
        //
        WebElement playlistNameField = findElementVisible(playlistNameFieldLocator);
        playlistNameField.sendKeys(Playlist);
        playlistNameField.sendKeys(Keys.ENTER);
        System.out.println("Playlist " + Playlist + " is created");
    }
    public String newPlaylistNotification() {
        WebElement newPlaylistMsg = findElementPresence(newPlaylistMsgLocator);
        String NewMsgText = newPlaylistMsg.getText();
        System.out.println("Msg Notification: " + NewMsgText);
        return NewMsgText;
    }
    public boolean newPlaylistIsDisplayed() {
        WebElement newPlaylist = findElementPresence(newPlaylistLocator);
        boolean isDisplayed = newPlaylist.isDisplayed();
        System.out.println("Playlist is displayed = " + isDisplayed);
        return isDisplayed;
    }
    // Delete empty Playlist
    //-------------------------
    public void selectDeletePlaylist(String newPlaylistName) {
        selectPlaylistByName(newPlaylistName);
        deletePlaylist();
    }
    // Delete Playlist that has songs
    //-------------------------
    public void selectDeletePlaylistWithSong(String Playlist) {
        selectPlaylistByName(Playlist);
        deletePlaylistWithSong();
    }
    public void selectPlaylistByName(String Playlist) {
        waitForOverlayToVanish();
        String selectedPlaylistLocator = "//section[@id='playlists']//a[contains(text(),'" + Playlist + "')]";
        WebElement selectedPlaylistElement = findElementClickable
                (By.xpath(selectedPlaylistLocator));
        selectedPlaylistElement.click();
        System.out.println("Playlist " + Playlist + " has been selected");
    }
    public void deletePlaylist() {
        waitForOverlayToVanish();
        WebElement deletePlaylistBtnElement = findElementClickable(deletePlaylistBtnLocator);
        deletePlaylistBtnElement.click();
        System.out.println("Playlist has been deleted");
    }
    public void deletePlaylistWithSong() {
        waitForOverlayToVanish();
        findElementClickable(deletePlaylistBtnLocator).click();
        findElementClickable(deletePlaylistOKLocator).click();
        System.out.println("Playlist has been deleted");
    }

    public String deletedPlaylistNotify() {
        WebElement notificationElement = findElementVisible(deleteNotifyLocator);
        String notifyText = notificationElement.getText();
        System.out.println("Message is: " + notifyText);
        return notifyText;
    }

//    public boolean isPlaylistDeleted(String Playlist){
////          WebElement  deletedPlaylist = findElementPresence
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
       //return Boolean.parseBoolean(null); // Boolean.parseBoolean(null) is always false
    }

// Rename Playlist
//-------------------------
    public void doubleClickPlaylist (String Playlist) {
        waitForOverlayToVanish();
        WebElement choosePlaylistElement = findElementVisible(playlistLocator);
        actions.doubleClick(choosePlaylistElement).perform();
        System.out.println("Playlist " + Playlist + " is double clicked");
    }
    public void contextClickPlaylist (String Playlist){
        waitForOverlayToVanish();
        WebElement choosePlaylistElement = findElementClickable(playlistLocator);
        actions.contextClick(choosePlaylistElement).perform();
        System.out.println("Playlist " + Playlist + " is right/context clicked");
    }
    public void clickEditMenu (){
        findElementClickable (editMenuContextClickLocator).click();
        System.out.println("Edit is clicked");
    }
    public void enterNewPlaylistName (String newPlaylistName) {
        WebElement playListInputField = findElementVisible (playListInputFieldLocator);
        playListInputField.sendKeys(Keys.chord(Keys.COMMAND, "A"));
        playListInputField.sendKeys(Keys.DELETE);
        playListInputField.sendKeys(newPlaylistName);
        playListInputField.sendKeys(Keys.ENTER);
        System.out.println("New playlist name " + newPlaylistName + " is entered");
    }
    public String playlistNameChangeNotify(){
        return findElementPresence(playlistNameChangeMsgLocator).getText();
    }
    public boolean doesPlaylistExist(String NewPlaylistName){
        return findElementPresence(By.xpath("//a[text()='" + NewPlaylistName + "']" )).isDisplayed();
    }
    // Play song using context click
    public void chooseAllSongsList() {
        waitForOverlayToVanish();
        findElementClickable(allSongsListLocator).click();
    }
    public void contextClickFirstSong() {
        WebElement firstSongElement = findElementVisible(firstSongLocator);
        actions.contextClick(firstSongElement).perform();
    }
    public void choosePlayOption() {
        WebElement playOptionElement = findElementVisible(playOptionLocator);
        actions.click(playOptionElement).perform();
    }

    // Delete Song From Playlist
    //--------------------------
    public void deleteSongFromPlaylist() {
        WebElement selectSong = findElementPresence(selectSongLocator);
        Actions actions = new Actions(driver);
        actions.moveToElement(selectSong).click().sendKeys(Keys.DELETE).perform();
        System.out.println("Song is deleted");
    }
    public String delSongNotificationMsg() {
        WebElement notificationElement = findElementVisible(deleteNotifyLocator);
        String msgText1 = notificationElement.getText();
        System.out.println("Message is: " + msgText1);
        return msgText1;
    }
}
