import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist () throws InterruptedException{



    openUrl();
    enterEmail("yana.kurenko@testpro.io");
    enterPassword("te$t$tudent");
    clickLoginButton();
    clickSearchfield("Dark Days");
    viewAllButton();

    clickOnFirstSong();
    clickOnAddToButton();
    clickOnPlaylist();


    Assert.assertTrue(lookForPopUpMessage().contains("Added 1 song into"));
    Thread.sleep(2000);



    }

    private void clickOnPlaylist() throws InterruptedException{
        WebElement choosePlaylist = driver.findElement(By.xpath("//*[@id='songResultsWrapper']/header/div[3]/div/section[1]/ul/li[5]"));
        choosePlaylist.click();
        Thread.sleep(2000);
    }

    private void clickOnAddToButton() throws InterruptedException{
        WebElement addToButton = driver.findElement(By.cssSelector("[class='btn-add-to']"));
        addToButton.click();
        Thread.sleep(2000);
    }

    private void clickOnFirstSong() throws InterruptedException{
        WebElement firstSong = driver.findElement(By.xpath("//*[@id=\"songResultsWrapper\"]/div/div/div[1]/table/tr[1]/td[2]"));
        firstSong.click();
        Thread.sleep(2000);

    }

    private void viewAllButton() throws InterruptedException {
        WebElement AllButton = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        AllButton.click();
        Thread.sleep(2000);

    }

    private void clickSearchfield(String songName) throws InterruptedException{
        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        searchField.click();
        searchField.clear();
        searchField.sendKeys(songName);
        Thread.sleep(2000);
    }

    public String lookForPopUpMessage() {
        WebElement popUpMessage = driver.findElement(By.cssSelector("div.success.show"));
        return  popUpMessage.getText();
    }


}


