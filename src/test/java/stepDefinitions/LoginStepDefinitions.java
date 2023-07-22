package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;

public class LoginStepDefinitions{
    @Given("I am on the Login Page")
    public void openLoginPage(){ BaseDefinitions.getThreadLocal().get("https://qa.koel.app/"); }
    @When("I enter email {string}")
    public void enterEmail(String email){
        LoginPage loginPage = new LoginPage(BaseDefinitions.getThreadLocal());
        loginPage.enterEmail(email);
    }
    @And("I enter password {string}")
    public void enterPassword(String password){
        LoginPage loginPage = new LoginPage(BaseDefinitions.getThreadLocal());
        loginPage.enterPassword(password);
    }
    @And("I click the submit button")
    public void clickSubmit(){
        LoginPage loginPage = new LoginPage(BaseDefinitions.getThreadLocal());
        loginPage.clickSubmit();
    }
    @Then("I am logged in and my user avatar should be displayed")
    public void verifyLogin(){
        HomePage homePage = new HomePage(BaseDefinitions.getThreadLocal());
        homePage.verifyLogin();
    }
    @Then("my login is rejected and I am still on the Login Page")
    public void verifyUserNotLoggedIn(){
        LoginPage loginPage = new LoginPage(BaseDefinitions.getThreadLocal());
        loginPage.verifyUserNotLoggedIn();
    }
    @Given("I am logged in and my user avatar is displayed")
    public void logIn(){
        LoginPage loginPage = new LoginPage(BaseDefinitions.getThreadLocal());
        BaseDefinitions.getThreadLocal().get("https://qa.koel.app/");
        loginPage.login("daviyontae.floyd@testpro.io", "te$t$tudent");
    }
}
