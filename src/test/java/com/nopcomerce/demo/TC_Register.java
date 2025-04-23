package com.nopcomerce.demo;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.demo.HomePageObject;
import pageObjects.nopCommerce.demo.PageGeneratorPO;
import pageObjects.nopCommerce.demo.RegisterPageObject;
import reportConfigs.ExtentManager;

import java.lang.reflect.Method;
import java.util.Random;

public class TC_Register extends BaseTest {
    WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    //private PageGeneratorPO pageGenerator;

    String firstName, lastName,companyName, email, password, Day, Month, Year;


    @Parameters({"browser","url"})
    @BeforeClass
    public void BeforeClass(String browser, String url){
        driver = getBrowserDriver(browser, url);
        homePage = PageGeneratorPO.getHomePage(driver);
        registerPage = homePage.clickToRegisterLink(driver);

    }
    @Test
    public void TC_01_Register_Empty_Data(Method method){
        firstName = "John";
        lastName = "Beckham";
        companyName = "Nexus FrontierTech";
        email = genRandomEmail(firstName);
        password = "123456a@";
        ExtentManager.startTest(method.getName(),"TC_01_Register_Empty_Data");
//        ExtentManager.getTest().log(Status.INFO,"TC_01_Register_Empty_Data - STEP 01: Open register page");


        ExtentManager.getTest().log(Status.INFO,"TC_01_Register_Empty_Data - STEP 02: Select Gender Male");
        registerPage.selectToMaleGender();

        ExtentManager.getTest().log(Status.INFO,"TC_01_Register_Empty_Data - STEP 03: Enter First Name");
        registerPage.enterToFirstnameTextbox("");

        ExtentManager.getTest().log(Status.INFO,"TC_01_Register_Empty_Data - STEP 04: Enter Last Name");
        registerPage.enterToLastnameTextbox("");
//        registerPage.selectDayToDateOfBirth(Day);
//        registerPage.selectMonthToDateOfBirth(Month);
//        registerPage.selectYearToDateOfBirth(Year);
        ExtentManager.getTest().log(Status.INFO,"TC_01_Register_Empty_Data - STEP 05: Enter Email");
        registerPage.enterToEmailTextbox("");

        ExtentManager.getTest().log(Status.INFO,"TC_01_Register_Empty_Data - STEP 06: Enter company name");
        registerPage.enterToCompanyNameTextbox(companyName);

        ExtentManager.getTest().log(Status.INFO,"TC_01_Register_Empty_Data - STEP 07: Enter password");
        registerPage.enterToPasswordTextbox("");

        ExtentManager.getTest().log(Status.INFO,"TC_01_Register_Empty_Data - STEP 08: Enter password confirm");
        registerPage.enterToPasswordConfirmTextbox("");

        ExtentManager.getTest().log(Status.INFO,"TC_01_Register_Empty_Data - STEP 09: Click button register");
        registerPage.clickToRegisterButton();

        ExtentManager.getTest().log(Status.INFO,"TC_01_Register_Empty_Data - STEP 10: Verify error message");
        Assert.assertEquals(registerPage.getFirstNameErrorMessageDisplayed(),"First name is required.");;
        Assert.assertEquals(registerPage.getLastNameErrorMessageDisplayed(),"Last name is required.");
        Assert.assertEquals(registerPage.getEmailErrorMessageDisplayed(),"Email is required.");
        Assert.assertEquals(registerPage.getPasswordErrorMessageDisplayed(),"Password is required.");
    }

    @Test
    public void TC_02_Register_Invalid_Email(Method method){
        firstName = "John";
        lastName = "Beckham";
        companyName = "Nexus FrontierTech";
        email = firstName;
        password = "123456a@";
        ExtentManager.startTest(method.getName(),"TC_02_Register_Invalid_Email");
//        registerPage = homePage.clickToRegisterLink(driver);

        ExtentManager.getTest().log(Status.INFO,"TC_02_Register_Invalid_Email- STEP 01: Open register page");
        registerPage.selectToFemaleGender();

        ExtentManager.getTest().log(Status.INFO,"TC_02_Register_Invalid_Email- STEP 02: Enter valid firstname");
        registerPage.enterToFirstnameTextbox(firstName);

        ExtentManager.getTest().log(Status.INFO,"TC_02_Register_Invalid_Email- STEP 03: Enter valid lastname");
        registerPage.enterToLastnameTextbox(lastName);
//        registerPage.selectDayToDateOfBirth("");
//        registerPage.selectMonthToDateOfBirth("");
//        registerPage.selectYearToDateOfBirth("");
        ExtentManager.getTest().log(Status.INFO,"TC_02_Register_Invalid_Email- STEP 04: Enter invalid email");
        registerPage.enterToEmailTextbox(email);
        registerPage.clickToRegisterButton();

        ExtentManager.getTest().log(Status.INFO,"TC_02_Register_Invalid_Email- STEP 04: Verify error message displayed");
        Assert.assertEquals(registerPage.getEmailErrorMessageDisplayed(),"Please enter a valid email address.");
    }

