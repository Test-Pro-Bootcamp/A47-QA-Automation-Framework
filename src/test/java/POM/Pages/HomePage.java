package POM.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    @FindBy(css = "#playlists > ul > li:nth-child(3) > a")
    private WebElement playlistSelection;
    @FindBy(css = "#playlists > ul > li:nth-child(3) > nav > ul > li:nth-child(1)")
    private WebElement editSelection;
    @FindBy(css = "[name='name']")
    protected WebElement editField;
    @FindBy(css = "div.show.success")
    private WebElement messageBox;
    @FindBy(css = "img.avatar")
    private WebElement avatarIcon;
    @FindBy(css = ".del.btn-delete-playlist")
    private WebElement deletePlaylist;
    @FindBy(css = "#playlists > h1 > i")
    private WebElement newPlaylist;
    @FindBy(css = "#playlists > nav > ul > li:nth-child(1)")
    private WebElement selectNewPlaylist;
    @FindBy(css = ".ok")
    private WebElement okDeleteButton;

    public WebElement avatar(){
        return findElement(avatarIcon);
    }

    public HomePage clickFirstPlaylist(){
        findElement(playlistSelection);
        click(playlistSelection);
        return this;
    }
    public HomePage contextPlaylist(){
        findElement(playlistSelection);
        contextClick(playlistSelection);
        return this;
    }
    public HomePage selectEdit(){
        findElement(editSelection);
        click(editSelection);
        return this;
    }
    public HomePage editName(String name){
        findElement(editField);
        editField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        editField.sendKeys(name);
        editField.sendKeys(Keys.ENTER);
        return this;
    }
    public HomePage clickDeleteButton(){
        waitToClick(deletePlaylist);
        click(deletePlaylist);
        return this;
    }
    public HomePage createPlaylist(){
    findElement(newPlaylist);
    click(newPlaylist);
    return this;
    }
    public HomePage newPlaylistSelection(){
        findElement(selectNewPlaylist);
        click(selectNewPlaylist);
        return this;
    }
    public HomePage enterNewPlaylistName(String name){
        findElement(editField);
        editField.sendKeys(name);
        editField.sendKeys(Keys.ENTER);
        return this;
    }
    public WebElement areYouSureBox(){
        return findElement(okDeleteButton);

    }
    public String verificationMessage(){
        return findElement(messageBox).getText();
    }

    public WebElement displayMessage(){
          return findElement(messageBox);
    }
}
