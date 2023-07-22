package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.UserProfilePage;

public class AccountStepDefinitions {
    @And("I click my username in the top right corner")
    public void clickUsername(){
        HomePage homePage = new HomePage(BaseDefinitions.getThreadLocal());
        homePage.clickUsername();
    }
    @And("I enter my current password {string}")
    public void iEnterMyCurrentPassword(String password) {
        UserProfilePage userProfilePage = new UserProfilePage(BaseDefinitions.getThreadLocal());
        userProfilePage.enterCurrentPasswordText(password);
    }
    @And("I enter a new username {string}")
    public void iEnterANewUsername(String username) {
        UserProfilePage userProfilePage = new UserProfilePage(BaseDefinitions.getThreadLocal());
        userProfilePage.enterUsernameText(username);
    }
    @When("I click the Save button")
    public void iClickTheSaveButton() {
        UserProfilePage userProfilePage = new UserProfilePage(BaseDefinitions.getThreadLocal());
        userProfilePage.clickSave();
    }
    @Then("the username I entered should match the username displayed {string}")
    public void theUsernameIEnteredShouldMatchTheUsernameDisplayed(String username) {
        HomePage homePage = new HomePage(BaseDefinitions.getThreadLocal());
        Assert.assertEquals(homePage.getUsername().getText(), username);
    }
}
