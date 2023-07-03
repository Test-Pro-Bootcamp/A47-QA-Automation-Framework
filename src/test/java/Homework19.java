import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
@Test (dataProvider = "CorrectLoginProviders", dataProviderClass = BaseTest.class)
    public void deletePlaylist(String email, String password) throws InterruptedException {

    String deletedPlaylistMessage = "Deleted Playlist";
    //get url
    //login email
    enterEmail(email);
    //login password
    enterPassword(password);
    //click submit
    clickSubmit();
    //choose playlist
    openPlaylist();
    // click delete that playlist
    clickDeleteBtn();

    //gets deletion text
    getDeletionText();

    // verifies that the Deletion Message contains the deletion text.
    Assert.assertTrue((getDeletionText().contains(deletedPlaylistMessage)));
    }

    private void openPlaylist() throws InterruptedException{
    WebElement openedPlaylist = driver.findElement(By.xpath("//*[@id=\"playlists\"]/ul/li[3]/a"));
    openedPlaylist.click();
    Thread.sleep(5000);
    }


    public String getDeletionText() throws InterruptedException{
        WebElement deletePlaylist = driver.findElement(By.cssSelector("div.alertify-logs.top.right"));
        return deletePlaylist.getText();


    }

    public void clickDeleteBtn() throws InterruptedException{
    WebElement deletePlaylistBtn = driver.findElement(By.xpath("//button[@class='del btn-delete-playlist']"));
    deletePlaylistBtn.click();
    Thread.sleep(5000);
    }

}

