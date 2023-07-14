import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeWork21 extends BaseTest{
    String newPlaylistname;

    public HomeWork21() {
        newPlaylistname = "Hubba Bubba Jr";
    }

    @Test
        public void renamePlaylist() throws InterruptedException {

            provideEmail("courtney.matthews@testpro.io");
            providePassword("Walkonby08!!");
            clickSubmit();
            doubleClickPlaylist();
            enterNewPlaylistName();
            Assert.assertTrue(doesPlaylistExist());

        }

    public void doubleClickPlaylist() {
        WebElement HBPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists > ul > li:nth-child(3) > a")));
        actions.doubleClick(HBPlaylist).perform();
    }

    public void enterNewPlaylistName() {
            WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name'}")));
            playlistInputField.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.BACK_SPACE));
            playlistInputField.sendKeys(newPlaylistname);
            playlistInputField.sendKeys(Keys.ENTER);
    }

    public boolean doesPlaylistExist(){
        WebElement playlistElement= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='"+newPlaylistname+"']")));
        return playlistElement.isDisplayed();
    }
}

