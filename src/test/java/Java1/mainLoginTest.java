package Java1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class mainLoginTest {

    @Test
    public void verifyLogin() {
        System.setProperty("webdriver.chrome.driver","/Users/lusinedilbaryan/Downloads/chromedriver_mac64.zip");
        WebDriver driver=new ChromeDriver();

       // login LGPage = new login(driver);

        LoginPage2 LGPage = new LoginPage2(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa.koel.app/");
        LGPage.setEmailAdd("art1234@mail.com");
        LGPage.setPasswordAdd("te$t$tudent");
        LGPage.clickLoginBtn();

        if (driver.getPageSource().contains("Hey, student!")){
            System.out.println("Your login Success");
        }
        else {
            System.out.println("Your Login Failed");
        }
        driver.close();
    }
}
