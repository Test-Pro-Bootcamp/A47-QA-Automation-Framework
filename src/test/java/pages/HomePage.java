package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver givenDriver) {

        super(givenDriver);
    }
    @FindBy(xpath ="[//img[@class='avatar']")
    private WebElement avatarIcon;
     @FindBy( xpath ="[//a[@class='songs']")
     private WebElement allSongsList;

     @FindBy (css ="[data-testid='play-btn]")
     private WebElement playBtn;

     @FindBy (xpath = "[//button[@data-test='view-all-songs-btn']")
     private WebElement viewAllBtn;

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

       return avatarIcon;
    }

        public void clickViewAllBtn() {
            waitForOverlay();
            viewAllBtn.click();

        }
    public void choosePlaylist() {

        firstPlaylist.click();
    }

    public void chooseAllSongsList() {
       waitForOverlay();
        allSongsList.click();
    }


        public void searchForSong(String song){
        waitForOverlay();
            searchField.click();
            searchField.clear();
            searchField.sendKeys(song);

        }
    public void editPlaylistName(String playListName) {
        editPlaylistNameField.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        editPlaylistNameField.sendKeys(playListName);
        editPlaylistNameField.sendKeys(Keys.ENTER);
    }



    public HomePage doubleClickChoosePlaylist() {

        actions.doubleClick(firstPlaylist).click().perform();
        return this;
    }
    public HomePage rightClickPlaylist () {

        actions.contextClick(firstPlaylist).click().perform();
    }
    public HomePage clickDeleteBtn() {
        deletePlaylistBtn.click();

        confirmDeleteBtn.click();
        return this;
    }
    public String getDeletionText(){

        return confirmationMessage.getText();
    }

    public HomePage openPlaylist() {

        firstPlaylist.click();
        return this;
    }
    public WebElement hoverOverPlayBtn () {
       hoverAction((By) playBtn);
       return playBtn;

    }

    }
