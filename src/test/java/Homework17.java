import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException{

        openLoginUrl();

        enterEmail("angel.ayala@testpro.io");
        enterPassword("school!sc0");
        clickSubmit();
        searchSong("song");
        viewAllBtn();
        firstSongSelection();
        addSongBtn();
        selectPlaylist();
        notificationMessage();

        Assert.assertTrue(notificationMessage().contains("Added 1 song"));
    }

    public String notificationMessage(){
        WebElement verification = driver.findElement(By.cssSelector("div.success.show"));
        return verification.getText();
    }
    public void selectPlaylist() throws InterruptedException{
        WebElement playlist = driver.findElement(By.cssSelector("#songResultsWrapper > header > div.song-list-controls > div > section.existing-playlists > ul > li:nth-child(19)"));
        playlist.click();
        Thread.sleep(2000);
    }
    public void addSongBtn() throws InterruptedException{
        WebElement addTo = driver.findElement(By.cssSelector(".btn-add-to"));
        addTo.click();
        Thread.sleep(2000);
    }
    public void firstSongSelection() throws InterruptedException{
        WebElement songSelect = driver.findElement(By.cssSelector("section#songResultsWrapper tr td.title"));
        songSelect.click();
        Thread.sleep(2000);
    }
    public void viewAllBtn() throws InterruptedException{
        WebElement viewAll = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewAll.click();
        Thread.sleep(3000);
    }

}
