package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage {
    private WebDriver driver;
    private  WebDriverWait wait;

    public HomePage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    By userProfileLocator = By.xpath("//*[@data-purpose='user-dropdown']");
    By logoutBtnLocator = By.xpath("//*[@data-purpose='do-logout']");
    By searchFieldLocator = By.xpath("//*[@data-purpose='home-quick-search-box']");
    By searchFieldBtnLocator = By.xpath("//*[@data-purpose='home-search-button']");
    By categoriesDropdownLocator = By.xpath("//a[@data-purpose='browse-courses-link']");
    By mainCategoryLocator = By.xpath("//ul[@class='udlite-block-list list-menu--section--BZ3j9']");
//    By lastCategoryLocator = By.xpath("(//ul[@class='dropdown-menu' and @aria-labelledby='header.browse']//span[@class='fx'])[13]");
//    String categoriesTemplateXpath = "(//ul[@class='dropdown-menu' and @aria-labelledby='header.browse']//span[@class='fx'])";


    public void openHomePage(){
        driver.get("https://www.udemy.com/");
    }

    public void getProfileName() {
        wait.until(ExpectedConditions.elementToBeClickable(userProfileLocator));
        Actions builder = new Actions(driver);
        WebElement userProfile = driver.findElement(userProfileLocator);
        builder.moveToElement(userProfile).build().perform();
    }

    public void clickLogout() {
        WebElement logoutBtn = driver.findElement(logoutBtnLocator);
        logoutBtn.click();
    }

    public String checkSearchField() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchFieldLocator));
        WebElement searchField = driver.findElement(searchFieldLocator);
        return searchField.getAttribute("placeholder");
    }

    public void enterTextInField(String text) {
        WebElement searchField = driver.findElement(searchFieldLocator);
        searchField.sendKeys(text);
    }

    public void clickSearchFieldBtn() {
        WebElement searchFieldBtn = driver.findElement((searchFieldBtnLocator));
        searchFieldBtn.click();
    }

    public void openCategoriesDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(categoriesDropdownLocator));
        WebElement categoriesDropdown = driver.findElement(categoriesDropdownLocator);
        Actions builder = new Actions(driver);
        Action moveToDropdown = builder
                .moveToElement(categoriesDropdown)
                .click(categoriesDropdown)
                .build();
        moveToDropdown.perform();
    }


    public List<String> getMainCategoryNames() {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(mainCategoryLocator))
                .stream().map(WebElement::getText).collect(Collectors.toList());
    }

}

