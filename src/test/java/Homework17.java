import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 extends BaseTest {

    @Test
    public static void addSongToPlaylist() {

        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        setCssTextBox("input[type='email']", "henry.carter@testpro.io");
        setCssTextBox("input[type='password']", "password");

        clickCssButton("button[type='submit']");

        setCssTextBox("input[type='search']", "riqui-riqui");

        clickXpathButton("//*[@id=\"searchExcerptsWrapper\"]/div/div/section[1]/h1/button");
        clickXpathButton("//*[@id=\"songResultsWrapper\"]/div/div/div[1]/table/tr[1]");
        clickXpathButton("//*[@id=\"songResultsWrapper\"]/header/div[3]/span/button[2]");

        setXpathTextBox("//*[@id=\"songResultsWrapper\"]/header/div[3]/div/section[2]/form/input",
                "Henry's List 1");
        clickXpathButton("//*[@id=\"songResultsWrapper\"]/header/div[3]/div/section[2]/form/button");

        Assert.assertEquals(getCssText("div.success.show"),
                "Created playlist \"Henry's List 1.\"");
    }

    public static void setCssTextBox(String selector, String value) {
        WebElement field = driver.findElement(By.cssSelector(selector));
        field.clear();
        field.sendKeys(value);
    }
    public static void setXpathTextBox(String selector, String value) {
        WebElement field = driver.findElement(By.xpath(selector));
        field.clear();
        field.sendKeys(value);
    }

    public static void clickCssButton(String selector) {
        WebElement field = driver.findElement(By.cssSelector(selector));
        field.click();
    }
    public static void clickXpathButton(String selector) {
        WebElement field = driver.findElement(By.xpath(selector));
        field.click();
    }

    public static String getCssText(String selector) {
        WebElement field = driver.findElement(By.cssSelector(selector));
        return field.getText();
    }
}
