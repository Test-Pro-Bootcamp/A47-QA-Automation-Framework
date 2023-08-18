package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginStepDefinitions {
    private final BaseDefinitionsCommonSteps commonSteps;

    private final String url= "https://qa.koel.app/";

    public LoginStepDefinitions(BaseDefinitionsCommonSteps commonSteps) {
        this.commonSteps = commonSteps;
    }
    @When("I enter email {string}")
    public void i_enter_email(String email) {
        commonSteps.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']"))).sendKeys(email);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        commonSteps.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='password']"))).sendKeys(password);
    }

    @And("I submit")
    public void i_click_submit_btn() {
        commonSteps.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='submit']"))).click();
    }

    @Then("I am logged into a website")
    public void userLoggedIn() {
        Assert.assertTrue(commonSteps.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".avatar"))).isDisplayed());
    }

    @Then("I am not logged in")
    public void iAmNotLoggedIn() {
        Assert.assertEquals(commonSteps.driver.getCurrentUrl(), url);
    }

    @Given("I open Login page")
    public void iOpenLoginPage() {
        commonSteps.driver.get(url);
    }
}


