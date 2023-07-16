import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {

    String newSongAddedNotificationText = "Added 1 song into";
    openLoginUrl();
    enterEmail("demo@class.com");
    enterPassword("te$t$tudent");
    clickSubmit();
    searchASong("that_");
    clickViewAll();
    selectFirstSongResult();
    clickAddToBtn();
    choosePlaylist();
    Assert.assertTrue(getNotificationText().contains(newSongAddedNotificationText));

    }
}