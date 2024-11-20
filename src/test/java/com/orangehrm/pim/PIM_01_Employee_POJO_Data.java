package com.orangehrm.pim;

import commons.BaseTest;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.orangeHRM.DashboardPO;
import pageObjects.orangeHRM.LoginPO;
import pageObjects.orangeHRM.PageGenerator;
import pageObjects.orangeHRM.pim.employee.*;
import pojoData.orangehrm.EmployeeData;

public class PIM_01_Employee_POJO_Data extends BaseTest {
    private WebDriver driver;
    //pages
    private LoginPO loginPO;
    private DashboardPO dashboardPage;
    private AddNewEmployeePO addNewEmployeePage;
    private EmployeeListPO employeeListPage;
    private PersonalDetailPO personalDetailPage;
    private ContactDetailPO contactDetailPage;
    private EmergencyContactsPO emergencyContactsPage;
    private EmployeeData employeeData;


    //Variables
    private String avatarImageName = "image01.png";



    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        loginPO = PageGenerator.getLoginPage(driver);
        employeeData = EmployeeData.getEmployeeData();
        employeeData.setAddFirstName("Michele");
        employeeData.setAddLastName("Jyn");
        employeeData.setAddMiddleName("Lenona");
        employeeData.setEditFirstName("Micheal");
        employeeData.setEditMiddleName("Linn");
        employeeData.setEditLastName("Jinny");
        employeeData.setEditDateOfBirth("12/09/1995");
        employeeData.setEditDriverLicenseNumber("2024");
        employeeData.setEditLicenseExpireDate("");
        employeeData.setEditMaritalStatus("12/09/2025");
        employeeData.setEditNationality("Viet Nam");

        employeeData.setStreet1("Dich Vong");
        employeeData.setStreet2("Tran Thai Tong");
        employeeData.setCity("Ha Noi");
        employeeData.setState("08");
        employeeData.setPostalCode("29");
        employeeData.setPostalCode("Viet Nam");
        employeeData.setHomePhone("02401092920");
        employeeData.setMobilePhone("0954321214");
        employeeData.setWorkPhone("0954321214");
        employeeData.setWorkEmail("0954321214");

        //Login
        loginPO.enterToUsernameTextbox("Nga@automation1");
        loginPO.enterToPasswordTextbox("Nga@automation1");

