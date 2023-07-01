import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
@Test
    public void deletePlaylist() throws InterruptedException {
    //get url
    //login email
    //login password
    //click submit
    //choose playlist
    // click delete that playlist
    clickDeleteBtn();
    //verification message for deleted playlist
    getDeletionText();
    }

    public String getDeletionText() {
        WebElement notifyElement = driver.findElement(By.cssSelector("div.alertify-logs.top.right"));
        return notifyElement.getText();
    }

    public void clickDeleteBtn() {
    }

}

