package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HomePage extends BasePage {

    public HomePage(WebDriver givenDriver) {

        super(givenDriver);
    }

        private void clickViewAllBtn() {
            WebElement viewAllBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-test='view-all-songs-btn']")));
            viewAllBtn.click();

        }

        private void verifySearchUrl () {
            WebElement songResultsWrapper = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='songResultsWrapper']")));
            Assert.assertTrue(songResultsWrapper.isDisplayed());
        }

        private void searchForSong (String song){
            WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='search']")));
            searchField.click();
            searchField.clear();
            searchField.sendKeys(song);

        }

    }
