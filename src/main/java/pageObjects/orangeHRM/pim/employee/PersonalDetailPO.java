package pageObjects.orangeHRM.pim.employee;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import pageUIs.orangeHRM.pim.employee.PersonalDetailPageUI;
import pojoData.orangehrm.EmployeeData;

public class PersonalDetailPO extends EmployeeTabs {
    WebDriver driver;

    public PersonalDetailPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public Dimension getAvatarSize() {
        return getElementSize(driver, PersonalDetailPageUI.AVATAR_IMG);
    }

    public void clickToAvatarImage() {
        waitForElementClickable(driver, PersonalDetailPageUI.AVATAR_IMG);
        clickToElement(driver, PersonalDetailPageUI.AVATAR_IMG);
    }

    public void clickToSaveButtonAtProfileContainer() {
        waitForElementClickable(driver, PersonalDetailPageUI.SAVE_BUTTON_AT_EDIT_PROFILE_CONTAINER);
        clickToElement(driver, PersonalDetailPageUI.SAVE_BUTTON_AT_EDIT_PROFILE_CONTAINER);
    }


    public boolean isProfileAvatarUpdateSuccess(Dimension beforeUpload) {
        sleepInSeconds(3);
        Dimension afterUpload = getAvatarSize();
        System.out.println("afterUpload: " + afterUpload);
        return !(beforeUpload.equals(afterUpload));
    }

    public void enterToFirstNameTextbox(String firstName) {
        sleepInSeconds(1);
        waitForElementVisible(driver, PersonalDetailPageUI.FIRST_NAME_TEXTBOX);
        senkeysToElement(driver, PersonalDetailPageUI.FIRST_NAME_TEXTBOX, firstName);
    }

    public void enterToMiddleNameTextbox(String middleName) {
        waitForElementVisible(driver, PersonalDetailPageUI.MIDDLE_NAME_TEXTBOX);
        senkeysToElement(driver, PersonalDetailPageUI.MIDDLE_NAME_TEXTBOX, middleName);
    }

    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, PersonalDetailPageUI.LAST_NAME_TEXTBOX);
        senkeysToElement(driver, PersonalDetailPageUI.LAST_NAME_TEXTBOX, lastName);
    }

    public String getEmployeeID() {
        waitForElementVisible(driver, PersonalDetailPageUI.EMPLOYEE_ID_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailPageUI.EMPLOYEE_ID_TEXTBOX, "value");
    }

    public void enterToDriverLicenseNumberTextbox(String driverLicenseNumber) {
        waitForElementVisible(driver, PersonalDetailPageUI.DRIVER_LICENCE_NUMBER_TEXTBOX);
        senkeysToElement(driver, PersonalDetailPageUI.DRIVER_LICENCE_NUMBER_TEXTBOX, driverLicenseNumber);

    }

    public void enterToLicenseExpiryDateTextbox(String licenseExpiryDate) {
        waitForElementVisible(driver, PersonalDetailPageUI.LICENCE_EXPIRY_DATE_TEXTBOX);
        senkeysToElement(driver, PersonalDetailPageUI.LICENCE_EXPIRY_DATE_TEXTBOX, licenseExpiryDate);
    }

    public void selectToNationalityDropdown(String s) {
        waitForElementClickable(driver, PersonalDetailPageUI.NATIONALITY_DROPDOWN_PARENT);
        selectItemInCustomDropdown(driver, PersonalDetailPageUI.NATIONALITY_DROPDOWN_PARENT,PersonalDetailPageUI.NATIONALITY_DROPDOWN_CHILD, "Vietnamese");
    }

    public void selectToMartialStatusDropdown(String s) {
        waitForElementClickable(driver, PersonalDetailPageUI.MARITAL_STATUS_DROPDOWN_PARENT);
        selectItemInCustomDropdown(driver, PersonalDetailPageUI.MARITAL_STATUS_DROPDOWN_PARENT, PersonalDetailPageUI.MARITAL_STATUS_DROPDOWN_CHILD, "Single");
    }

    public void selectToDateOfBirthDropdown(String dateOfBirth) {
        waitForElementVisible(driver, PersonalDetailPageUI.DATE_OF_BIRTH_TEXTBOX);
        senkeysToElement(driver, PersonalDetailPageUI.DATE_OF_BIRTH_TEXTBOX, dateOfBirth);
    }

    public void selectToGenderRadioButton() {
        //checkToCheckboxOrRadio(driver, PersonalDetailPageUI.GENDER_RADIO_BUTTON);
        checkToCheckboxOrRadio(driver, PersonalDetailPageUI.GENDER_RADIO_BUTTON, "Male");

    }

    public void clickToSaveButtonAtPersonalDetail() {
        waitForElementClickable(driver, PersonalDetailPageUI.SAVE_BUTTON);
        clickToElement(driver, PersonalDetailPageUI.SAVE_BUTTON);
    }

    public String getFirstNameTextboxValue() {
        waitForElementVisible(driver, PersonalDetailPageUI.FIRST_NAME_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailPageUI.FIRST_NAME_TEXTBOX, "value");
    }

    public String getMiddleNameTextboxValue() {
        waitForElementVisible(driver, PersonalDetailPageUI.MIDDLE_NAME_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailPageUI.MIDDLE_NAME_TEXTBOX, "value");
    }

    public String getLastNameTextboxValue() {
        waitForElementVisible(driver, PersonalDetailPageUI.LAST_NAME_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailPageUI.LAST_NAME_TEXTBOX, "value");
    }

    public String getNationalityValue() {
        waitForElementVisible(driver, PersonalDetailPageUI.NATIONALITY_DROPDOWN_SELECTED);
        return getElementText(driver, PersonalDetailPageUI.NATIONALITY_DROPDOWN_SELECTED);
    }

    public String getMartialStatusValue() {
        waitForElementVisible(driver, PersonalDetailPageUI.MARITAL_STATUS_DROPDOWN_SELECTED);
        return getElementText(driver, PersonalDetailPageUI.MARITAL_STATUS_DROPDOWN_SELECTED);
    }

    public String getDateOfBirthValue() {
        waitForElementVisible(driver, PersonalDetailPageUI.DATE_OF_BIRTH_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailPageUI.DATE_OF_BIRTH_TEXTBOX, "value");
    }

    public boolean isGenderMaleRadioSelected() {
        return isElementSelected(driver, PersonalDetailPageUI.GENDER_RADIO_BUTTON_SELECTED, "Male");
    }


    public void setPersonalDetail(EmployeeData employeeData) {
        enterToFirstNameTextbox(employeeData.getEditFirstName());
        enterToMiddleNameTextbox(employeeData.getEditMiddleName());
        enterToLastNameTextbox(employeeData.getEditLastName());
        enterToDriverLicenseNumberTextbox(employeeData.getEditDriverLicenseNumber());
        enterToLicenseExpiryDateTextbox(employeeData.getEditLicenseExpireDate());
        selectToNationalityDropdown(employeeData.getEditNationality());
        selectToMartialStatusDropdown(employeeData.getEditMaritalStatus());
        selectToDateOfBirthDropdown(employeeData.getEditDateOfBirth());
        selectToGenderRadioButton();
        sleepInSeconds(1);
        clickToSaveButtonAtPersonalDetail();
    }
}
