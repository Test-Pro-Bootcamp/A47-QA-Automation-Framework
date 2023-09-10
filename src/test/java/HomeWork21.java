import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class HomeWork21 extends BaseTest{
    String playlistName;

    public HomeWork21() {
        playlistName = "Hubba Bubba Jr";
    }

    @Test
        public void renamePlaylist() {

            provideEmail("courtney.matthews@testpro.io");
            providePassword("Walkonby08!!");
            clickSubmit();
            doubleClickPlaylist();
            enterNewPlaylistName();
            Assert.assertTrue(doesPlaylistExist());

        }

    public void doubleClickPlaylist() {
        WebElement HBPlaylist = wait.until(visibilityOfElementLocated(By.cssSelector("#playlists > ul > li:nth-child(3) > a")));
        actions.doubleClick(HBPlaylist).perform();
    }

    public void enterNewPlaylistName() {
            WebElement playlistInputField = wait.until(visibilityOfElementLocated(By.cssSelector("[name='name']")));
            playlistInputField.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.BACK_SPACE));
            playlistInputField.sendKeys(playlistName);
            playlistInputField.sendKeys(Keys.ENTER);
    }

    public boolean doesPlaylistExist(){
        WebElement playlistElement= wait.until(visibilityOfElementLocated(By.xpath("//a[text()='"+playlistName+"']")));
        return playlistElement.isDisplayed();
    }
}

