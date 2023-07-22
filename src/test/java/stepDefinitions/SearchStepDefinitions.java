package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.SearchResultsPage;

public class SearchStepDefinitions {
    @When("I type into the searchbar the song title {string}")
    public void searchViaSearchBar(String song){
        BasePage basePage = new BasePage(BaseDefinitions.getThreadLocal());
        basePage.searchViaSearchBar(song);
    }
    @Then("I should see the search results and orange 'View All' button")
    public void confirmResultsFound() {
        SearchResultsPage searchResultsPage = new SearchResultsPage(BaseDefinitions.getThreadLocal());
        searchResultsPage.confirmResultsFound();
    }
    @And("I click the View All button")
    public void clickViewAllBtn() {
        SearchResultsPage searchResultsPage = new SearchResultsPage(BaseDefinitions.getThreadLocal());
        searchResultsPage.clickViewAll();
    }
    @And("I click the song on row {int}")
    public void selectSongByRow(int x) {
        SearchResultsPage searchResultsPage = new SearchResultsPage(BaseDefinitions.getThreadLocal());
        searchResultsPage.selectSong(x);
    }
    @And("I click the Add To button")
    public void clickAddToBtn() {
        SearchResultsPage searchResultsPage = new SearchResultsPage(BaseDefinitions.getThreadLocal());
        searchResultsPage.clickAddTo();
    }
    @And("I add the song to the list in row {int}")
    public void iAddTheSongToTheListInRow(int x) {
        SearchResultsPage searchResultsPage = new SearchResultsPage(BaseDefinitions.getThreadLocal());
        searchResultsPage.selectAList(x);
    }

    @Then("the song playing matches the song selected above")
    public void theSongPlayingMatchesTheSongSelectedAbove() {
        SearchResultsPage searchResultsPage = new SearchResultsPage(BaseDefinitions.getThreadLocal());
        searchResultsPage.confirmSongTopQueued();
    }
}
