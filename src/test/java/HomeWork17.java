import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeWork17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException{
         String playlistName = "court playlist";


         provideEmail("courtney.matthews@testpro.io");
         providePassword("Walkonby08!!");
         clickSubmit();
         Thread.sleep(3000);

        WebElement search = driver.findElement(By.cssSelector("[type='search']"));
        search.sendKeys("Dark Days");

        WebElement viewAll = driver.findElement(By.cssSelector("div.results h1 > button"));
        viewAll.click();
        Thread.sleep(3000);

        WebElement firstSong = driver.findElement(By.cssSelector("section#songResultsWrapper td.title"));
        firstSong.click();
        Thread.sleep(3000);

        WebElement addButton = driver.findElement(By.cssSelector("section#songResultsWrapper button.btn-add-to"));
        addButton.click();
        Thread.sleep(3000);

        WebElement playlist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'court playlist')]"));
        playlist.click();

        WebElement notif = driver.findElement(By.cssSelector("div.success.show"));
        Assert.assertEquals(notif.getText(), "Added 1 song into \"court playlist.\"");
    }
} 