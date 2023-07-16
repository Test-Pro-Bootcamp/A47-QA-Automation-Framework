import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;


import java.time.Duration;

import java.time.Duration;

public class WeisTest extends BaseTest{

    @Test
    public void OpenWeisWebPage() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Open the URL for the web page on the Chrome browser
        String url = "https://weismarkets.com/";
        driver.get(url);
        WebElement cookieOkButton = driver.findElement(By.cssSelector(".cookieinfo-close"));
        cookieOkButton.click();

        WebElement loginButton = driver.findElement(By.cssSelector(".user-login-signup"));
        loginButton.click();

        WebElement secondLoginButton = driver.findElement(By.cssSelector(".btn-link"));
        secondLoginButton.click();

        WebElement thirdLoginButton = driver.findElement(By.cssSelector(".mct-tabs-list__tab--active"));
        thirdLoginButton.click();
    }
//class=cookieinfo-close
    //class=btn-link
    //.mct-tabs-list__tab mct-tabs-list__tab--medium mct-tabs-list__tab--active

}





