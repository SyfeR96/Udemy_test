package com.udemy;

import org.testng.Assert;
import org.testng.annotations.Test;
import static com.udemy.constants.BaseConts.MAIN_CATEGORIES;

public class CategoriesMenuTest extends TestBase {
    @Test(description = "Testing of categories in the \"Categories\" menu")
    public void checkMainCategories() {

        homePage.openHomePage();

        homePage.openCategoriesDropdown();

        Assert.assertEquals(homePage.getMainCategoryNames(), MAIN_CATEGORIES);
    }
}