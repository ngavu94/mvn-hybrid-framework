package com.nopcomerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.users.UserCustomerInfoPO;
import pageObjects.nopCommerce.users.UserHomePO;
import pageObjects.nopCommerce.users.UserLoginPO;
import pageObjects.nopCommerce.users.UserRegisterPO;

public class Level_06_Page_Generator_02 extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(UserCustomerInfoPO.class);
    //Declare variables
    private WebDriver driver;
    private UserHomePO homePage;
    private UserRegisterPO registerPage;
    private UserLoginPO loginPage;
    private UserCustomerInfoPO customerPage;

    String firstName, lastName, day, month, year, email, companyName, password;

    //Pre-condition
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        driver = getBrowserDriver(browserName);
        //Nó được sinh ra và bắt đầu làm đc các action của page đó
        homePage=new UserHomePO(driver);
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
        registerPage = homePage.clickToRegisterLink();

        //Từ homepage qua registerPage
        //Thể hiện trực tiếp trên Test Class
        //-> Sai nguyên tắc trong thiết kế PM/ framework - nguyên tắc đóng gói
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
        loginPage= registerPage.clickToLoginButton();
        loginPage.enterToEmailTextbox(email);
        loginPage.enterToPasswordTextbox(password);
        homePage = loginPage.clickLoginToSystem();

        //Từ loginPage qua homePage
        //Page đó đc sinh ra và làm các action
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

    }
    @Test
    public void User_03_MyAccount(){
        customerPage= homePage.clickToMyaccountLink();
        System.out.println("from web: " +customerPage.getFirstNameTextboxValue());
        System.out.println("from variable: " +firstName);
        Assert.assertTrue(customerPage.isGenderMaleSelected());
        Assert.assertEquals(customerPage.getFirstNameTextboxValue(),firstName);

        Assert.assertEquals(customerPage.getLastNameTextboxValue(),lastName);
//        Assert.assertEquals(customerPage.getDayDropdownSelectedValue(),"");
//        Assert.assertEquals(customerPage.getMonthDropdownSelectedValue(),"");
//        Assert.assertEquals(customerPage.getYearDropdownSelectedValue(),"");
        Assert.assertEquals(customerPage.getEmailTextboxValue(),email);
        Assert.assertEquals(customerPage.getCompanyNameTextboxValue(),companyName);
    }

    //Post-condition
    // @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
