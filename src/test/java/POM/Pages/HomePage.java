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
    private WebElement playlistSelection;
    @FindBy(css = "#playlists > ul > li:nth-child(3) > nav > li:nth-child(1)")
    private WebElement editSelection;
    @FindBy(css = "[name='name']")
    private WebElement editField;
    @FindBy(css = "div.show.success")
    private WebElement messageBox;
    @FindBy(css = "img.avatar")
    private WebElement avatarIcon;

    public WebElement avatar(){
        return findElement(avatarIcon);
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
    public HomePage verificationMessage(){
        findElement(messageBox).getText();
        return this;
    }
}
