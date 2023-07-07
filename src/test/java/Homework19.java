import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{

 @Test
    public void deletePlaylist() {

            provideEmail("art1234@mail.com");
            providePassword("te$t$tudent");
            clickSubmit();
            openPlaylist();
            clickDeletePlaylistBtn();
            confirmDelete();
             navigationToPage();

          Assert.assertTrue(getDeletedPlaylistMsg().contains("deletedPlaylistMsg"));
        }
    public void navigationToPage(){driver.get(url);
    }

    public static void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }
    public static void providePassword(String password){
        WebElement passwordField= driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public static void clickSubmit(){
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();
    }
}