    @Test
    public void TC_03_Register_With_Password_Less_6Characters(Method method){
        firstName = "John";
        lastName = "Beckham";
        companyName = "Nexus FrontierTech";
        email = genRandomEmail(firstName);
        password = "12345";
        ExtentManager.startTest(method.getName(), "TC_05_Register_With_Password_Less_6Characters");
//        registerPage = homePage.clickToRegisterLink(driver);

        ExtentManager.getTest().log(Status.INFO,"TC_05_Register_With_Password_Less_6Characters - STEP 01: Select Female");
        registerPage.selectToFemaleGender();

        ExtentManager.getTest().log(Status.INFO,"TC_05_Register_With_Password_Less_6Characters - STEP 02: Enter first name");
        registerPage.enterToFirstnameTextbox(firstName);

        ExtentManager.getTest().log(Status.INFO,"TC_05_Register_With_Password_Less_6Characters - STEP 03: Enter last name");
        registerPage.enterToLastnameTextbox(lastName);

        ExtentManager.getTest().log(Status.INFO,"TC_05_Register_With_Password_Less_6Characters - STEP 04: Enter company name");
        registerPage.enterToCompanyNameTextbox(companyName);
//        registerPage.selectDayToDateOfBirth("");
//        registerPage.selectMonthToDateOfBirth("");
//        registerPage.selectYearToDateOfBirth("");
        ExtentManager.getTest().log(Status.INFO,"TC_05_Register_With_Password_Less_6Characters - STEP 05: Enter existed email");
        registerPage.enterToEmailTextbox(email);

        ExtentManager.getTest().log(Status.INFO,"TC_05_Register_With_Password_Less_6Characters - STEP 05: Enter password < 6 characters");
        registerPage.enterToPasswordTextbox(password);

        ExtentManager.getTest().log(Status.INFO,"TC_05_Register_With_Password_Less_6Characters - STEP 06: Enter password confirm");
        registerPage.enterToPasswordConfirmTextbox(password);
        registerPage.clickToRegisterButton();

        ExtentManager.getTest().log(Status.INFO,"TC_05_Register_With_Password_Less_6Characters - STEP 07: Verify error message when password < 6 characters");
        Assert.assertEquals(registerPage.getMessagePasswordLessThan6Chacs(),"<p>must meet the following rules: </p><ul><li>must have at least 6 characters and not greater than 64 characters</li></ul>");
    }

    @Test
    public void TC_04_Register_With_ConfirmPassword_Not_Match(Method method){
        firstName = "John";
        lastName = "Beckham";
        companyName = "Nexus FrontierTech";
        email = genRandomEmail(firstName);
        password = "12345";
        ExtentManager.startTest(method.getName(), "TC_06_Register_With_ConfirmPassword_Not_Match");
//        registerPage = homePage.clickToRegisterLink(driver);

        ExtentManager.getTest().log(Status.INFO,"TC_06_Register_With_ConfirmPassword_Not_Match - STEP 01: Select Female");
        registerPage.selectToFemaleGender();

        ExtentManager.getTest().log(Status.INFO,"TC_06_Register_With_ConfirmPassword_Not_Match - STEP 02: Enter first name");
        registerPage.enterToFirstnameTextbox(firstName);

        ExtentManager.getTest().log(Status.INFO,"TC_06_Register_With_ConfirmPassword_Not_Match - STEP 03: Enter last name");
        registerPage.enterToLastnameTextbox(lastName);

        ExtentManager.getTest().log(Status.INFO,"TC_06_Register_With_ConfirmPassword_Not_Match - STEP 04: Enter company name");
        registerPage.enterToCompanyNameTextbox(companyName);
//        registerPage.selectDayToDateOfBirth("");
//        registerPage.selectMonthToDateOfBirth("");
//        registerPage.selectYearToDateOfBirth("");
        ExtentManager.getTest().log(Status.INFO,"TC_06_Register_With_ConfirmPassword_Not_Match - STEP 05: Enter existed email");
        registerPage.enterToEmailTextbox(email);

        ExtentManager.getTest().log(Status.INFO,"TC_06_Register_With_ConfirmPassword_Not_Match - STEP 05: Enter password");
        registerPage.enterToPasswordTextbox(password);

        ExtentManager.getTest().log(Status.INFO,"TC_06_Register_With_ConfirmPassword_Not_Match - STEP 06: Enter password confirm is not match");
        registerPage.enterToPasswordConfirmTextbox(password+"1");
        registerPage.clickToRegisterButton();

        ExtentManager.getTest().log(Status.INFO,"TC_06_Register_With_ConfirmPassword_Not_Match - STEP 07: Verify error message when password confirm is not match");
        Assert.assertEquals(registerPage.getPasswordErrorMessageDisplayed(),"The password and confirmation password do not match.");
    }

