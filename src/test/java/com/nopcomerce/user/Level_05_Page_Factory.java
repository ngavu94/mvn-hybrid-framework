package com.nopcomerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageFactory.CustomerInforPageFactory;
import pageFactory.HomePageFactory;
import pageFactory.LoginPageFactory;
import pageFactory.RegisterPageFactory;
import pageObjects.nopCommerce.users.UserCustomerInfoPO;
import pageObjects.nopCommerce.users.UserHomePO;
import pageObjects.nopCommerce.users.UserLoginPO;
import pageObjects.nopCommerce.users.UserRegisterPO;

public class Level_05_Page_Factory extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(UserCustomerInfoPO.class);
    //Declare variables
    private WebDriver driver;
    private HomePageFactory homePage;
    private RegisterPageFactory registerPage;
    private LoginPageFactory loginPage;
    private CustomerInforPageFactory customerPage;

    String firstName, lastName, day, month, year, email, companyName, password;

    //Pre-condition
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        driver = getBrowserDriver(browserName);
        //Nó được sinh ra và bắt đầu làm đc các action của page đó
        homePage = new HomePageFactory(driver);
        firstName = "nga";
        lastName ="vu";
        day="10";
        month="August";
        year="1990";
        email="ngavu"+ generateNumber()+"@org.edu";
        companyName="viettel";
        password="123456789";
    }

    //Testcase
    @Test
    public void User_01_Register(){
        //ACtion 1
        homePage.clickToRegisterLink();

        //Từ homepage qua registerPage
        registerPage = new RegisterPageFactory(driver);
        registerPage.clickToMaleRadio();
        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
//        registerPage.selectDayDropdown("12");
//        registerPage.selectMonthDropdown("04");
//        registerPage.selectYearDropdown("12");
        registerPage.enterToEmailTextbox(email);
        registerPage.enterToCompanyTextbox(companyName);
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToPasswordConfirmTextbox(password);
        registerPage.clickRegisterButton();
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");
        registerPage.clickToLogoutButton();

    }
    @Test
    public void User_02_Login(){
        registerPage.clickToLoginButton();
        loginPage = new LoginPageFactory(driver);
        loginPage.enterToEmailTextbox(email);
        loginPage.enterToPasswordTextbox(password);
        loginPage.clickLoginToSystem();

        //Từ loginPage qua homePage
        //Page đó đc sinh ra và làm các action
        homePage = new HomePageFactory(driver);
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

    }
    @Test
    public void User_03_MyAccount(){
        homePage.clickToMyaccountLink();
        customerPage = new CustomerInforPageFactory(driver);
        System.out.println("from web: " +customerPage.getFirstNameTextboxValue());
        System.out.println("from variable: " +firstName);
        Assert.assertTrue(customerPage.isGenderMaleSelected());
        Assert.assertEquals(customerPage.getFirstNameTextboxValue(),firstName);

        Assert.assertEquals(customerPage.getLastNameTextboxValue(),lastName);
        Assert.assertEquals(customerPage.getEmailTextboxValue(),email);
        Assert.assertEquals(customerPage.getCompanyNameTextboxValue(),companyName);
    }

    //Post-condition
    // @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
