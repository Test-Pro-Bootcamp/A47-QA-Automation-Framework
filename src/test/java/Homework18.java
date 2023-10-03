import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test

    public void playSong() {
      provideEmail("randy.davila@testpro.io");
      providePassword("te$t$tudent");
      clickSubmit();
      clickPlay();
        Assert.assertTrue(isSongPlaying());
    }

public void clickPlay() {
    WebElement playNextButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@data-testid='play-next-btn']")));
    WebElement playButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-testid='play-btn']")));

    playNextButton.click();
    playButton.click();
}

public boolean isSongPlaying(){
 WebElement soundBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='sound-bar-play']")));
 return soundBar.isDisplayed();
}

}
