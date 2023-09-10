import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
public void playSong() throws InterruptedException {
        navigateToPage();
        provideEmail("erika.olsen@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000);
        clickPlay();
        Assert.assertTrue(isSongPlaying());
        Thread.sleep(5000);
    }

public void clickPlay() {
    WebElement playNextButton = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
    WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));

    playNextButton.click();
    playButton.click();
}
public boolean isSongPlaying() {
    WebElement soundbar = driver.findElement(By.xpath("//div[@data-testid= 'sound-bar-play']"));
    return soundbar.isDisplayed();
}
}