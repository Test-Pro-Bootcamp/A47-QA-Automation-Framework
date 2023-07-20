package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginStepDefinitions {
    WebDriver driver;
    WebDriverWait wait;
    @Before
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions cOptions = new ChromeOptions();
        cOptions.addArguments("--disable-notifications");
        cOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(cOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Given("I am in the Login Page")
    public void navigateToPage(){
        driver.get("https://qa.koel.app/");
    }
    @When("I enter email {string}")
    public void enterEmail(String email){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(email);
    }
    @And("I enter password {string}")
    public void enterPassword(String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPassword(password);
    }
    @And("I click the submit button")
    public void clickSubmit(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSubmit();
    }

    @Then("I am land on the Home Page and my user avatar is displayed")
    public void verifyHomePage(){
        HomePage homePage = new HomePage(driver);
        homePage.verifyLogin();
    }

    @After
    public void closeBrowser(){ driver.quit(); }
}
