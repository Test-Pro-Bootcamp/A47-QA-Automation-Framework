import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.*;

public class Homework19 extends BaseTest{

    @Test
    public void deletePlaylist() throws InterruptedException{

        BaseTest.openLoginUrl(url);
        BaseTest.enterEmail(userEmail);
        BaseTest.enterPassword(userPassword);
        BaseTest.clickSubmitButton();
        findAndOpenAPlaylist();
        clickDeletePlaylistButton();
        confirmPlaylistDeletedMessage();


    }

///////////////////////////////////////////////////////////////////////////////////////////////////////
    String url = "https://qa.koel.app/";
    String userEmail = "barrau89@gmail.com";
    String userPassword = "te$t$tudent";

///////////////////////////////////////////////////////////////////////////////////////////////////////

    private void findAndOpenAPlaylist() {
        WebElement playlist = driver.findElement(By.cssSelector("#playlists > ul > li:nth-child(4)"));
        playlist.click();
            }

    private void clickDeletePlaylistButton() {
        WebElement deleteButton = driver.findElement(By.cssSelector("#playlistWrapper > header > div.song-list-controls > span > button"));
        deleteButton.click();
    }

    private String confirmPlaylistDeletedMessage() {
        String deletedPlaylistConfirmation = "Deleted playlist";
        WebElement playlistDeletedMessage = driver.findElement(By.cssSelector("div.success.show"));
        return playlistDeletedMessage.getText();
    }

}