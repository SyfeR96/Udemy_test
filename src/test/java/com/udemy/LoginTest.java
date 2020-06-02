package com.udemy;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    @Test(description = "Login Test")
    public void loginWithUsingCookie() {
        homePage.openHomePage();
        Assert.assertEquals(loginPopup.checkLogInBtn(), "Log In");

        driver.manage().addCookie(cookie);
        driver.navigate().refresh();

        homePage.getProfileName();

        Assert.assertEquals(loginPopup.checkUserName(), "Jason");
        homePage.clickLogout();
    }
}
