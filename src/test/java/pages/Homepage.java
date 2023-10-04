package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Homepage extends BasePage {

    public boolean isAvatarDisplayed;

    public Homepage(WebDriver givenDriver) {
        super(givenDriver);
    }

    By firstPlaylist = By.cssSelector(".playlist:nth-child(3)");
    By playlistNameField = By.cssSelector("[name='randy']");
    By renamePlaylistSuccessMsg = By.cssSelector("div.success.show");


    public void doubleClickPlaylist() {
        doubleClick(firstPlaylist);
    }
public void enterNewPlaylistName(String playlistName) {
findElement(playlistNameField).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.BACK_SPACE ));
findElement(playlistNameField).sendKeys(playlistName);
findElement(playlistNameField).sendKeys(Keys.ENTER);
}

public String getRenamePlaylistSuccessMsg() {
        return findElement(renamePlaylistSuccessMsg).getText();
}


}


