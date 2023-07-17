import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collection;
public class HomeWork17 extends BaseTest {

 @Test

 public static void addSongToPlayList () throws InterruptedException  {
   String newSongAdded = "Added 1 song";

   //Open the webpage
     openLoginUrl();
   //Input Email
     enterEmail("beomseo.park@testpro.io");
   //Input Password
     enterPassword("te$t$tudent");
   //Click Submit
     clickSubmit();

    searchSong("Dark Days");
    clickViewAllBtn();
    selectFirstSong();
    clickAddToBtn();
    choosePlayList();

    //Checking test
     Assert.assertTrue(getNotificationText().contains(newSongAdded));


 }

 }


