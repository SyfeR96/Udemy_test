package com.udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    @Test(description = "Login Test")
    public void loginWithUsingCookie(){
        By signInBtnLocator = By.xpath("//button [@class='btn btn-quaternary']");
        By userProfileLocator = By.xpath("//*[@data-purpose='user-dropdown']");
        By userNameLocator = By.xpath("//*[@class='text-midnight ellipsis']");

        driver.get("https://www.udemy.com/");


        wait.until(ExpectedConditions.visibilityOfElementLocated(signInBtnLocator));
        WebElement signInBtn = driver.findElement(signInBtnLocator);
        Assert.assertEquals(signInBtn.getText(), "Войти");

        driver.manage().addCookie(cookie);
        driver.navigate().refresh();


        wait.until(ExpectedConditions.elementToBeClickable(userProfileLocator));
        Actions builder = new Actions(driver);
        WebElement userProfile = driver.findElement(userProfileLocator);
        builder.moveToElement(userProfile).build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameLocator));
        WebElement userName = driver.findElement(userNameLocator);
        Assert.assertEquals(userName.getText(), "Test Testson");

    }
}
