package com.udemy;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {

    @Test(description = "Registration with valid credential")
    public void registrationWithValidCredentials() {

        homePage.openHomePage();
        registrationPopup.openRegisterPopup();
        Assert.assertEquals(registrationPopup.getRegisterHeader(), "Sign Up and Start Learning!");
        registrationPopup.enterName(utils.getName());
        registrationPopup.enterEmail(utils.getEmailForRegistration());
        registrationPopup.enterPassword(utils.getPassword());
        registrationPopup.clickRegisterBtn();
        homePage.openProfileMenu();
        homePage.clickLogout();
    }
}