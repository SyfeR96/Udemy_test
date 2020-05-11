package com.udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;


public class LoginTest {

    @Test(description = "Login with valid credential")
    public void loginWithValidCredentials() {
        File chromeDriver = new File("src/main/resources/chromedriver.exe");
        ChromeDriverService chromeService = new ChromeDriverService.Builder()
                .usingDriverExecutable(chromeDriver)
                .usingAnyFreePort()
                .build();
        WebDriver driver = new ChromeDriver(chromeService);


        driver.get("https://www.udemy.com/");
        pause(4000);

        WebElement loginPopUpBtn = driver.findElement(
                By.xpath(" //button[@data-purpose='header-signup']"));
        loginPopUpBtn.click();
        pause(5000);

        WebElement fullName = driver.findElement(By.id("id_fullname"));
        fullName.sendKeys("Test Testson");
        pause(1000);

        WebElement emailField = driver.findElement(By.xpath("//input[@data-purpose='email']"));
        emailField.sendKeys("franceska.mumina@andsee.org");
        pause(1000);

        WebElement passField = driver.findElement(By.xpath("//input[@data-purpose='password']"));
        passField.sendKeys("Qwerty1234");
        pause(1000);

        WebElement subBtn = driver.findElement(By.id("submit-id-submit"));
        subBtn.click();
        pause(5000);

        WebElement profileInitial = driver.findElement(By.xpath("//span[@class='user-initials']"));
        Assert.assertEquals(profileInitial.getText(), "TT");

        pause(5000);
        driver.quit();
    }

    private void pause (int milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




}
