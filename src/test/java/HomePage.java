import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);

    }

    By firstPlaylist = By.cssSelector(".playlist:nth-child(3)");
    By playListNameField = By.cssSelector("[name='name']");
    public void doubleClickPlaylist() {
        doubleClick(firstPlaylist);
    }
    public void enterNewPlaylistName(String playListName){
        findElement(playListNameField).sendKeys(playListName);
        findElement(playListNameField).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.BACK_SPACE));
        findElement(playListNameField).sendKeys(playListName);
        findElement(playListNameField).sendKeys(Keys.ENTER);
    }
    public boolean doesPlaylistExist(String playlistName){
        By newPlaylist=By.xpath("//a[text()='"+playlistName+"']");
        return findElement(newPlaylist).isDisplayed();
    }

}

