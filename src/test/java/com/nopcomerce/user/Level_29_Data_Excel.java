package com.nopcomerce.user;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import jsonData.nopCommerce.UserDataJson;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.users.*;
import reportConfigs.ExtentManager;
import staticVariable.nopcomerce.user.UserObject;
import utilities.ExcelConfig;

import java.lang.reflect.Method;
import java.util.Random;

//import static jdk.nio.zipfs.ZipFileAttributeView.AttrID.method;

public class Level_29_Data_Excel extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(UserCustomerInfoPO.class);
    //Declare variables
    private WebDriver driver;
    private UserHomePO homePage;
    private UserRegisterPO registerPage;
    private UserLoginPO loginPage;
    private UserCustomerInfoPO customerPage;
    private UserAddressPO addressPage;
    private UserRewardPointPO rewardPointPage;
    private UserOrderPO orderPage;
    private String browserName;
    private ExcelConfig excelConfig;

    String day, month, year, companyName, firstName, lastName, email, password;

    //Pre-condition
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        this.browserName = browserName;
//        this.email = getEmailRandom(UserObject.EMAIL_ADDRESS);
//        this.firstName = UserObject.FIRST_NAME;
//        this.lastName = UserObject.LAST_NAME;
//        this.password = UserObject.PASSWORD;
        driver = getBrowserDriver(browserName);
        //Nó được sinh ra và bắt đầu làm đc các action của page đó
        homePage = PageGenerator.getUserHomePage(driver);

        System.out.println("Qua step homePage = PageGenerator.getUserHomePage(driver)");
        excelConfig = ExcelConfig.getExcelData();
        System.out.println("Qua step excelConfig = ExcelConfig.getExcelData()");
        excelConfig.switchToSheet("UserData");
        System.out.println("Qua step excelConfig.switchToSheet(\"User\");");

        firstName = excelConfig.getCellData("FirstName", 1);
        lastName = excelConfig.getCellData("LastName", 1);
        companyName = excelConfig.getCellData("CompanyName", 1);
        email = getEmailRandom(excelConfig.getCellData("Email", 1));
        password = excelConfig.getCellData("Password",1);

        System.out.println("FirstName: "+firstName);
        System.out.println("LastName: "+lastName);
        System.out.println("CompanyName: "+companyName);
        System.out.println("Email: "+email);
        System.out.println("Password: "+password);
    }

    //Testcase
    @Test
    public void User_01_Register(Method method) {
        ExtentManager.startTest(method.getName(),"User_01_Register");
        ExtentManager.getTest().log(Status.INFO,"User_01_Register - STEP 01: Open register page");
        //ACtion 1
        registerPage = homePage.clickToRegisterLink();
        //Từ homepage qua registerPage
        //Thể hiện trực tiếp trên Test Class
        //-> Sai nguyên tắc trong thiết kế PM/ framework - nguyên tắc đóng gói
        ExtentManager.getTest().log(Status.INFO,"User_01_Register - STEP 02: Click to radio button");
        registerPage.clickToMaleRadio();

        ExtentManager.getTest().log(Status.INFO,"User_01_Register - STEP 03: Enter FirstName to Register Form");
        registerPage.enterToFirstNameTextbox(firstName);
        ExtentManager.getTest().log(Status.INFO,"User_01_Register - STEP 04: Enter Email  to Register Form");
        registerPage.enterToEmailTextbox(email);
        ExtentManager.getTest().log(Status.INFO,"User_01_Register - STEP 05: Enter LastName to Register Form");
        registerPage.enterToLastNameTextbox(lastName);
        ExtentManager.getTest().log(Status.INFO,"User_01_Register - STEP 06: Enter CompanyName to Register Form");
        registerPage.enterToCompanyTextbox(companyName);
        ExtentManager.getTest().log(Status.INFO,"User_01_Register - STEP 07: Enter Password to Register Form");
        registerPage.enterToPasswordTextbox(password);
        ExtentManager.getTest().log(Status.INFO,"User_01_Register - STEP 08: Enter Password Confirm to Register Form");
        registerPage.enterToPasswordConfirmTextbox(password);

        ExtentManager.getTest().log(Status.INFO,"User_01_Register - STEP 09: Click to Register button ");
        registerPage.clickRegisterButton();

        ExtentManager.getTest().log(Status.INFO,"User_01_Register - STEP 10: Verify message success is displayed");
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
        registerPage.clickToLogoutButton();

    }

    @Test
    public void User_02_Login() {
        loginPage = registerPage.clickToLoginButton();
        loginPage.enterToEmailTextbox(email);
        loginPage.enterToPasswordTextbox(password);
        homePage = loginPage.clickLoginToSystem();

        //Từ loginPage qua homePage
        //Page đó đc sinh ra và làm các action
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

    }

    @Test
    public void User_03_MyAccount() {
        customerPage = homePage.clickToMyaccountLink();
        System.out.println("from web: " + customerPage.getFirstNameTextboxValue());
        System.out.println("from variable: " + firstName);
        Assert.assertTrue(customerPage.isGenderMaleSelected());
        Assert.assertEquals(customerPage.getFirstNameTextboxValue(), firstName);

        Assert.assertEquals(customerPage.getLastNameTextboxValue(), lastName);
//        Assert.assertEquals(customerPage.getDayDropdownSelectedValue(),"");
//        Assert.assertEquals(customerPage.getMonthDropdownSelectedValue(),"");
//        Assert.assertEquals(customerPage.getYearDropdownSelectedValue(),"");
        Assert.assertEquals(customerPage.getEmailTextboxValue(), email);
        Assert.assertEquals(customerPage.getCompanyNameTextboxValue(), companyName);
    }

    @Test
    public void User_04_Dynamic_Page() {
        //Customer Infor -> Address);
        addressPage = (UserAddressPO) customerPage.openSidebarLinkByPageName("Addresses");

        //Address -> Reward Point
        rewardPointPage = (UserRewardPointPO) addressPage.openSidebarLinkByPageName("Reward points");

        //RewardPoint -> Order
        orderPage = (UserOrderPO) rewardPointPage.openSidebarLinkByPageName("Orders");


        //Order -> Address
        addressPage = (UserAddressPO) orderPage.openSidebarLinkByPageName("Addresses");

        //Address -> Customer Infor
        customerPage = (UserCustomerInfoPO) addressPage.openSidebarLinkByPageName("Customer info");
        addressPage = (UserAddressPO) customerPage.openSidebarLinkByPageName("Addresses");
    }

    @Test
    public void User_05_Dynamic_Page() {
        //Address -> Reward Point
        addressPage.openSidebarLinkByPageName("Reward points");
        rewardPointPage = PageGenerator.getUserRewardPointPage(driver);
        //Reward Point -> Order
        rewardPointPage.openSidebarLinkByPageName("Orders");
        orderPage = PageGenerator.getUserOrderPage(driver);

        //Order -> Address
        orderPage.openSidebarLinkByPageName("Addresses");
        addressPage = PageGenerator.getUserAddressPage(driver);

        //Address -> Customer Infor
        addressPage.openSidebarLinkByPageName("Customer info");
        customerPage = PageGenerator.getUserCustomerInfoPage(driver);
    }

    //Post-condition

    protected String getEmailRandom(String prefix) {
        Random ran = new Random();
        return prefix + ran.nextInt(9999) + "@orgnature.com";

    }

    // @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
