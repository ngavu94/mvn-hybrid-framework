package com.nopcomerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.users.*;

public class Level_06_Page_Generator_04_demo extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(Level_06_Page_Generator_04_demo.class);
    WebDriver driver;
    private UserHomePO homePage;
    private UserRegisterPO registerPage;
    private UserLoginPO loginPage;
    private UserCustomerInfoPO customerPage;
    private UserAddressPO addressPage;
    private UserOrderPO orderPage;
    private UserRewardPointPO rewardPointPage;

    String firstName, lastName, email, companyName, password;

//    String url="http://localhost/";

    @Parameters({"browser"})
    @BeforeClass()
    public void beforClass(String browser) {
        driver = getBrowserDriver(browser);
       // System.out.println("driver: " + driver);
        homePage = PageGenerator.getUserHomePage(driver);
        firstName = "Nga";
        lastName = "Vu";
        email = firstName + lastName + generateNumber() + "@gmail.com";
        companyName = "ABC company";
        password = "123456a@";
    }

    @Test
    public void User_01_Register() {
        registerPage = homePage.clickToRegisterLink();
        registerPage.clickToMaleRadio();
        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.enterToEmailTextbox(email);
        registerPage.enterToCompanyTextbox(companyName);
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToPasswordConfirmTextbox(password);
        registerPage.clickRegisterButton();
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
        registerPage.clickToLogoutButton();
    }

    @Test
    public void User_02_Login() {
        loginPage = registerPage.clickToLoginButton();
        loginPage.enterToEmailTextbox(email);
        loginPage.enterToPasswordTextbox(password);
        homePage = loginPage.clickLoginToSystem();
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

    }

    @Test
    public void User_03_Customer_Info() {
        customerPage = homePage.clickToMyaccountLink();
        Assert.assertTrue(customerPage.isGenderMaleSelected());
        Assert.assertEquals(customerPage.getFirstNameTextboxValue(), firstName);
        Assert.assertEquals(customerPage.getLastNameTextboxValue(), lastName);
        Assert.assertEquals(customerPage.getEmailTextboxValue(), email);
        Assert.assertEquals(customerPage.getCompanyNameTextboxValue(), companyName);
    }

    @Test
    public void User_04_Switch_Page() {
        customerPage = homePage.clickToMyaccountLink();
        //Chuyển sang address page
        addressPage = customerPage.openAddressPage();
        //Chuyển sang order page
        orderPage = addressPage.openOrderPage();
        //Chuyển sang Reward point page
        rewardPointPage = orderPage.openRewardPointPage();
        //Chuyển lại Customer info page
        customerPage = rewardPointPage.openCustomerInfoPage();

    }

}
