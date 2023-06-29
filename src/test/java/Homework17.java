import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.*;
import org.openqa.selenium.*;


import java.time.Duration;

public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException{
        String newSongAddedNotificationText = "Added 1 song into";
        //open url
        openLoginUrl();
        //input email
        enterEmail("matt.pierce@testpro.io");
        //input password
        enterPassword("te$t$tudent");
        //click submit
        clickSubmit();

    //creates New Playlist
        createNewPlaylist();
        //search for song
        searchForSong("Dark Days");
        //click View All Btn
        clickViewAllBtn();//verify on search results page
        verifySearchUrl();
        //select the first song returned in the search
        selectFirstSongResult();
        //click Add To Btn
        clickAddToBtn();
        //choose Playlist to add the song to
        choosePlaylist();
        //checking for success message notification
        Assert.assertTrue((getNotificationText().contains(newSongAddedNotificationText)));


    }

    public String createNewPlaylist() throws InterruptedException {
            Random random = new Random();
            String namePlayList = "HW17-"+random.nextInt(99);
            WebElement createPlayListBtn = driver.findElement(By.xpath("//i[@data-testid='sidebar-create-playlist-btn']"));
            createPlayListBtn.click();
            Thread.sleep(3000);

            WebElement newPlaylistsBtn = driver.findElement(By.xpath("//*[@data-testid='playlist-context-menu-create-simple']"));
            newPlaylistsBtn.click();
            Thread.sleep(2000);

            WebElement inputForm = driver.findElement(By.xpath("//form[@name='create-simple-playlist-form']/input"));
            inputForm.sendKeys(namePlayList);
            inputForm.sendKeys(Keys.ENTER);
            Thread.sleep(3000);

            WebElement playlistCreated = driver.findElement(By.xpath("//a[contains(text(),'HW17')]"));
            playlistCreated.isDisplayed();
            return namePlayList;
    }

    public void choosePlaylist() throws InterruptedException{
        WebElement testPlaylist = driver.findElement(By.xpath("//li[contains(text(),'HW')]"));
        testPlaylist.click();
        Thread.sleep(5000);
    }

    public void clickAddToBtn() throws InterruptedException {
        WebElement addTo = driver.findElement(By.xpath("//button[@class='btn-add-to']"));
        addTo.click();
        Thread.sleep(5000);
    }

    public void selectFirstSongResult() throws InterruptedException{
        WebElement firstResult = driver.findElement(By.xpath("(//*[@id=\"songResultsWrapper\"]//tr[contains(@class,'song-item')])[1]"));
        firstResult.click();
        Thread.sleep(5000);
    }

    public void clickViewAllBtn() throws InterruptedException{
        WebElement viewAllBtn = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAllBtn.click();
        Thread.sleep(5000);
    }

    public void verifySearchUrl() throws InterruptedException {
        WebElement songResultsWrapper = driver.findElement(By.xpath("//section[@id='songResultsWrapper']"));
        Assert.assertTrue(songResultsWrapper.isDisplayed());
        Thread.sleep(5000);
    }

    public void searchForSong(String song) throws InterruptedException{
        WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.click();
        searchField.clear();
        searchField.sendKeys(song);
        Thread.sleep(5000);
    }
    public String getNotificationText () {
        WebElement notificationElement = driver.findElement(By.cssSelector("div.alertify-logs.top.right"));
        return notificationElement.getText();
    }
}