    @Test
    public void TC_05_Register_Successfully(Method method){
        firstName = "John";
        lastName = "Beckham";
        companyName = "Nexus FrontierTech";
        email = genRandomEmail(firstName);
        password = "123456a@";
        System.out.println("Email: "+email);
        ExtentManager.startTest(method.getName(), "TC_03_Register_Successfully");
//        registerPage = homePage.clickToRegisterLink(driver);

        ExtentManager.getTest().log(Status.INFO,"TC_03_Register_Successfully - STEP 01: Select Female");
        registerPage.selectToFemaleGender();

        ExtentManager.getTest().log(Status.INFO,"TC_03_Register_Successfully - STEP 02: Enter first name");
        registerPage.enterToFirstnameTextbox(firstName);

        ExtentManager.getTest().log(Status.INFO,"TC_03_Register_Successfully - STEP 03: Enter last name");
        registerPage.enterToLastnameTextbox(lastName);

        ExtentManager.getTest().log(Status.INFO,"TC_03_Register_Successfully - STEP 04: Enter company name");
        registerPage.enterToCompanyNameTextbox(companyName);
//        registerPage.selectDayToDateOfBirth("");
//        registerPage.selectMonthToDateOfBirth("");
//        registerPage.selectYearToDateOfBirth("");
        ExtentManager.getTest().log(Status.INFO,"TC_03_Register_Successfully - STEP 05: Enter email");
        registerPage.enterToEmailTextbox(email);

        ExtentManager.getTest().log(Status.INFO,"TC_03_Register_Successfully - STEP 05: Enter password");
        registerPage.enterToPasswordTextbox(password);

        ExtentManager.getTest().log(Status.INFO,"TC_03_Register_Successfully - STEP 06: Enter password confirm");
        registerPage.enterToPasswordConfirmTextbox(password);
        registerPage.clickToRegisterButton();

        ExtentManager.getTest().log(Status.INFO,"TC_03_Register_Successfully - STEP 07: Verify success message");
        Assert.assertEquals(registerPage.getMessageRegisterSuccess(),"Your registration completed");
        registerPage.clickToLogoutLink();
    }

    @Test
    public void TC_06_Register_With_Existed_Email(Method method){
        firstName = "John";
        lastName = "Beckham";
        companyName = "Nexus FrontierTech";
//        email = genRandomEmail();
        password = "123456a@";
        ExtentManager.startTest(method.getName(), "TC_04_Register_With_Existed_Email");
        registerPage = homePage.clickToRegisterLink(driver);

        ExtentManager.getTest().log(Status.INFO,"TC_04_Register_With_Existed_Email - STEP 01: Select Female");
        registerPage.selectToFemaleGender();

        ExtentManager.getTest().log(Status.INFO,"TC_04_Register_With_Existed_Email - STEP 02: Enter first name");
        registerPage.enterToFirstnameTextbox(firstName);

        ExtentManager.getTest().log(Status.INFO,"TC_04_Register_With_Existed_Email - STEP 03: Enter last name");
        registerPage.enterToLastnameTextbox(lastName);

        ExtentManager.getTest().log(Status.INFO,"TC_04_Register_With_Existed_Email - STEP 04: Enter company name");
        registerPage.enterToCompanyNameTextbox(companyName);
//        registerPage.selectDayToDateOfBirth("");
//        registerPage.selectMonthToDateOfBirth("");
//        registerPage.selectYearToDateOfBirth("");
        ExtentManager.getTest().log(Status.INFO,"TC_04_Register_With_Existed_Email - STEP 05: Enter existed email");
        registerPage.enterToEmailTextbox(email);

        ExtentManager.getTest().log(Status.INFO,"TC_04_Register_With_Existed_Email - STEP 05: Enter password");
        registerPage.enterToPasswordTextbox(password);

        ExtentManager.getTest().log(Status.INFO,"TC_04_Register_With_Existed_Email - STEP 06: Enter password confirm");
        registerPage.enterToPasswordConfirmTextbox(password);
        registerPage.clickToRegisterButton();

        ExtentManager.getTest().log(Status.INFO,"TC_04_Register_With_Existed_Email - STEP 07: Verify error message existed email");
        Assert.assertEquals(registerPage.getMessageExistedEmail(),"The specified email already exists");
    }


    //@AfterClass
    public void AfterClass(){
        driver.quit();
    }

}
