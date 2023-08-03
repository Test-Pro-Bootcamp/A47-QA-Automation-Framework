import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;


public class LoginSteps {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @After
    public void closeBrowser () {
        {driver.quit();}
    }
    @Given ("I open Login page")
    public void openLoginPage () {
            driver.get("https://qa.koel.app/");
        };
        @When ("I enter email {string}")
        public void iEnterEmail (String email) {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.provideEmail(email);
        };

        @And("I enter password {string}")
        public void iEnterPassword (String password) {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.providePassword(password);
        };
        @And("I click Submit")
    public void iClickSubmitBtn()  {
            LoginPage loginPage = new LoginPage(driver);
        };
        @Then("I am logged in")
        public void userIsLoggedIn () {
            HomePage homePage = new HomePage(driver);
            homePage.getAvatarIcon();
        }
    }
