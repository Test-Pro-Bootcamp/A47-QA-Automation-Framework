import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class Homework19 extends BaseTest {

    @Test
    @Parameters({"BaseURL"})
    public static void deletePlaylist(String baseURL) {

        driver.get(baseURL);
        Assert.assertEquals(driver.getCurrentUrl(), baseURL);

        // log into Koel
        login("henry.carter@testpro.io", "password");

        // activate the song list
        clickXpathButton("//*[@id='playlists']/ul/li[3]/a");

        // delete the playlist X Playlist
        clickXpathButton("//*[@id=\"playlistWrapper\"]/header/div[3]/span/button[2]");

        // select a song
        // #songsWrapper > div > div > div.item-container > table > tr:nth-child(1)
        // //*[@id="songsWrapper"]/div/div/div[1]/table/tr[1]
        // clickXpathButtonDelay("//*[@id=\"songsWrapper\"]/div/div/div[1]/table/tr[1]", 1000);

        // select the okay button
        clickXpathButtonAction("/html/body/div[3]/div/div/nav/button[2]");

        Assert.assertEquals(getCssText("div.alertify-logs.top.right"),
                "Deleted playlist \"To Delete.\"");
    }

    @Test
    @Parameters({"BaseURL"})
    public static void addSongToPlaylist(String baseURL) {

        driver.get(baseURL);
        Assert.assertEquals(driver.getCurrentUrl(), baseURL);

        setCssTextBox("input[type='email']", "henry.carter@testpro.io");
        setCssTextBox("input[type='password']", "password");

        clickCssButton("button[type='submit']");

        setCssTextBox("input[type='search']", "riqui-riqui");

        clickXpathButton("//*[@id=\"searchExcerptsWrapper\"]/div/div/section[1]/h1/button");
        clickXpathButton("//*[@id=\"songResultsWrapper\"]/div/div/div[1]/table/tr[1]");
        clickXpathButton("//*[@id=\"songResultsWrapper\"]/header/div[3]/span/button[2]");

        setXpathTextBox("//*[@id=\"songResultsWrapper\"]/header/div[3]/div/section[2]/form/input",
                "To Delete");
        clickXpathButton("//*[@id=\"songResultsWrapper\"]/header/div[3]/div/section[2]/form/button");

        Assert.assertEquals(getCssText("div.success.show"),
                "Created playlist \"To Delete.\"");
    }
}
