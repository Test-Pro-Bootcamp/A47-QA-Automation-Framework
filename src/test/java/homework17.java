import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //open URL
        String url = "https://qa.koel.app/";
        driver.get(url);

        //login with valid credentials
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys("alexandra.ward@testpro.io");

        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");

        WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']"));
        loginButton.click();

        //search for a song (any song)
        WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.click();
        searchField.sendKeys("song");

        //click view all to display search results
        WebElement viewAll = driver.findElement(By.xpath("//*[@id=\"searchExcerptsWrapper\"]/div/div/section[1]/h1/button"));
        viewAll.click();

        //click first song in search results
        WebElement firstSong = driver.findElement(By.xpath("//*[@id=\"songResultsWrapper\"]/div/div/div[1]/table/tr/td[2]"));
        firstSong.click();

        //click add to...
        WebElement addTo = driver.findElement(By.xpath("//*[@id=\"songResultsWrapper\"]/header/div[3]/span/button[2]"));
        addTo.click();

       // add song to playlist
        WebElement automatedPlaylist = driver.findElement(By.xpath("//*[@id=\"songResultsWrapper\"]/header/div[3]/div/section[1]/ul/li[7]"));
        automatedPlaylist.click();

        //verify notification message appears
        WebElement successBanner = driver.findElement(By.cssSelector("[class='success show']"));


        //verify notification message contains text "added 1 song into {playlist name}"
        String bannerMessage = "Added 1 song into Automated Playlisttt";

        //quit the browser
        driver.quit();



    }
}