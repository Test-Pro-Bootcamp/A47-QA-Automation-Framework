import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
public void playSong() throws InterruptedException {
//       navigateToPage();
        provideEmail("erika.olsen@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        clickPlay();
        Assert.assertTrue(isSongPlaying());
    }

public void clickPlay() throws InterruptedException {
    Thread.sleep(1000);    
    
    Actions actions3 = new Actions(driver);
    WebElement elementToHover = driver.findElement(By.xpath("//*[@title= 'Play or resume' and @data-testid='play-btn']"));
    WebElement elementToClick = driver.findElement(By.xpath("//*[@title='Play or resume' and @data-testid= 'play-btn']"));

    actions3.moveToElement(elementToHover).perform();
    elementToClick.click();
    

    WebElement playNextButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@data-testid='play-next-btn']")));
    WebElement playButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-testid='play-btn']")));

    
    playNextButton.click();
    playButton.click();
}
public boolean isSongPlaying() throws InterruptedException {
        Thread.sleep(5000);
    WebElement soundbar = driver.findElement(By.xpath("//div[@data-testid= 'sound-bar-play']"));
    return soundbar.isDisplayed();
}
}