import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{

    @Test
    public void playSong() {
        //openLoginUrl(); = this method was added to the launchBrowser method
        enterEmail("trianasahlin@gmail.com");
        enterPassword("te$t$tudent");
        userLogin();
        clickNextSong();
        playNextSong();
        Assert.assertTrue(isSongPlaying());

    }


    public void userLogin() {
        WebElement submitLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
        submitLogin.click();

    }
    public void clickNextSong(){
        WebElement nextSong = driver.findElement(By.cssSelector("i.next.fa.fa-step-forward.control"));
        nextSong.click();

    }
    public void playNextSong() {
        WebElement playSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span > span.play")));
        playSong.click();
    }
    public boolean isSongPlaying() {
        WebElement soundBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div > button:nth-child(2) > div > img")));
        return soundBar.isDisplayed();
    }




}
