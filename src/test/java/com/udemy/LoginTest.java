package com.udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    @Test(description = "Login Test")
    public void loginWithValidCredentials(){

        By profileInitialLocator = By.xpath("//span[@class='user-initials']");
        driver.get("https://www.udemy.com/");

        driver.manage().addCookie(cookie);

        driver.navigate().refresh();

        WebElement profileInitial = driver.findElement(profileInitialLocator);
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(profileInitial, "Test Testson")));
        Assert.assertEquals(profileInitial.getText(), "TT");

        driver.quit();
    }
}
