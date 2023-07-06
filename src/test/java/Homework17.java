import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist throws InterruptedException {

        String url = "https://qa.koel.app/";
        String userEmail= "barrau89@gmail.com";
        String userPassword = "te$t$tudent";

        findSong ("Dark Days");
        clickViewAllButton();
        selectFirstSongFromResult();
        clickAddToButton();
        findPlaylistToAddSong();


        //  Open Koel Website
        BaseTest.openLoginUrl(url);

        // Log-in to Koel
        BaseTest.enterEmail(userEmail);
        BaseTest.enterPassword(userPassword);
        BaseTest.clickSubmitButton();

        // Search for a Song
        public void findSong(String songTitle) throws InterruptedException {
            WebElement searchField = driver.findElement(By.cssSelector("#searchForm > input[type=search]"));
            searchField.sendKeys(songTitle);
            Thread.sleep(2500);
        }

        // Click view all to display the search results
        public void clickViewAllButton() throws InterruptedException {
            WebElement searchResults = driver.findElement(By.cssSelector("div.results section.songs h1 button"));
            searchResults.click();
            Thread.sleep(2500);
        }


        // Click the first song in the search results
        public void selectFirstSongFromResult() throws InterruptedException{
            WebElement firstSongfromResult = driver.findElement(By.cssSelector("section#songResultsWrapper tr.song-item td.title"));
            firstSongfromResult.click();
            Thread.sleep(2500);
        }


        // Click 'Add to'
        public void clickAddToButton() throws InterruptedException{
            WebElement addToButton = driver.findElement(By.cssSelector("button.btn-add-to"));
            addToButton.click();
            Thread.sleep(2500);
        }


        // Choose the playlist to add it to
        public void findPlaylistToAddSong() throws InterruptedException{
            WebElement paylist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'PostMan2')]"));
            Thread.sleep(2500);
        }


        // Verify that the notification message appears
        // Verify that notification message has the text, "Added 1 song into {your playlist}"
        String newSongNotification = "Added 1 song into";
        Assert.assertTrue(getNotificationtext().contains(newSongNotification));

    }


}
