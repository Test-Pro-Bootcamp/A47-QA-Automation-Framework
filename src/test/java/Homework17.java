import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
   public void searchSong (String songTitleKeyword) throws InterruptedException{
   WebElement searchFiled = driver.findElement(By.cssSelector("div#serchForm input[type=search]"));
   searchFiled.sendKeys(songTitleKeyword);
   Thread.sleep(2000);
   }
   public void clickViewAllBtn ()throws InterruptedException {
       WebElement viewAllSearchResult = driver.findElement(By.cssSelector("div.results section.songs h1 button"));
       viewAllSearchResult.click();
       Thread.sleep(2000);
   }
   public void selectFirstSongResult()throws InterruptedException{
       WebElement firstSongResult = driver.findElement(By.cssSelector("section#songResultsWrapper tr.song-item td.title"));
       firstSongResult.click();
       Thread.sleep(2000);
   }
   public void clickAddToBtn()throws InterruptedException{
       WebElement addToBtn = driver.findElement(By.cssSelector("button.btn-add-to"));
       addToBtn.click();
       Thread.sleep(2000);
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




