package com.udemy;

import org.testng.Assert;
import org.testng.annotations.Test;


public class RegistrationTest extends TestBase {

    @Test(description = "Registration with valid credential")
    public void registrationWithValidCredentials() {

        homePage.openHomePage();
        registrationPopup.openRegisterPopup();
        Assert.assertEquals(registrationPopup.checkRegisterHeader(), "Зарегистрируйтесь и начните обучение!");
        registrationPopup.enterName("Jacob");
        registrationPopup.enterEmail(utils.getEmailForRegistration());
        registrationPopup.enterPassword("Qwerty1234");
        registrationPopup.clickRegisterBtn();
        homePage.getProfileName();
        homePage.clickLogout();
    }
}