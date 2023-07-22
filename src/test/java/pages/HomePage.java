package pages;

import io.cucumber.java.en.Then;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver){ super(givenDriver); }

    public HomePage verifyLogin(){ Assert.assertTrue(getAvatar().isDisplayed()); return this; }

}
