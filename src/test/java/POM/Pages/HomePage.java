package POM.Pages;

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
    @FindBy
}
