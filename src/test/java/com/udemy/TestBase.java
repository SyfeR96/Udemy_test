package com.udemy;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;

public class TestBase {

    WebDriver driver;
    WebDriverWait wait;
    Cookie cookie;

    @BeforeMethod(description = "Open Browser")
    public void openBrowser() {

        File chromeDriver = new File("src/main/resources/chromedriver.exe");

        ChromeDriverService chromeService = new ChromeDriverService.Builder()
                .usingDriverExecutable(chromeDriver)
                .usingAnyFreePort()
                .build();

        cookie = new Cookie.Builder("dj_session_id", "ccmgxmwoxtysnxstjxyvzb3mcygkcc5y")
                .domain("www.udemy.com")
                .path("/")
                .build();

        driver = new ChromeDriver(chromeService);
        wait = new WebDriverWait(driver, 10);
    }

    @AfterMethod(description = "Close Browser")
    public void closeBrowser() {
        driver.quit();
    }


}
