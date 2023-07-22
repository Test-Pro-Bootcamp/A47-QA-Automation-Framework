package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    public HomePage(WebDriver givenDriver) {

        super(givenDriver);
    }
    @FindBy(xpath ="//img[@class='avatar']")
    private WebElement avatarIcon;


     @FindBy(xpath = "//*[@id='sidebar']/section[1]/ul/li[3]/a")
     private WebElement allSongsList;

     @FindBy (xpath =" //span[@class='play']")
     public WebElement playBtn;

     @FindBy (xpath = "[//button[@data-test='view-all-songs-btn']")
     private WebElement viewAllBtn;

    @FindBy (xpath = "//span[@class='name']")
    private WebElement changeProfileBtn;

     @FindBy (css ="[.playlist:nth-child(3)]")
     private WebElement firstPlaylist;

     @FindBy (css="[name='name']")
     private WebElement editPlaylistNameField;

     @FindBy (xpath ="[//section[@id='songResultsWrapper']")
     private WebElement songResultsWrapper;

     @FindBy(css = "[type='search']")
     private WebElement searchField;

     @FindBy(xpath = "//button[@class='del btn-delete-playlist']")
     private WebElement deletePlaylistBtn;

     @FindBy(xpath = "//button[@class='ok']")
     private WebElement confirmDeleteBtn;

    public WebElement getAvatarIcon() {

       waitForOverlayElement(avatarIcon);
       return avatarIcon;
    }

    public HomePage clickViewAllBtn() {
        waitForOverlayElement(viewAllBtn);
            viewAllBtn.click();
            return this;
        }
    public HomePage choosePlaylist() {
        waitForOverlayElement(firstPlaylist);
        firstPlaylist.click();
        return this;
    }

    public HomePage chooseAllSongsList() {
      waitForOverlay(overlayLocator);
      waitForOverlayElement(allSongsList);
        allSongsList.click();
        return this;
    }


        public HomePage searchForSong(String song){
       waitForOverlayElement(searchField);
            searchField.click();
            searchField.clear();
            searchField.sendKeys(song);
            return this;

        }
    public HomePage editPlaylistName(String playListName) {
        waitForOverlayElement(editPlaylistNameField);
        editPlaylistNameField.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        editPlaylistNameField.sendKeys(playListName);
        editPlaylistNameField.sendKeys(Keys.ENTER);
        return this;
    }



    public HomePage doubleClickChoosePlaylist() {
        waitForOverlayElement(firstPlaylist);
        actions.doubleClick(firstPlaylist).click().perform();
        return this;
    }
    public void rightClickPlaylist () {

        actions.contextClick(firstPlaylist).click().perform();
    }
    public HomePage clickDeleteBtn() {
        waitForOverlayElement(deletePlaylistBtn);
        deletePlaylistBtn.click();
        waitForOverlayElement(confirmDeleteBtn);
        confirmDeleteBtn.click();
        return this;
    }

    public HomePage openPlaylist() {
        waitForOverlayElement(firstPlaylist);
        firstPlaylist.click();
        return this;
    }
    public HomePage clickProfileBtn(){
        waitForOverlayElement(changeProfileBtn);
        changeProfileBtn.click();
        return this;
    }

    }
