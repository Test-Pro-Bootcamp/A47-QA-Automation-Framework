import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class homework21 extends BaseTest {
//    Actions actions= null;
   String newPlaylistName = "Test Pro Edited Playlist2";
   @Test
    public void renamePlaylist() {

       provideEmail("demo@class.com");
       providePassword("te$t$tudent");
       clickSubmit();
       doubleClickPlaylist();
       enterNewPlaylistName();
       Assert.assertTrue(doesPlaylistExist());
    }
    public void doubleClickPlaylist(){
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));

       actions.doubleClick(playlistElement).perform();
    }
    public void enterNewPlaylistName(){
       WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
       //playlistInputField.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.BACK_SPACE));
        playlistInputField.sendKeys(Keys.chord(Keys.COMMAND,"a",Keys.BACK_SPACE));//keys.command and a to select all for Mac
       playlistInputField.sendKeys(newPlaylistName);
       playlistInputField.sendKeys(Keys.ENTER);
    }
    public boolean doesPlaylistExist() {
       WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='"+newPlaylistName+"']")));
       //changed to By.xpath
       return playlistElement.isDisplayed();
    }
}
