package POM.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SongsPage extends BasePage{

    @FindBy(css = "")
    protected WebElement songsPage;
    public SongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

}
