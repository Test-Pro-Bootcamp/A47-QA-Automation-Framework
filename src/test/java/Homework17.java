import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

public class Homework17 extends BaseTest {

    static String url = "https://qa.koel.app/";
    String userPassword = "te$t$tudent";
    String userEmail= "barrau89@gmail.com";

    @Test
    public void addSongToPlaylist () {

        //  Open Koel Website
        BaseTest.openLoginUrl(url);

        // Log-in to Koel
        BaseTest.enterEmail(userEmail);
        BaseTest.enterPassword(userPassword);
        BaseTest.clickSubmitButton();


        // Search for a Song
        // Click view all to display the search results
        // Click the first song in the search results
        // Click 'Add to'
        // Choose the playlist to add it to
        // Verify that the notification message appears
        // Verify that notification message has the text, "Added 1 song into {your playlist}"



    }








}
