package POM.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    @FindBy(css = "#playlists > ul > li:nth-child(3) > a")
    protected WebElement playlistSelection;
    @FindBy(css = "#playlists > ul > li:nth-child(3) > nav > li:nth-child(1)")
    protected WebElement editSelection;
    @FindBy(css = "[name='name']")
    protected WebElement editField;
    @FindBy(css = "div.show.success")
    protected WebElement messageBox;
    @FindBy(css = "img.avatar")
    protected WebElement avatarIcon;
    @FindBy(css = ".btn-delete-playlist")
    protected WebElement deletePlaylist;
    @FindBy(css = "#playlists > h1 > i")
    protected WebElement newPlaylist;
    @FindBy(css = "#playlists > nav > ul > li:nth-child(1)")
    protected WebElement selectNewPlaylist;

    public WebElement avatar(){
        return findElement(avatarIcon);
    }

    public HomePage selectFirstPlaylist(){
        findElement(playlistSelection);
        click(playlistSelection);
        return this;
    }
    public HomePage selectPlaylist(){
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
    public HomePage clickDeletePlaylist(){
        findElement(deletePlaylist);
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
    public String verificationMessage(){
        return findElement(messageBox).getText();
    }
}
