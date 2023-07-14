import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework21 extends BaseTest{
    public static WebDriverWait wait = null;
    public static Actions actions=null;
    String newPlaylistName="Test Pro Edited Playlist2";
    @Test
public void renamePlayList(){
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        actions=new Actions(driver);
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        doubleClickPlayList();
        enterNewPlayListName();
        Assert.assertTrue(doesPlayListExist());

    }
    public void doubleClickPlayList(){
        WebElement playListElement= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playListElement).perform();

    }
    public void enterNewPlayListName(){
        WebElement playListInputField=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playListInputField.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.BACK_SPACE));
        playListInputField.sendKeys(newPlaylistName);
        playListInputField.sendKeys(Keys.ENTER);

    }
    public boolean doesPlayListExist() {
        WebElement playListElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" + newPlaylistName + "']")));
return playListElement.isDisplayed();
    }



}
