package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.LoginPage;

public class SongsTestsStepsDefinitions {
    private final BaseDefinitionsCommonSteps commonSteps;
//    private final String url= "https://qa.koel.app/";


    public SongsTestsStepsDefinitions(BaseDefinitionsCommonSteps commonSteps){
        this.commonSteps = commonSteps;
    }

        @When("I click AllSongs menu")
        public void clickAllSongs() {
            commonSteps.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();
        }

        @And("I double click first song")
        public void doubleClickFirstSong() {
            WebElement playListElement = commonSteps.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("//tr[@class='song-item playing']//td[@class='title']")));
            commonSteps.actions.doubleClick(playListElement).perform();
        }

        @Then("Song is playing")
        public void songIsPlaying() {
            commonSteps.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='pause-btn']"))).isDisplayed();
        }


    @And("I click first song")
    public void iClickFirstSong() {
        commonSteps.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@class='song-item selected']//td[@class='title']"))).click();
    }

    @And("I choose add too")
    public void iChooseAddToo() {
        commonSteps.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn-add-to']"))).click();
    }

    @And("I choose Playlist")
    public void iChoosePlaylist() {
        commonSteps.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".existing-playlists li:nth-child(7)"))).click();
    }

    @Then("song was added to playlist")
    public void songWasAddedToPlaylist() {
        WebElement songAdded = commonSteps.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='success show']")));
                Assert.assertTrue(songAdded.isDisplayed());
    }
}


