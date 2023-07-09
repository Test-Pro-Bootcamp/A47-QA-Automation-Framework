import org.testng.annotations.Test;
import org.openqa.selenium.chrome.*;

public class Homework_18 extends  BaseTest{
    @Test
    public void playSong() {

        //  Open Koel Website
        BaseTest.openLoginUrl(url);
        // Log-in to Koel
        BaseTest.enterEmail(userEmail);
        BaseTest.enterPassword(userPassword);
        BaseTest.clickSubmitButton();
        // Search for a Song
//        findSong("Dark Days");

    }

    String url = "https://qa.koel.app/";
    String userEmail= "barrau89@gmail.com";
    String userPassword = "te$t$tudent";
}
