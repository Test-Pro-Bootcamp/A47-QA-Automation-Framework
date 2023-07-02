import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork19 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {

        String deletedPlaylistMessage = "Deleted playlist \"" + "my playlist.\""; 
        
        enterEmail("yuliyakis85@gmail.com");
        enterPassword("te$t$tudent");
        clickSubmit();
        clickOnMyPlaylist();
        clickDeleteButton();
        getDeletedPlaylistMessage();
        Assert.assertTrue(getDeletedPlaylistMessage().contains(deletedPlaylistMessage));

    }
    private String getDeletedPlaylistMessage() {
        WebElement notificationMessage = driver.findElement(By.cssSelector("div.success.show"));
        return notificationMessage.getText();
    }

//    private void clickConfirmDeleteButton() {
//        WebElement confirmButton = driver.findElement(By.xpath("//button[@class='ok']"));
//        confirmButton.click();
//    }

    private void clickDeleteButton() throws InterruptedException {
        WebElement deleteButton = driver.findElement(By.cssSelector("[class='del btn-delete-playlist']"));
        deleteButton.click();
        Thread.sleep(1000);
    }

    private void clickOnMyPlaylist() {
        WebElement myPlaylist = driver.findElement(By.xpath("//section[@id='playlists']//a[contains(text(),'my playlist')]"));
        myPlaylist.click();
    }
}


