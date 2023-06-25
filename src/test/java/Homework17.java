import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() {
        openLoginUrl();
        enterEmail("demo@class.com");
        enterPassword("te$t$tudent");
        clickSubmit();
        searchForSong("Dark Days");
        viewAllSongs();
        verifySearchUrl();
        selectFirstSearchResult();
        clickAddToButton();
        choosePlaylist();
        verifyPlaylistMessage();


        //finds View All button
        WebElement viewAllSongs = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAllSongs.click();
        //finds first result in the View All list
        WebElement firstResult = driver.findElement(By.xpath("//tr[@class='song-item']//td[contains(text(), \"Dark Days\")]"));
        firstResult.click();

        //clicks the 'Add to' button
        WebElement addTo = driver.findElement(By.xpath("//button[@class='btn-add-to']"));
        addTo.click();

    }

    private void verifyPlaylistMessage() {
        WebElement addedToPlaylistMessageText = driver.findElement(By.xpath());
    }

    private void choosePlaylist() {
        WebElement testPlaylist = driver.findElement(By.xpath("//li[contains(text(),'test')]"));
        testPlaylist.click();

        //verifies the addition of the song to the playlist
        WebElement addedToPlaylistMessage = driver.findElement(By.xpath("//div[@class='alertify-logs top right']"));
        Assert.assertTrue(addedToPlaylistMessage.isDisplayed());
    }

    private void clickAddToButton() {
        WebElement addTo = driver.findElement(By.xpath("//button[@class='btn-add-to']"));
        addTo.click();
    }

    private void selectFirstSearchResult() {
        WebElement firstResult = driver.findElement(By.xpath("//*[@id=\"searchExcerptsWrapper\"]/div/div/section[1]/ul/article[1]/span[2]/span[1]"));
        firstResult.click();
    }

    private void viewAllSongs() {
        WebElement viewAllSongs = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAllSongs.click();
    }

    private void verifySearchUrl() {
        WebElement songResultsWrapper = driver.findElement(By.xpath("//section[@id='songResultsWrapper']"));
        Assert.assertTrue(songResultsWrapper.isDisplayed());
    }

    private void searchForSong(String song) {
        WebElement searchField = driver.findElement(By.cssSelector("[name='q']"));
        searchField.click();
        searchField.clear();
        searchField.sendKeys(song);
    }
}
