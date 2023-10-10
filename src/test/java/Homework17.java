import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;

// ...

@Test
public void addSongToPlaylist() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String expectedUrl = "https://qa.koel.app/";
        driver.get(expectedUrl);

        //i am skipping the login part because its redundant
        //starting from searching
        driver.findElement(By.xpath("//*[@id="searchForm"]/input")).sendKeys("Episode 2");
        driver.findElement(By.xpath("//*[@id="searchExcerptsWrapper"]/div/div/section[1]/h1/button")).click();
        driver.findElement(By.xpath("//*[@id="songResultsWrapper"]/div/div/div[1]/table/tr/td[1]")).click();

        WebElement addToButton = driver.findElement(By.xpath("///*[@id="songResultsWrapper"]/header/div[3]/span/button[2]"));
        addToButton.click();

        driver.findElement(By.xpath("//*[@id="songResultsWrapper"]/header/div[3]/div/section[1]/ul/li[4]")).click();

        // Verify the notification message
        WebElement notification = driver.findElement(By.className("notification"));
        String actualMessage = notification.getText();
        String expectedMessage = "Added 1 song into Favorites";
        Assert.assertEquals(expectedMessage, actualMessage);
        }
