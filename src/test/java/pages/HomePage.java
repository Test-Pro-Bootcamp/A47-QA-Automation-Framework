package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    By playlist = By.cssSelector("a[href='#!/playlist/65758']");

    @FindBy(css = "[name='name']")
            WebElement playlistNameField;



    public void doubleClickPlaylist (){
        doubleClick(playlist);
    }
    public HomePage enterNewPlaylistName (String playlistName){
        playlistNameField.sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.BACK_SPACE));
        playlistNameField.sendKeys(playlistName);
        playlistNameField.sendKeys(Keys.RETURN);
        return this;

    }





}
