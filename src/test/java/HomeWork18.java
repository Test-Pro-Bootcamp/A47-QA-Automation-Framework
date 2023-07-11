import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HomeWork18 extends BaseTest {

    @Test
    public void playSong () throws InterruptedException {


        provideEmail("courtney.matthews@testpro.io");
        providePassword("Walkonby08!!");
        clickSubmit();
        Thread.sleep(2000);

        WebElement search = driver.findElement(By.cssSelector("[type='search']"));
        search.sendKeys("Dark Days");
        Thread.sleep(2000);

        WebElement play = driver.findElement(By.cssSelector("#searchExcerptsWrapper > div > div > section.songs > ul > article:nth-child(1) > span.cover"));
        play.click();
        Thread.sleep(2000);
    }
}
