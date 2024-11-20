package com.orangehrm.pim;

import commons.BaseTest;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.orangeHRM.DashboardPO;
import pageObjects.orangeHRM.LoginPO;
import pageObjects.orangeHRM.PageGenerator;
import pageObjects.orangeHRM.pim.employee.*;

public class PIM_01_Employee extends BaseTest {
    private WebDriver driver;
    //pages
    private LoginPO loginPO;
    private DashboardPO dashboardPage;
    private AddNewEmployeePO addNewEmployeePage;
    private EmployeeListPO employeeListPage;
    private PersonalDetailPO personalDetailPage;
    private ContactDetailPO contactDetailPage;
    private EmergencyContactsPO emergencyContactsPage;


    //Variables
    private String employeeID, addFirstName, addMiddleName, addLastName;
    private String editFirstName, editMiddleName, editLastName, editDriverLicenseNumber, editLicenseExpireDate, editNationality, editMaritalStatus, editDateOfBirth;
    private String avatarImageName = "image01.png";

    private String street1, street2, city, state, postalCode, country, homePhone, mobilePhone, workPhone, workEmail;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        loginPO = PageGenerator.getLoginPage(driver);
        addFirstName = "Michale";
        addMiddleName = "Jame";
        addLastName = "W";
        editFirstName = "Michale_update";
        editMiddleName = "Jame_update";
        editLastName = "W_update";
        editDriverLicenseNumber = "2810";
        editLicenseExpireDate = "2024-10-28";
        editNationality = "Vietnamese";
        editMaritalStatus = "Single";
        editDateOfBirth = "2000-10-28";
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
        addNewEmployeePage.enterToFirstnameTextbox(addFirstName);
        addNewEmployeePage.enterToMiddlenameTextbox(addMiddleName);
        addNewEmployeePage.enterToLastnameTextbox(addLastName);
        employeeID = addNewEmployeePage.getEmployeeID();
        System.out.println("employeeID " + employeeID);
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
        personalDetailPage.enterToFirstNameTextbox(editFirstName);
        personalDetailPage.enterToMiddleNameTextbox(editMiddleName);
        personalDetailPage.enterToLastNameTextbox(editLastName);

        Assert.assertEquals(personalDetailPage.getEmployeeID(), employeeID);
        personalDetailPage.enterToDriverLicenseNumberTextbox(editDriverLicenseNumber);
        personalDetailPage.enterToLicenseExpiryDateTextbox(editLicenseExpireDate);
        personalDetailPage.selectToNationalityDropdown(editNationality);
        personalDetailPage.selectToMartialStatusDropdown(editMaritalStatus);
        personalDetailPage.selectToDateOfBirthDropdown(editDateOfBirth);
        personalDetailPage.selectToGenderRadioButton();
        personalDetailPage.sleepInSeconds(1);
        personalDetailPage.clickToSaveButtonAtPersonalDetail();
        Assert.assertTrue(personalDetailPage.isSuccessMessageDisplayed(driver));
        personalDetailPage.waitAllLoadingIconInvisible(driver);

        //Verify
        Assert.assertEquals(personalDetailPage.getFirstNameTextboxValue(), editFirstName);
        Assert.assertEquals(personalDetailPage.getMiddleNameTextboxValue(), editMiddleName);
        Assert.assertEquals(personalDetailPage.getLastNameTextboxValue(), editLastName);
        Assert.assertEquals(personalDetailPage.getEmployeeID(), employeeID);
        Assert.assertEquals(personalDetailPage.getNationalityValue(), editNationality);
        Assert.assertEquals(personalDetailPage.getMartialStatusValue(), editMaritalStatus);
        Assert.assertEquals(personalDetailPage.getDateOfBirthValue(), editDateOfBirth);
        Assert.assertTrue(personalDetailPage.isGenderMaleRadioSelected());

    }

    @Test
    public void Employee_04_Contacts_Details() {
        street1 = "Dich Vong";
        street2 = "Tran Thai Tong";
        city = "Ha Noi";
        state = "08";
        postalCode = "29";
        country = "Viet Nam";
        homePhone = "02401092920";
        mobilePhone = "0954321214";
        workPhone = "033338888";
        workEmail = "ctyABC@gmail.com";

        contactDetailPage = personalDetailPage.openContactDetailPage();
        contactDetailPage.waitAllLoadingIconInvisible(driver);
        contactDetailPage.enterToStreet1Textbox(street1);
        contactDetailPage.enterToStreet2Textbox(street2);
        contactDetailPage.enterToCityTextbox(city);
        contactDetailPage.enterToStateProvinceTextbox(state);
        contactDetailPage.enterToZipPostalCodeTextbox(postalCode);
        contactDetailPage.selectToCountryDropdown(country);
        contactDetailPage.enterToHomePhoneTextbox(homePhone);
        contactDetailPage.enterToMobilePhoneTextbox(mobilePhone);
        contactDetailPage.enterToWorkPhoneTextbox(workPhone);
        contactDetailPage.enterToWorkEmailTextbox(workEmail);
        contactDetailPage.clickToSaveButtonInContactDetails();

        //Verify all fields
        Assert.assertEquals(contactDetailPage.getStreet1TextboxValue(),street1);
        Assert.assertEquals(contactDetailPage.getStreet2TextboxValue(),street2);
        Assert.assertEquals(contactDetailPage.getCityTextboxValue(),city);
        Assert.assertEquals(contactDetailPage.getStateProvinceTextboxValue(), state);
        Assert.assertEquals(contactDetailPage.getCountrySelectedDropdownValue(), country);
        Assert.assertEquals(contactDetailPage.getHomePhoneTextboxValue(),homePhone);
        Assert.assertEquals(contactDetailPage.getMobilePhoneTextboxValue(),mobilePhone );
        Assert.assertEquals(contactDetailPage.getWorkPhoneTextboxValue(),workPhone);
        Assert.assertEquals(contactDetailPage.getWorkEmailTextboxValue(), workEmail);

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
