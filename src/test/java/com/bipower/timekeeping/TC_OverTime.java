package com.bipower.timekeeping;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.bipower.LoginPO;
import pageObjects.bipower.PageGenerator;
import pageObjects.bipower.timekeeping.overtime.RegisterOvertimePO;
import reportConfigs.ExtentManager;
import reportConfigs.ExtentTestListener;

import java.lang.reflect.Method;

@Listeners(ExtentTestListener.class)
public class TC_OverTime extends BaseTest {

    WebDriver driver;
    LoginPO loginPage;
    public String username, password;
    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browser, String url) {
        driver = getBrowserDriver(browser, url);
        loginPage = PageGenerator.getLoginPage(driver);
        username = "duongtv@biplus.com.vn";
        password = "123456aA@";
        loginPage.loginAsUser(username,password);
    }

    @Test
    public void RegisterOT_01_Empty_Data(Method method) {
        RegisterOvertimePO overtimePage = new RegisterOvertimePO(driver);

        ExtentManager.startTest(method.getName(),"RegisterOT_01_Empty_Data");
        ExtentManager.getTest().log(Status.INFO, "RegisterOT_01_Empty_Data - STEP 01: Enter blank to Request Code");
        overtimePage.inputRequestCode("OT-2025-001");
        ExtentManager.getTest().log(Status.INFO, "RegisterOT_01_Empty_Data - STEP 02: Don't select Project");
        overtimePage.selectProject("Dự án ABC");
        ExtentManager.getTest().log(Status.INFO, "RegisterOT_01_Empty_Data - STEP 03: Enter blank to Reason");
        overtimePage.inputOvertimeReason("Làm để triển khai release");
        ExtentManager.getTest().log(Status.INFO, "RegisterOT_01_Empty_Data - STEP 04: Enter blank to Start Date");
        overtimePage.inputStartDate("15/05/2025");
        ExtentManager.getTest().log(Status.INFO, "RegisterOT_01_Empty_Data - STEP 05: Don't select FromTime");
        overtimePage.inputFromTime("18:00");
        ExtentManager.getTest().log(Status.INFO, "RegisterOT_01_Empty_Data - STEP 06: Don't select ToTime");
        overtimePage.inputToTime("22:00");
        ExtentManager.getTest().log(Status.INFO, "RegisterOT_01_Empty_Data - STEP 07: Enter blank to Jiralink");
        overtimePage.inputJiraLink("https://jira.com/browse/OT-001");
        ExtentManager.getTest().log(Status.INFO, "RegisterOT_01_Empty_Data - STEP 08: Click button Save");
        overtimePage.clickSave();

        // Optional: bạn có thể thêm verify ở màn list nếu cần
    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
