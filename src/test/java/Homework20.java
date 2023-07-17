import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework20 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
        String deletedPlaylistMsg = "Deleted playlist";
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        openPlaylist();
        clickDeletePlaylistBtn();
        confirmDelete();

        Assert.assertTrue(getDeletePlaylistMsg().contains(deletedPlaylistMsg));
    }

    public void openPlaylist() {
        WebElement emptyPlaylist = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        emptyPlaylist.click();
    }

    public void clickDeletePlaylistBtn() throws InterruptedException {
        WebElement deletePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-delete-playlist")));
       // WebElement deletePlaylist = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        deletePlaylist.click();
       // Thread.sleep(2000);
    }

    public void confirmDelete() {
        WebElement confirmBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.ok")));
        // WebElement confirmBtn = driver.findElement(By.cssSelector("button.ok"));
        confirmBtn.click();
    }
    public String getDeletePlaylistMsg() {
        WebElement notificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
       // WebElement notificationMsg = driver.findElement(By.cssSelector("div.success.show"));
        return notificationMsg.getText();
    }
}
