import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


public class HomeWork23 extends BaseTest{

    @Test
    public void renamePlaylist () {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);



        loginPage.loginUrl();
        loginPage.provideEmail("beomseo.park@testpro.io").providePassword("te$t$tudent").clickSubmit();
        homePage.doubleClickPlaylist();
        homePage.enterNewPlaylistName("66");
        String newPlaylistName = "Updated playlist";
        Assert.assertTrue(doesPlaylistExist().contains(newPlaylistName));

    }
    public  String doesPlaylistExist() {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return playlistElement.getText();
    }
}
