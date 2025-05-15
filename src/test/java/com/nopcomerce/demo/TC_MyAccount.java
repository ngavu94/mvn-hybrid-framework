package com.nopcomerce.demo;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.demo.HomePageObject;
import pageObjects.nopCommerce.demo.MyAccountPageObject;
import pageObjects.nopCommerce.demo.PageGeneratorPO;
import pageObjects.nopCommerce.demo.RegisterPageObject;
import reportConfigs.ExtentManager;

import java.lang.reflect.Method;

public class TC_MyAccount extends BaseTest {
    WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private MyAccountPageObject myAccountPage;

    String firstName, lastName,companyName, email, password;
    String firstNameUpdate, lastNameUpdate,companyNameUpdate, emailUpdate, passwordUpdate;


    @Parameters({"browser","url"})
    @BeforeClass
    public void BeforeClass(String browser, String url){
        driver = getBrowserDriver(browser, url);
        homePage = PageGeneratorPO.getHomePage(driver);
        registerPage = homePage.clickToRegisterLink(driver);

        firstName="Nga";
        lastName="Vu";
        email=genRandomEmail(firstName);
        password="123456a@";

        // Register thành công
        registerPage.enterToFirstnameTextbox(firstName);
        registerPage.enterToLastnameTextbox(lastName);
        registerPage.enterToEmailTextbox(email);
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToPasswordConfirmTextbox(password);
        registerPage.clickToRegisterButton();

        Assert.assertTrue(homePage.isMyAccountDisplayed());

        myAccountPage = homePage.clickToMyAccountLink(driver);

    }
    @Test
    public void TC_01_Update_Customer_Infor(Method method){
        firstNameUpdate = firstName+"update";
        lastNameUpdate = lastName+"update";
        companyNameUpdate = companyName+"update";
        ExtentManager.startTest(method.getName(),"TC_01_Update_Customer_Infor");
        ExtentManager.getTest().log(Status.INFO,"TC_01_Update_Customer_Infor - STEP 01: Select gender is male");
        myAccountPage.selectToFemaleGender();

        ExtentManager.getTest().log(Status.INFO,"TC_01_Update_Customer_Infor - STEP 02: Enter first name");
        myAccountPage.enterToFirstnameTextbox(firstNameUpdate);

        ExtentManager.getTest().log(Status.INFO,"TC_01_Update_Customer_Infor - STEP 03: Enter last name");
        myAccountPage.enterToLastnameTextbox(lastNameUpdate);

        ExtentManager.getTest().log(Status.INFO,"TC_01_Update_Customer_Infor - STEP 04: Enter company name");
        myAccountPage.enterToCompanyNameTextbox(companyNameUpdate);

        ExtentManager.getTest().log(Status.INFO,"TC_01_Update_Customer_Infor - STEP 05: Enter email");
        myAccountPage.enterToEmailTextbox(email);


        ExtentManager.getTest().log(Status.INFO,"TC_01_Update_Customer_Infor - STEP 06: Click button Save");
        myAccountPage.clickToSaveButton();

        ExtentManager.getTest().log(Status.INFO,"TC_01_Update_Customer_Infor - STEP 07: Verify successful message");
        Assert.assertEquals(myAccountPage.getMessageUpdateSuccess(), "The customer info has been updated successfully.");

        ExtentManager.getTest().log(Status.INFO,"TC_01_Update_Customer_Infor - STEP 08: Verify Customer information after update");
        Assert.assertTrue(myAccountPage.isMaleGenderChecked());
        Assert.assertEquals(myAccountPage.getFirstNameText(),firstNameUpdate);
        Assert.assertEquals(myAccountPage.getLastNameText(),lastNameUpdate);
        Assert.assertEquals(myAccountPage.getEmailText(),email);
        Assert.assertEquals(myAccountPage.getCompanyNameText(),companyNameUpdate);
    }
   // @Test
    public void TC_02_Add_Addresses_Successfully(){



    }
   // @Test
    public void TC_03_Change_Password(){

    }
   // @Test
    public void TC_04_MyProduct_Review(){

    }



}
