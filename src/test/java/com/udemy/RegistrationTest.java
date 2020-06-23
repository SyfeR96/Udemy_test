package com.udemy;

import com.udemy.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.udemy.testdata.UserData.newUser;

public class RegistrationTest extends TestBase {

    @Test(description = "Registration with valid credential")
    public void registrationWithValidCredentials() {

        homePage.openHomePage();
        registrationPopup.openRegisterPopup();
        Assert.assertEquals(registrationPopup.getRegisterHeader(), "Sign Up and Start Learning!");
        registrationPopup.enterName(newUser.getName());
        registrationPopup.enterEmail(newUser.getEmailForRegister());
        registrationPopup.enterPassword(newUser.getPassword());
        registrationPopup.clickRegisterBtn();
        homePage.openProfileMenu();
        homePage.clickLogout();
    //    Assert.assertEquals(homePage.checkLogoutAlert(), utils.getLogoutAlertText());

    }
}