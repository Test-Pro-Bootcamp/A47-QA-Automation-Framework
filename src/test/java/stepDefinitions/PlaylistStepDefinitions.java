package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.HomePage;
import pages.PlaylistPage;
import pages.SearchResultsPage;

public class PlaylistStepDefinitions {
    @When("I click the Add Playlist button")
    public void clickAddPlaylistBtn(){
        HomePage homePage = new HomePage(BaseDefinitions.getThreadLocal());
        homePage.clickAddPlaylistBtn();
    }
    @When("I double-click the playlist on row {int}")
    public void doubleClickPlaylist(int x){
        HomePage homePage = new HomePage(BaseDefinitions.getThreadLocal());
        homePage.doubleClickPlaylist(x);
    }
    @And("I click the New Playlist button")
    public void clickNewPlaylistBtn(){
        HomePage homePage = new HomePage(BaseDefinitions.getThreadLocal());
        homePage.clickNewPlaylistBtn();
    }
    @And("I enter the new playlist name {string}")
    public void enterNewPlaylistName(String newPlaylistName){
        HomePage homePage = new HomePage(BaseDefinitions.getThreadLocal());
        homePage.enterPlaylistText(newPlaylistName);
    }
    @Then("I should see a green success message in the top right corner of the home page")
    public void verifyHPSuccessMsg(){
        HomePage homePage = new HomePage(BaseDefinitions.getThreadLocal());
        Assert.assertTrue(homePage.getSuccessMsg().isDisplayed());
    }
    @Then("I should see a green success message in the top right corner of the new playlist page")
    public void playlistPageSuccessMsg() {
        PlaylistPage playlistPage = new PlaylistPage(BaseDefinitions.getThreadLocal());
        Assert.assertTrue(playlistPage.getSuccessMsg().isDisplayed());
    }
    @And("I add the song to a new playlist by entering the name {string}")
    public void createNewPlaylistByAddingSong(String newPlaylistName) {
        SearchResultsPage searchResultsPage = new SearchResultsPage(BaseDefinitions.getThreadLocal());
        searchResultsPage.addToNewPlaylist(newPlaylistName);
    }
    @And("I click a playlist in the left tab {int}")
    public void iClickAPlaylistInTheLeftTab(int x) {
        HomePage homePage = new HomePage(BaseDefinitions.getThreadLocal());
        homePage.clickPlaylist(x);
    }
    @When("I click the Delete Playlist button on the Playlist Page")
    public void iClickTheDeletePlaylistButtonOnThePlaylistPage() {
        PlaylistPage playlistPage = new PlaylistPage(BaseDefinitions.getThreadLocal());
        playlistPage.clickDeletePlaylist();
    }
    @And("I right-click a playlist in the left tab {int}")
    public void iRightClickAPlaylistInTheLeftTab(int x) {
        HomePage homePage = new HomePage(BaseDefinitions.getThreadLocal());
        homePage.contextClickPlaylist(x);
    }
    @When("I click the Delete Playlist button on the Home Page")
    public void iClickTheDeletePlaylistButtonOnTheHomePage() {
        HomePage homePage = new HomePage(BaseDefinitions.getThreadLocal());
        homePage.clickDeletePlaylistBtn();
    }
}
