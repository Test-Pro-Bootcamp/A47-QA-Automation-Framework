import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class homework18 extends BaseTest{
    @Test
    public void playSong() throws InterruptedException{

        openUrl();
        enterEmail("yana.kurenko@testpro.io");
        enterPassword("te$t$tudent");
        clickLoginButton();
        clickPlayNextSong();
        clickPlayButton();
        checkSoundBar();




    }

    private void checkSoundBar() throws InterruptedException{
        WebElement soundBar = driver.findElement(By.cssSelector("[data-testid='sound-bar-play']"));
        Assert.assertTrue(soundBar.isDisplayed());
        Thread.sleep(2000);
    }

    private void clickPlayButton() throws InterruptedException {
        WebElement playButton = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        playButton.click();
        Thread.sleep(4000);
    }

    private void clickPlayNextSong() throws InterruptedException{
        WebElement playNextSongButton = driver.findElement(By.cssSelector("[data-testid='play-next-btn']"));
        playNextSongButton.click();
        Thread.sleep(2000);
    }
}