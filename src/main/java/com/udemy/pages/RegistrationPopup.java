package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPopup {

    private WebDriver driver;
    private WebDriverWait wait;

    public RegistrationPopup(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    By registerBtnLocator = By.xpath("//*[@data-purpose='header-signup' or @class='udlite-btn udlite-btn-small udlite-btn-primary udlite-heading-sm']");
    By signUpHeaderLocator = By.xpath("//*[@class=' loginbox-v4__header loginbox-v4__header--signup']");
    By nameFieldLocator = By.id("id_fullname");
    By randomEmailLocator = By.xpath("//*[@type='email']");
    By passwordFieldLocator = By.id("password");
    By signUpBtnLocator = By.id("submit-id-submit");



    public void openRegisterPopup() {
        wait.until(ExpectedConditions.elementToBeClickable(registerBtnLocator));
        WebElement registerBtn = driver.findElement(registerBtnLocator);
        registerBtn.click();
    }


    public String getRegisterHeader() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signUpHeaderLocator));
        WebElement checkSignUpHeader = driver.findElement(signUpHeaderLocator);
        return checkSignUpHeader.getText();
    }

    public void enterName(String name){
        WebElement nameField = driver.findElement(nameFieldLocator);
        nameField.clear();
        nameField.sendKeys(name);
    }

    public void enterEmail(String email){
        WebElement emailField = driver.findElement(randomEmailLocator);
        emailField.clear();
        emailField.sendKeys(email);
    }


    public void enterPassword(String password){
        WebElement passwordField = driver.findElement(passwordFieldLocator);
        passwordField.sendKeys(password);
    }

    public void clickRegisterBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(signUpBtnLocator));
        WebElement signUpBtn = driver.findElement(signUpBtnLocator);
        signUpBtn.click();

    }
}