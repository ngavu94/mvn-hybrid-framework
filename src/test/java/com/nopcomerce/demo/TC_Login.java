package com.nopcomerce.demo;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.demo.HomePageObject;
import pageObjects.nopCommerce.demo.LoginPageObject;
import pageObjects.nopCommerce.demo.PageGeneratorPO;
import reportConfigs.ExtentManager;

import java.lang.reflect.Method;

public class TC_Login extends BaseTest {
    WebDriver driver;
    private HomePageObject homePage;
    private LoginPageObject loginPage;
    String email;
    String password;

    @Parameters({"browser","url"})
    @BeforeClass
    public void BeforeClass(String browser, String url){
        driver = getBrowserDriver(browser, url);
        homePage = PageGeneratorPO.getHomePage(driver);
        loginPage = homePage.clickToLoginLink(driver);
        email = "ngavu@gmail.com.vn";
        password="123456a@";

    }
    @Test
    public void TC_01_Login_With_Empty_Data(Method method) {
        ExtentManager.startTest(method.getName(), "TC_01_Login_With_Empty_Data");
//        ExtentManager.getTest().log(Status.INFO, "TC_01_Login_With_Empty_Data - STEP 01: Open login page");
        ExtentManager.getTest().log(Status.INFO, "TC_01_Login_With_Empty_Data - STEP 02: Enter empty email");
        loginPage.enterToEmailTextbox("");


        ExtentManager.getTest().log(Status.INFO, "TC_01_Login_With_Empty_Data - STEP 03: Enter empty password");
        loginPage.enterToPasswordTextbox("");


        ExtentManager.getTest().log(Status.INFO, "TC_01_Login_With_Empty_Data - STEP 04: Click login button");
        loginPage.clickToLoginButton();

        ExtentManager.getTest().log(Status.INFO, "TC_01_Login_With_Empty_Data - STEP 05: Verify error message in email");
        Assert.assertEquals(loginPage.getErrorMessageEmail(),"Please enter your email");

//        ExtentManager.getTest().log(Status.INFO, "TC_01_Login_With_Empty_Data - STEP 06: Verify error message in password");
//        Assert.assertEquals(loginPage.getErrorMessagePassword(),"");

    }

    @Test
    public void TC_02_Login_With_Invalid_Email(Method method) {
        email = "ngavu12345";
        ExtentManager.startTest(method.getName(), "TC_02_Login_With_Invalid_Email");
//        ExtentManager.getTest().log(Status.INFO, "TC_02_Login_With_Invalid_Email - STEP 01: Open login page");
//

        ExtentManager.getTest().log(Status.INFO, "TC_02_Login_With_Invalid_Email - STEP 02: Enter invalid email");
        loginPage.enterToEmailTextbox(email);


        ExtentManager.getTest().log(Status.INFO, "TC_02_Login_With_Invalid_Email - STEP 03: Enter valid password");
        loginPage.enterToPasswordTextbox(password);


        ExtentManager.getTest().log(Status.INFO, "TC_02_Login_With_Invalid_Email - STEP 04: Click login button");
        loginPage.clickToLoginButton();

        ExtentManager.getTest().log(Status.INFO, "TC_02_Login_With_Invalid_Email - STEP 05: Verify error message in email");
        Assert.assertEquals(loginPage.getErrorMessageEmail(),"Please enter a valid email address.");


    }
    @Test
    public void TC_03_Login_With_Unregistered_Email(Method method) {
        email = "aaabbbccc123@gmail.com";
        ExtentManager.startTest(method.getName(), "TC_03_Login_With_Unregister_Email");
//        ExtentManager.getTest().log(Status.INFO, "TC_03_Login_With_Unregister_Email - STEP 01: Open login page");
//        loginPage = homePage.clickToLoginLink(driver);

        ExtentManager.getTest().log(Status.INFO, "TC_03_Login_With_Unregister_Email - STEP 02: Enter unregistered email");
        loginPage.enterToEmailTextbox(email);


        ExtentManager.getTest().log(Status.INFO, "TC_03_Login_With_Unregister_Email - STEP 03: Enter valid password");
        loginPage.enterToPasswordTextbox(password);


        ExtentManager.getTest().log(Status.INFO, "TC_03_Login_With_Unregister_Email - STEP 04: Click login button");
        loginPage.clickToLoginButton();

        ExtentManager.getTest().log(Status.INFO, "TC_03_Login_With_Unregister_Email - STEP 05: Verify error message validate summary");
        Assert.assertEquals(loginPage.getErrorMessageValidationSummary(),"Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found");
//        Assert.assertEquals(loginPage.getSubErrorMessageValidationSummary(),"No customer account found");

    }

