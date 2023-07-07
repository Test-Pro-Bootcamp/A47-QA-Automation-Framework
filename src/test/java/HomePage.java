import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    By avatarIcon = By.cssSelector("img.avatar");
    By firstPlaylist = By.cssSelector("#playlists > ul > li:nth-child(3) > a");
    By editSelection = By.cssSelector("#playlists > ul > li:nth-child(3) > nav > ul > li:nth-child(1)");
    By nameField = By.cssSelector("[name='name']");
    By verification = By.cssSelector("div.show.success");

    public WebElement avatar(){
        return findElement(avatarIcon);
    }
    void selectPlaylist(){
        contextClick(firstPlaylist);

    }
    void selectEdit(){
        findElement(editSelection).click();

    }
    void enterName(String name){
        findElement(nameField).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.BACK_SPACE));
        findElement(nameField).sendKeys(name);
        findElement(nameField).sendKeys(Keys.ENTER);
    }
    public String verificationMessage(){
        return findElement(verification).getText();

    }
}
