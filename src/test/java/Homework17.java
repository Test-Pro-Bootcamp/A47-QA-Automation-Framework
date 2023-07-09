import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collection;

public class Homework17 extends BaseTest {
   @Test
    public void addSongToPlaylist() throws InterruptedException {
       String newSongAddedNotificationText = "Added 1 song into";

       openLoginUrl();

       enterEmail();

       enterPassword();

       clickSubmit();

       searchSongInput();
       clickViewAllBtn();
       selectFirstSongResult();
       clickAddToBtn();
       choosePlaylist();
       getNotificationText();

       Assert.assertTrue(getNotificationText().contains(newSongAddedNotificationText));


    }


   }







