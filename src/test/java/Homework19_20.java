import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19_20 extends BaseTest{
    @Test

    public void deletePlaylist ()  {
        String deletedPlayListMsg = "Deleted Playlist";

        provideEmail("erika.olsen@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        openPlaylist();
        clickDeletePlaylistBtn();
        String actualMsg = getDeletedPlaylistMsg();
        String expectedMsg = "Deleted playlist \"Test Pro Playlist.\"";
        Assert.assertEquals(actualMsg, expectedMsg);
    }

   public void openPlaylist() {
       WebElement clickTestProPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
       clickTestProPlaylist.click();
   }

   public void clickDeletePlaylistBtn()  {
        WebElement deletePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[title='Delete this playlist']")));
        deletePlaylist.click();

   }

   public String getDeletedPlaylistMsg() {
          WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
//          /html/body/div[2]/div
        return successMessage.getText();
   }



}
