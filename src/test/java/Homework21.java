import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {
    @Test (dataProvider = "CorrectLoginProviders", dataProviderClass = BaseTest.class)
    public void renamePlaylist (String email, String password) throws InterruptedException {

        String editedPlaylistNameMessage = "Updated playlist";
        //get url
        //login email
        enterEmail(email);
        //login password
        enterPassword(password);
        //click submit
        clickSubmit();
        //choose playlist
        choosePlaylist();
        // edit the Playlist Name
        editPlaylistName();
        getChangesText();

        // verifies that the Deletion Message contains the deletion text.
        Assert.assertTrue((getChangesText().contains(editedPlaylistNameMessage)));
    }



    public void editPlaylistName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        WebElement editNameField = driver.findElement(By.cssSelector("[name='name']"));
        editNameField.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        editNameField.sendKeys("Test Playlist");
        editNameField.sendKeys(Keys.ENTER);
    }

    public void choosePlaylist() {
        WebElement openedPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
        action.doubleClick(openedPlaylist).click().perform();

    }


    public String getChangesText() {
        WebElement renamePlaylistConfirm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alertify-logs top right']")));
        return renamePlaylistConfirm.getText();


    }

}



