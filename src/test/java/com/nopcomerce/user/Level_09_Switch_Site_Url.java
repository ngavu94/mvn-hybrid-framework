package com.nopcomerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.admin.AdminDashboardPO;
import pageObjects.nopCommerce.admin.AdminLoginPO;
import pageObjects.nopCommerce.users.UserHomePO;
import pageObjects.nopCommerce.users.UserLoginPO;
import pageObjects.nopCommerce.users.UserRegisterPO;

public class Level_09_Switch_Site_Url extends BaseTest {


    //Pre-condition
    @Parameters({"browser","userUrl","adminUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String userUrl, String adminUrl) {
        this.userUrl = userUrl;
        this.adminUrl = adminUrl;
        driver = getBrowserDriver(browserName, this.userUrl);
        //Nó được sinh ra và bắt đầu làm đc các action của page đó
        userHomePage = PageGenerator.getUserHomePage(driver);
        firstName = "nga";
        lastName = "vu";
        day = "10";
        month = "August";
        year = "1990";
        email = "ngavu" + generateNumber() + "@org.edu";
        companyName = "viettel";
        password = "123456789";

        //Pre-condition
        userRegisterPage = userHomePage.clickToRegisterLink();
        userRegisterPage.clickToMaleRadio();
        userRegisterPage.enterToFirstNameTextbox(firstName);
        userRegisterPage.enterToLastNameTextbox(lastName);
        userRegisterPage.enterToEmailTextbox(email);
        userRegisterPage.enterToCompanyTextbox(companyName);
        userRegisterPage.enterToPasswordTextbox(password);
        userRegisterPage.enterToPasswordConfirmTextbox(password);
        userRegisterPage.clickRegisterButton();
        Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");
        userRegisterPage.clickToLogoutButton();
    }

    //Testcase
    @Test
    public void Role_01_User_Site_To_Admin_Site() {
        userLoginPage = userRegisterPage.clickToLoginButton();
        userLoginPage.enterToEmailTextbox(email);
        userLoginPage.enterToPasswordTextbox(password);
        userHomePage = userLoginPage.clickLoginToSystem();

        //Từ loginPage qua homePage
        //Page đó đc sinh ra và làm các action
        Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());

        //Qua trang admin để verify/ approve cái order ở trên với quyền admin
        userHomePage.openPageUrl(driver, this.adminUrl);
        //Chưa login
        adminLoginPage = PageGenerator.getAdminLoginPage(driver);
        //Khi đã login rồi
        adminDashboardPage = PageGenerator.getAdminDashboardPage(driver);

        //Login to Admin Site
        adminLoginPage.enterToEmailTextbox("email");
        adminLoginPage.enterToPasswordTextbox("pass");
        adminDashboardPage = adminLoginPage.clickToLoginButton();

    }

    @Test
    public void Role_02_Admin_Site_To_User_Site() {
        //Truy cập site của user
        adminDashboardPage.openPageUrl(driver, this.userUrl);
        //Khởi tạo User home page lên
        userHomePage = PageGenerator.getUserHomePage(driver);
        //Thực hiện các action



    }


    //Post-condition
    // @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private String userUrl, adminUrl;
    //Declare variables
    private WebDriver driver;
    private UserHomePO userHomePage;
    private UserRegisterPO userRegisterPage;
    private UserLoginPO userLoginPage;
    private AdminLoginPO adminLoginPage;
    private AdminDashboardPO adminDashboardPage;


    String firstName, lastName, day, month, year, email, companyName, password;
}

