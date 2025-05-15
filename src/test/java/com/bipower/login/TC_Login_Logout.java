package com.bipower.login;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.bipower.LoginPO;
import pageObjects.bipower.PageGenerator;
import reportConfigs.ExtentManager;
import reportConfigs.ExtentTestListener;

import java.lang.reflect.Method;


@Listeners(ExtentTestListener.class)
public class TC_Login_Logout extends BaseTest {
    private WebDriver driver;
    private LoginPO loginPage;
    ExtentManager ExtentTestManager;
    private String username, password;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browser, String url) {
        driver = getBrowserDriver(browser, url);
        loginPage = PageGenerator.getLoginPage(driver);
        username = "duongtv@biplus.com.vn";
        password = "123456aA@";

    }


    @Test
    public void Login_01_Empty_Data(Method method) {
        ExtentManager.startTest(method.getName(),"Login_01_Empty data");

        ExtentManager.getTest().log(Status.INFO, "Login_01_Empty data - STEP 01: Enter blank to Email textbox");
        loginPage.inputToEmailTextbox("");
        ExtentManager.getTest().log(Status.INFO,"Login_01_Empty data - STEP 02: Enter blank to Password textbox");
        loginPage.inputToPasswordTextbox("");
        ExtentManager.getTest().log(Status.INFO,"Login_01_Empty data - STEP 03: Click button Login");
        loginPage.clickToLoginButton();
        Assert.assertEquals(loginPage.isEmailErrorMessageDisplayed(),"Email không được để trống.");
        Assert.assertEquals(loginPage.isPasswordErrorMessageDisplayed(),"Mật khẩu không được để trống.");
    }

    @Test
    public void Login_02_Empty_Email(Method method) {
        ExtentManager.startTest(method.getName(),"Login_02_Invalid_Email");
        ExtentManager.getTest().log(Status.INFO, "Login_02_Invalid_Email - STEP 01: Enter empty email");
        loginPage.inputToEmailTextbox("");
        ExtentManager.getTest().log(Status.INFO, "Login_02_Invalid_Email - STEP 02: Enter valid password");
        loginPage.inputToPasswordTextbox("123456a@");
        ExtentManager.getTest().log(Status.INFO,"Login_02_Invalid_Email - STEP 03: Click button Login");
        loginPage.clickToLoginButton();
        Assert.assertEquals(loginPage.isEmailErrorMessageDisplayed(),"Email không được để trống.");
    }
    @Test
    public void Login_03_Empty_Password(Method method) {
        ExtentManager.startTest(method.getName(),"Login_03_Invalid_Password");
        ExtentManager.getTest().log(Status.INFO, "Login_03_Invalid_Password - STEP 01: Enter valid email");
        loginPage.inputToEmailTextbox("invalid@");
        ExtentManager.getTest().log(Status.INFO, "Login_03_Invalid_Password - STEP 02: Enter invalid password");
        loginPage.inputToPasswordTextbox("");
        ExtentManager.getTest().log(Status.INFO,"Login_03_Invalid_Password - STEP 03: Click button Login");
        loginPage.clickToLoginButton();
        Assert.assertEquals(loginPage.isPasswordErrorMessageDisplayed(),"Mật khẩu không được để trống.");
    }

    @Test
    public void Login_04_Valid_Credentials(Method method) {
        ExtentManager.startTest(method.getName(),"Login_04_Valid_Credentials");
        ExtentManager.getTest().log(Status.INFO, "Login_03_Valid_Credentials - STEP 01: Enter valid email");
        loginPage.inputToEmailTextbox(username);
        ExtentManager.getTest().log(Status.INFO, "Login_03_Valid_Credentials - STEP 02: Enter valid password");
        loginPage.inputToPasswordTextbox(password);
        ExtentManager.getTest().log(Status.INFO,"Login_03_Valid_Credentials - STEP 03: Click button Login");
        loginPage.clickToLoginButton();
        ExtentManager.getTest().log(Status.INFO,"Login_03_Valid_Credentials - STEP 04: Verify the logout button is visible");
        Assert.assertTrue(loginPage.isLogoutButtonDisplayed());
    }
    @Test
    public void Logout_Successfully(Method method) {
        ExtentManager.startTest(method.getName(),"Logout_Successfully");
        ExtentManager.getTest().log(Status.INFO, "Logout_Successfully - STEP 01: Enter valid email");
        loginPage.clickLogoutButton();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
