package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    By playlist = By.cssSelector("a[href='#!/playlist/65758']");

    By playlistNameField = By.cssSelector("[name = 'name']");


    public void doubleClickPlaylist (){
        doubleClick(playlist);
    }
    public void enterNewPlaylistName (String playlistName){
        findElement(playlistNameField).sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.BACK_SPACE));
        findElement(playlistNameField).sendKeys(playlistName);
        findElement(playlistNameField).sendKeys(Keys.RETURN);

    }





}
