import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {
    @Test
    public void playSong() {
        navigateToPage();
        provideEmail("jasmynmedina1@gmail.com");
        providePassword("te$t$tudent");
        clickSubmit();
        playASong();
        Assert.assertTrue(soundBarIsDisplayed());
        Assert.assertTrue(pauseBtnIsDisplayed());
    }
}