        dashboardPage = loginPO.clickToLoginButton();
    }

    @Test(groups = "regression")
    public void Employee_01_Add_New() {
        System.out.println("Driver trước " + driver);
        employeeListPage = dashboardPage.clickToPIMPage();
        System.out.println("Driver trước " + driver);
        addNewEmployeePage = employeeListPage.clickToAddEmployeeButton();
        addNewEmployeePage.enterToFirstnameTextbox(employeeData.getAddFirstName());
        addNewEmployeePage.enterToMiddlenameTextbox(employeeData.getAddMiddleName());
        addNewEmployeePage.enterToLastnameTextbox(employeeData.getAddLastName());

        employeeData.setEmployeeID(addNewEmployeePage.getEmployeeID());
        System.out.println("employeeID " + employeeData.getEmployeeID());
        personalDetailPage = addNewEmployeePage.clickToSaveButton();

    }

    @Test(groups = "regression")
    public void Employee_02_Upload_Avatar() {
        personalDetailPage.clickToAvatarImage();
        //Load file lên
        personalDetailPage.uploadMultipleFiles(driver, avatarImageName);
        //Lấy ra height/width của element (avatar)
        personalDetailPage.sleepInSeconds(3);
        Dimension beforeUpload = personalDetailPage.getAvatarSize();
        //System.out.println("beforeUpload" + beforeUpload);
        personalDetailPage.sleepInSeconds(1);
        personalDetailPage.clickToSaveButtonAtProfileContainer();
        //personalDetailPage.sleepInSeconds(1);
        Assert.assertTrue(personalDetailPage.isSuccessMessageDisplayed(driver));
        personalDetailPage.waitAllLoadingIconInvisible(driver);
        Assert.assertTrue(personalDetailPage.isProfileAvatarUpdateSuccess(beforeUpload));

    }

    @Test(groups = "regression")
    public void Employee_03_Personal_Details() {

        personalDetailPage.openPersonalDetailPage();
        //System.out.println("Driver sau "+driver);
        //personalDetailPage.sleepInSeconds(5);
        personalDetailPage.setPersonalDetail(employeeData);
        Assert.assertEquals(personalDetailPage.getEmployeeID(), employeeData.getEmployeeID());
        Assert.assertTrue(personalDetailPage.isSuccessMessageDisplayed(driver));
        personalDetailPage.waitAllLoadingIconInvisible(driver);

        //Verify
        Assert.assertEquals(personalDetailPage.getFirstNameTextboxValue(), employeeData.getEditFirstName());
        Assert.assertEquals(personalDetailPage.getMiddleNameTextboxValue(), employeeData.getEditMiddleName());
        Assert.assertEquals(personalDetailPage.getLastNameTextboxValue(), employeeData.getEditLastName());
        Assert.assertEquals(personalDetailPage.getEmployeeID(), employeeData.getEmployeeID());
        Assert.assertEquals(personalDetailPage.getNationalityValue(), employeeData.getEditNationality());
        Assert.assertEquals(personalDetailPage.getMartialStatusValue(), employeeData.getEditMaritalStatus());
        Assert.assertEquals(personalDetailPage.getDateOfBirthValue(), employeeData.getEditDateOfBirth());
        Assert.assertTrue(personalDetailPage.isGenderMaleRadioSelected());

    }

    @Test
    public void Employee_04_Contacts_Details() {
        contactDetailPage = personalDetailPage.openContactDetailPage();
        contactDetailPage.waitAllLoadingIconInvisible(driver);
        contactDetailPage.setContactDetail(employeeData);
        contactDetailPage.clickToSaveButtonInContactDetails();

        //Verify all fields
        Assert.assertEquals(contactDetailPage.getStreet1TextboxValue(),employeeData.getStreet1());
        Assert.assertEquals(contactDetailPage.getStreet2TextboxValue(),employeeData.getStreet2());
        Assert.assertEquals(contactDetailPage.getCityTextboxValue(),employeeData.getCity());
        Assert.assertEquals(contactDetailPage.getStateProvinceTextboxValue(), employeeData.getState());
        Assert.assertEquals(contactDetailPage.getCountrySelectedDropdownValue(), employeeData.getCountry());
        Assert.assertEquals(contactDetailPage.getHomePhoneTextboxValue(),employeeData.getHomePhone());
        Assert.assertEquals(contactDetailPage.getMobilePhoneTextboxValue(),employeeData.getMobilePhone() );
        Assert.assertEquals(contactDetailPage.getWorkPhoneTextboxValue(),employeeData.getWorkPhone());
        Assert.assertEquals(contactDetailPage.getWorkEmailTextboxValue(), employeeData.getWorkEmail());

    }

//    @Test
//    public void Employee_05_Emergency_Details() {
//        emergencyContactsPage = personalDetailPage.openEmergencyContactlPage();
//        emergencyContactsPage.clickToAddEmergencyContactButton();
//        emergencyContactsPage.enterToNameTextbox("");
//        emergencyContactsPage.enterToRelationshipTextbox("");
//        emergencyContactsPage.enterToHomeTelephoneTextbox("");
//        emergencyContactsPage.enterToMobileTelephoneTextbox("");
//        emergencyContactsPage.enterToWorkTelephoneTextbox("");
//        emergencyContactsPage.clickToSaveButton();
//
//        //verify value in table
//
//
//    }

    //@AfterClass
    public void afterClass() {
        closeBrowerDriver();
    }

}
