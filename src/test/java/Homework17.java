import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.Message;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Homework17 {
    @Test

    public void addSongToPlaylist() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);

        WebElement emailInput = driver.findElement(By.cssSelector("input[type='email']"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("art1234@mail.com");

        WebElement passwordInput = driver.findElement(By.cssSelector("Password"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("te$t$tudent");

        WebElement submitLogin = driver.findElement(By.cssSelector("submit"));
        submitLogin.click();



            WebElement searchFiled = driver.findElement(By.cssSelector("Press F to search"));
            searchFiled.sendKeys("Dee Yan-Key");

            WebElement viweAll = driver.findElement(By.cssSelector("view-all-songs-btn"));
            viweAll.click();

            WebElement firstSong = driver.findElement(By.cssSelector("td.track-number text-secondary"));
            firstSong.click();

            WebElement addSong = driver.findElement(By.cssSelector("Add selected songs to…"));
            addSong.click();

            WebElement choosePlaylist = driver.findElement(By.cssSelector("section[id='songResultsWrapper'] li[class='favorites']"));
            choosePlaylist.click();


            WebElement messageT = driver.findElement(By.cssSelector("section[id='songResultsWrapper'] li[class='favorites']"));
            Assert.assertEquals(messageT.getText(), "Added 1 song into {favorites}");


            driver.quit();

        }
    }


