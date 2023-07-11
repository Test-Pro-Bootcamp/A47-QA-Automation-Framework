import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork19 extends BaseTest {

    @Test
    public void deletePlaylist() throws InterruptedException {


        provideEmail("courtney.matthews@testpro.io");
        providePassword("Walkonby08!!");
        clickSubmit();
        Thread.sleep(2000);

        WebElement playList = driver.findElement(By.cssSelector("#playlists > ul > li:nth-child(4) > a"));
        playList.click();
        Thread.sleep(2000);

        WebElement deletePlaylist = driver.findElement(By.cssSelector("#playlistWrapper > header > div.song-list-controls > span > button.del.btn-delete-playlist"));
        deletePlaylist.click();
        Thread.sleep(2000);

        WebElement okButton = driver.findElement(By.cssSelector("body > div.alertify > div > div > nav > button.ok"));
        okButton.click();
        Thread.sleep(2000);

        WebElement notifDeletion = driver.findElement(By.cssSelector("body > div.alertify-logs.top.right"));
        Assert.assertEquals(notifDeletion.getText(), "Deleted playlist \"court playlist.\"");
    }
}
