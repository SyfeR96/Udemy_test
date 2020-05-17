package com.udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class RegistrationTest extends TestBase {

    @Test(description = "Registration with valid credential")
    public void registrationWithValidCredentials() {
        By signUpBtnLocator = By.xpath(" //button[@data-purpose='header-signup']");
        By fullNameLocator = By.id("id_fullname");
        By emailFieldLocator = By.xpath("//input[@data-purpose='email']");
        By passFieldLocator = By.xpath("//input[@data-purpose='password']");
        By submitBtnLocator = By.id("submit-id-submit");
        By profileInitialLocator = By.xpath("//span[@class='user-initials']");

        driver.get("https://www.udemy.com/");

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();

        wait.until(ExpectedConditions.visibilityOfElementLocated(signUpBtnLocator));
        WebElement signUpBtn = driver.findElement(signUpBtnLocator);
        signUpBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(fullNameLocator));

        WebElement fullName = driver.findElement(fullNameLocator);
        fullName.sendKeys("Test Testson");
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailFieldLocator));

        WebElement emailField = driver.findElement(emailFieldLocator);
        emailField.sendKeys("newEmail"+ System.currentTimeMillis() + "@ukr.net");
        wait.until(ExpectedConditions.visibilityOfElementLocated(passFieldLocator));

        WebElement passField = driver.findElement(passFieldLocator);
        passField.sendKeys("Qwerty1234");

        wait.until(ExpectedConditions.elementToBeClickable(submitBtnLocator));
        WebElement submitBtn = driver.findElement(submitBtnLocator);
        submitBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(profileInitialLocator));

        WebElement profileInitial = driver.findElement(profileInitialLocator);
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(profileInitial, "BB")));
        Assert.assertEquals(profileInitial.getText(), "TT");
        
    }

    private void pause (int milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




}
