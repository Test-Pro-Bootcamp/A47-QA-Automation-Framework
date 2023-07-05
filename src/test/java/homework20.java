import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class homework20 extends BaseTest{

    @Test (dataProvider = "LoginProviders")
    public void deletePlayList(String email, String password){
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
        clickOnPlaylist();
        findDeleteButton();
        successMessage();
    }

    private String successMessage() {
        WebElement notificationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationMessage.getText();
    }

    private void findDeleteButton() {
        WebElement deleteButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='del btn-delete-playlist']")));
        deleteButton.click();
    }

    private void clickOnPlaylist() {
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='playlists']/ul/li[5]/a")));
        playlist.click();
    }


}
