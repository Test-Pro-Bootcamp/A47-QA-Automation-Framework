import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework18 extends BaseTest {

    @Test
    public static void playSong() {

        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        // log into Koel
        login("henry.carter@testpro.io", "password");

        // activate the song list
        clickCssButtonDelay("a[href='#!/songs']", 1000);

        // select a song
        // #songsWrapper > div > div > div.item-container > table > tr:nth-child(1)
        // //*[@id="songsWrapper"]/div/div/div[1]/table/tr[1]
        clickXpathButtonDelay("//*[@id=\"songsWrapper\"]/div/div/div[1]/table/tr[1]", 1000);

        // activate the play/resume button
        clickXpathButtonAction("//span[@title='Play or resume']");

        Assert.assertTrue(getCssIsDisplayed("[data-testid = 'sound-bar-play']"));
    }
}
