import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{
    @Test
    public void playSong() throws InterruptedException{
        openLoginLink();

//        Enter email into the email field
        enterEmailField("daviyontae.floyd@testpro.io");

//        Enter password into the password field
        enterPasswordField("te$t$tudent");

//        Click the Login button
        clickSubmit();

        clickPlayNext();

        clickPlay();
        Thread.sleep(5500);

//        Verify colorful soundbar is visible in the bottom left of the screen
        WebElement soundBar = driver.findElement(By.cssSelector("div.bars"));
        Assert.assertTrue(soundBar.isDisplayed());
    }

    public void clickPlayNext(){
        WebElement playNextBtn = driver.findElement(By.cssSelector("[title='Play next song']"));
        playNextBtn.click();
    }

    public void clickPlay(){
        WebElement playBtn = driver.findElement(By.cssSelector("span.play"));
        playBtn.click();
    }
}
