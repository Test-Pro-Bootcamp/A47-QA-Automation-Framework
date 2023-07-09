import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.*;

public class Homework_18 extends BaseTest {
    @Test
    public void playSong() throws InterruptedException {

        BaseTest.openLoginUrl(url);
        BaseTest.enterEmail(userEmail);
        BaseTest.enterPassword(userPassword);
        BaseTest.clickSubmitButton();
        clickPlaySongButton();
        clickNextSongButton();
        Assert.assertTrue(songIsPlaying());

    }

    String url = "https://qa.koel.app/";
    String userEmail = "barrau89@gmail.com";
    String userPassword = "te$t$tudent";

    public void hoverOverElement (WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void clickPlaySongButton() throws InterruptedException {
        WebElement playButton = driver.findElement(By.cssSelector("#mainFooter > div.side.player-controls > span > span.play"));
        //WebElement playButton = driver.findElement(By.xpath("span[data-testid='play-btn']"));
        hoverOverElement(playButton);
        playButton.click();
    }

    public void clickNextSongButton() throws InterruptedException {
        WebElement nextSongButton = driver.findElement(By.cssSelector("#mainFooter > div.side.player-controls > i.next.fa.fa-step-forward.control"));
        //WebElement nextSongButton = driver.findElement(By.xpath("span[data-testid='play-next-btn']"));
        hoverOverElement(nextSongButton);
        nextSongButton.click();
    }


    public boolean songIsPlaying() throws InterruptedException {
        WebElement soundbar = driver.findElement(By.cssSelector("div[data-testid='sound-bar-play']"));
        return soundbar.isDisplayed();
    }


}