    @Test
    public void TC_04_Login_With_Valid_Email_Empty_Password(Method method) {
        email = "John6074@org.com.vn";
        ExtentManager.startTest(method.getName(), "TC_04_Login_With_Valid_Email_Empty_Password");
//        ExtentManager.getTest().log(Status.INFO, "TC_04_Login_With_Valid_Email_Empty_Password - STEP 01: Open login page");
//        loginPage = homePage.clickToLoginLink(driver);

        ExtentManager.getTest().log(Status.INFO, "TC_04_Login_With_Valid_Email_Empty_Password - STEP 02: Enter valid email");
        loginPage.enterToEmailTextbox(email);


        ExtentManager.getTest().log(Status.INFO, "TC_04_Login_With_Valid_Email_Empty_Password - STEP 03: Enter empty password");
        loginPage.enterToPasswordTextbox("");


        ExtentManager.getTest().log(Status.INFO, "TC_04_Login_With_Valid_Email_Empty_Password - STEP 04: Click login button");
        loginPage.clickToLoginButton();

        ExtentManager.getTest().log(Status.INFO, "TC_04_Login_With_Valid_Email_Empty_Password - STEP 05: Verify error message validate summary");
        Assert.assertEquals(loginPage.getErrorMessageValidationSummary(),"Login was unsuccessful. Please correct the errors and try again.\n" +
                "The credentials provided are incorrect");
//        Assert.assertEquals(loginPage.getSubErrorMessageValidationSummary(),"The credentials provided are incorrect");

    }

    @Test
    public void TC_05_Login_With_Valid_Email_Invalid_Password(Method method) {
        email = "John6074@org.com.vn";
        password="654321";
        ExtentManager.startTest(method.getName(), "TC_05_Login_With_Valid_Email_Invalid_Password");
//        ExtentManager.getTest().log(Status.INFO, "TC_05_Login_With_Valid_Email_Invalid_Password - STEP 01: Open login page");
//        loginPage = homePage.clickToLoginLink(driver);

        ExtentManager.getTest().log(Status.INFO, "TC_05_Login_With_Valid_Email_Invalid_Password - STEP 02: Enter valid email");
        loginPage.enterToEmailTextbox(email);


        ExtentManager.getTest().log(Status.INFO, "TC_05_Login_With_Valid_Email_Invalid_Password - STEP 03: Enter invalid password");
        loginPage.enterToPasswordTextbox(password);


        ExtentManager.getTest().log(Status.INFO, "TC_05_Login_With_Valid_Email_Invalid_Password - STEP 04: Click login button");
        loginPage.clickToLoginButton();

        ExtentManager.getTest().log(Status.INFO, "TC_05_Login_With_Valid_Email_Invalid_Password - STEP 05: Verify error message validate summary");
        Assert.assertEquals(loginPage.getErrorMessageValidationSummary(),"Login was unsuccessful. Please correct the errors and try again.\n" +
                "The credentials provided are incorrect");

    }

    @Test
    public void TC_06_Login_With_Valid_Data(Method method) {
        email = "John6074@org.com.vn";
        password="123456a@";
        ExtentManager.startTest(method.getName(), "TC_05_Login_With_Valid_Email_Invalid_Password");
//        ExtentManager.getTest().log(Status.INFO, "TC_05_Login_With_Valid_Email_Invalid_Password - STEP 01: Open login page");
//        loginPage = homePage.clickToLoginLink(driver);

        ExtentManager.getTest().log(Status.INFO, "TC_05_Login_With_Valid_Email_Invalid_Password - STEP 02: Enter valid email");
        loginPage.enterToEmailTextbox(email);

        ExtentManager.getTest().log(Status.INFO, "TC_05_Login_With_Valid_Email_Invalid_Password - STEP 03: Enter valid password");
        loginPage.enterToPasswordTextbox(password);


        ExtentManager.getTest().log(Status.INFO, "TC_05_Login_With_Valid_Email_Invalid_Password - STEP 04: Click login button");
        loginPage.clickToLoginButton();

        ExtentManager.getTest().log(Status.INFO, "TC_05_Login_With_Valid_Email_Invalid_Password - STEP 05: Verify text after login success");
        Assert.assertEquals(loginPage.getHomePageAfterLoginSuccess(),"Welcome to our store");

    }
   // @AfterClass
    public void AfterClass(){
        driver.quit();
    }

}
