import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.*;

public class Homework19 extends BaseTest{

    @Test
    public void deletePlaylist() throws InterruptedException{

        BaseTest.openLoginUrl(url1);
        BaseTest.enterEmail(userEmail);
        BaseTest.enterPassword(userPassword);
        BaseTest.clickSubmitButton();


    }
///////////////////////////////////////////////////////////////////////////////////////////////////////
    String url1 = "https://qa.koel.app/";
    String userEmail = "barrau89@gmail.com";
    String userPassword = "te$t$tudent";

///////////////////////////////////////////////////////////////////////////////////////////////////////

    public void openPlaylist () {

    }

}
