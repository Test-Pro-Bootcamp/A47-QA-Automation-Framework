package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.AllSongsPage;
import pages.HomePage;

public class PlaybackStepDefinitions {
    @And("I click the Play button located at the bottom of the screen")
    public void clickPlayBottomScrn(){
        HomePage homePage = new HomePage(BaseDefinitions.getThreadLocal());
        homePage.moveToPlayBtn().click();
    }
    @When("I hover over the Play button at the bottom of the screen, it should now display the Pause symbol")
    public void iHoverOverThePlayButtonItShouldNowDisplayThePauseSymbol() {
        HomePage homePage = new HomePage(BaseDefinitions.getThreadLocal());
        Assert.assertTrue(homePage.moveToPauseBtn().isDisplayed());
    }
    @And("I click the All Songs button in the left tab")
    public void iClickTheAllSongsButtonInTheLeftTab() {
        HomePage homePage = new HomePage(BaseDefinitions.getThreadLocal());
        homePage.clickAllSongs();
    }
    @And("I right-click a song in the list {int}")
    public void iRightClickASongInTheList(int x) {
        AllSongsPage allSongsPage = new AllSongsPage(BaseDefinitions.getThreadLocal());
        allSongsPage.contextClickSong(x);
    }

    @Then("I click the Playback button")
    public void clickThePlaybackButton() {
        AllSongsPage allSongsPage = new AllSongsPage(BaseDefinitions.getThreadLocal());
        allSongsPage.clickPlayback();
    }
}
