import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.time.Duration;

public class Homework17 extends BaseTest {

    @Test

    public void AddSongToPlaylist () throws InterruptedException {


       String newSongAddedNotificationText = "Added 1 song into";
        // Open the URL for the web page on the Chrome Browser
        openLoginUrl();
        // Put the email field inside the web page
        enterEmail("andrea.guevara@testpro.io");
        // Put the password field inside the web page
        enterPassword("te$t$tudent");
        //click on the submit button
        clickSubmit();
        searchSong();
        setClickViewAll();
        setSelectFirstSong();
        addTo();
        choosePlayList();
        Assert.assertTrue(notification().contains(newSongAddedNotificationText));









    }



}
