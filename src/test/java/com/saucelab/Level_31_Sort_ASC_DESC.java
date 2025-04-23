package com.saucelab;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.users.SearchPO;
import pageObjects.nopCommerce.users.UserCustomerInfoPO;
import pageObjects.nopCommerce.users.UserHomePO;
import pageObjects.saucelab.LoginPageObject;
import pageObjects.saucelab.PageGeneratorManager;
import pageObjects.saucelab.ProductPageObject;

import java.lang.reflect.Method;
import java.util.Random;

public class Level_31_Sort_ASC_DESC extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(UserCustomerInfoPO.class);
    //Declare variables
    private WebDriver driver;
    private LoginPageObject loginPage;
    private ProductPageObject productPage;

    String day, month, year, companyName, firstName, lastName, email, password;

    //Pre-condition
    @Parameters({"browser", "url"})
    @BeforeMethod
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        loginPage = PageGeneratorManager.getLoginPage(driver);
        loginPage.enterToUserNameTextbox("standard_user");
        loginPage.enterToPasswordTextbox("secret_sauce");
        productPage= loginPage.clickToLoginButton();
    }

    //Testcase
    @Test
    public void Sort_01_Name() {
        productPage.selectItemInSortDropdown("Name (A to Z)");
        Assert.assertTrue(productPage.isProductNameSortAscending());

        productPage.selectItemInSortDropdown("Name (Z to A)");
        Assert.assertTrue(productPage.isProductNameSortDescending());

    }

    @Test
    public void Sort_02_Price() {
        productPage.selectItemInSortDropdown("Price (low to high)");
        Assert.assertTrue(productPage.isProductPriceSortAscending());

        productPage.selectItemInSortDropdown("Price (high to low)");
        Assert.assertTrue(productPage.isProductPriceSortDescending());

    }

    //Post-condition
    protected String getEmailRandom(String prefix) {
        Random ran = new Random();
        return prefix + ran.nextInt(9999) + "@orgnature.com";

    }

    @AfterMethod
    public void afterClass() {
        driver.quit();
    }
}
