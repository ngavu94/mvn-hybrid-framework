package com.facebook.cases;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.facebook.LoginPO;
import pageObjects.facebook.PageGenerator;

import java.lang.reflect.Method;

public class Level_18_Undisplayed extends BaseTest {

    //Pre-condition
    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        //Nó được sinh ra và bắt đầu làm đc các action của page đó
        loginPage = PageGenerator.getLoginPage(driver);
        loginPage.clickToNewAccountButton();

    }

    //Testcase
    @Test
    public void TC_01_Element_Displayed(Method method) {
        loginPage.enterToEmailAdressTextbox("ngavt@gmail.com");
        //Case 1- verify Confirm Email Textbox is displayed
        Assert.assertTrue(loginPage.isConfirmEmailTextboxDisplayed());
        //Case 2- verify Confirm Email Textbox is not displayed
        loginPage.enterToEmailAdressTextbox("");
        Assert.assertFalse(loginPage.isConfirmEmailTextboxDisplayed());



    }

    //Post-condition
    // @AfterClass
    public void afterClass() {
        driver.quit();
    }
    //Declare variables

    WebDriver driver;
    private LoginPO loginPage;

}
