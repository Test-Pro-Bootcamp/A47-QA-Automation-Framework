public class homework18 extends BaseTest {
<<<<<<< Updated upstream
}
=======
    @Test
    public void playSong() {

        //open URL
        navigateToPage();

        //login
        provideEmail("alexandra.ward@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();

        //click play next song
        clickPlayNextSong();

        //click play or resume
        clickPlay();

        //verify song is playing
        Assert.assertTrue(verifySoundBar());

        //quit the browser
        driver.quit();


    }
}
>>>>>>> Stashed changes
