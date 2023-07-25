package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    private By avatarIcon = By.cssSelector("img.avatar");
    private By firstPlaylist = By.cssSelector("#playlists > ul > li:nth-child(3) > a");
    private By editSelection = By.cssSelector("#playlists > ul > li:nth-child(3) > nav > ul > li:nth-child(1)");
    private By nameField = By.cssSelector("[name='name']");
    private By verification = By.cssSelector("div.show.success");

    public WebElement avatar(){
        return findElement(avatarIcon);
    }
    public void selectPlaylist(){
        contextClick(firstPlaylist);
    }
    public void enterName(String name){
        findElement(editSelection).click();
        findElement(nameField).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.BACK_SPACE));
        findElement(nameField).sendKeys(name);
        findElement(nameField).sendKeys(Keys.ENTER);
    }
    public String verificationMessage(){
        return findElement(verification).getText();

    }
}
