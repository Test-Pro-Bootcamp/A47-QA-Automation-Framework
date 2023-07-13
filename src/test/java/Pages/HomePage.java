package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

    public HomePage (WebDriver givenDriver) {

        super(givenDriver);
    }

    By avatarIcon = By.xpath("//img[@class='avatar']");

    public WebElement getAvatarIcon() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(avatarIcon));
    }
}
