import org.testng.Assert;
import org.testng.annotations.Test;
public class Homework18 extends BaseTest{

    @Test
    public void playSongTest throws InterruptedException{
        //Put the email field inside the web page
        enterEmail("dulcealergica@yahoo.com");
        // Put the password inside the web app
        enterPassword("te$t$tudent");
        //Click on the submit button
        clickSubmit();

        Thread.sleep(5000);

        clickPlay();
        Assert.assertTrue(isSongPlaying());
    }
}





