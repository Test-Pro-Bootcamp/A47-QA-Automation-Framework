import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework21 extends BaseTest{
    String newPlaylistName = "Updated playlist";
    @Test
    public void renamePlaylist() {
        //enterEmail("trianasahlin@gmail.com");
        //enterPassword("te$t$tudent");
        //userLogin();
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
        rightClickPlaylist();
        changePlaylistInputField();
        Assert.assertTrue(doesPlaylistExist().contains(newPlaylistName));
       


    }

    public void userLogin() {
        WebElement submitLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
        submitLogin.click();

    }
    public void rightClickPlaylist() {
        WebElement choosePlayList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(choosePlayList).perform();

    }
    public void changePlaylistInputField(){
        WebElement playListInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playListInputField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        playListInputField.sendKeys("NewPlaylistName");
        playListInputField.sendKeys(Keys.ENTER);
    }

    public String doesPlaylistExist() {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return playlistElement.getText();
    }



}


