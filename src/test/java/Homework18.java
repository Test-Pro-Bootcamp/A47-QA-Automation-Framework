import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{

    @Test
    public void playSong() throws InterruptedException{
        openLoginUrl();
        enterEmail("trianasahlin@gmail.com");
        enterPassword("te$t$tudent");
        userLogin();
        clickNextSong();
        playNextSong();
        Assert.assertTrue(isSongPlaying());

    }


    public void userLogin() throws InterruptedException{
        WebElement submitLogin = driver.findElement(By.xpath("//button[@type='submit']"));
        submitLogin.click();
        Thread.sleep(2000);
    }
    public void clickNextSong() throws InterruptedException{
        WebElement nextSong = driver.findElement(By.cssSelector("i.next.fa.fa-step-forward.control"));
        nextSong.click();
        Thread.sleep(2000);
    }
    public void playNextSong() throws InterruptedException{
        WebElement playSong = driver.findElement(By.cssSelector("span > span.play"));
        playSong.click();
        Thread.sleep(2000);
    }
    private boolean isSongPlaying() {
        WebElement soundBar = driver.findElement(By.cssSelector("div > button:nth-child(2) > div > img"));
        return soundBar.isDisplayed();
    }




}
