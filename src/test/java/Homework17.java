import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.time.Duration;


public class Homework17  extends BaseTest {

   @Test
  public void addSongToPlaylist() throws InterruptedException {

       String newSongAddedNotificationText = "Added 1 song into";

       navigateToPage();
       provideEmail("art1234@mail.com");
       providePassword("te$t$tudent");
       clickSubmit();
       searchSong("Pluto");
       clickViewAllBtn();
       selectFirstSongResult();
       clickAddToBtn();
       choosePlayList();
       Assert.assertTrue(getNotificationText().contains(newSongAddedNotificationText));

   }
   public void searchSong (String songTitleKeyword) {
   WebElement searchFiled = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#serchForm input[type=search]")));
   searchFiled.sendKeys(songTitleKeyword);
   }
   public void clickViewAllBtn () {
       WebElement viewAllSearchResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.results section.songs h1 button")));
       viewAllSearchResult.click();
   }
   public void selectFirstSongResult() {
       WebElement firstSongResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section#songResultsWrapper tr.song-item td.title")));
       firstSongResult.click();
   }
   public void clickAddToBtn() {
       WebElement addToBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn-add-to")));
       addToBtn.click();
   }
   public void choosePlayList() {
       WebElement playlistElement = driver.findElement(By.xpath("//section[@id = 'songResultsWrapper']//li[contains(text(),'Test Pro Playlist')]"));
       playlistElement.click();
      // Thread.sleep(2000);
   }
   public String getNotificationText(){
       WebElement notificationElement = driver.findElement(By.cssSelector("div.success.show"));
       return notificationElement.getText();
   }

}




