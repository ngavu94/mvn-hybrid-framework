package pageObjects.orangeHRM.pim.employee;

import org.openqa.selenium.WebDriver;
import pageUIs.orangeHRM.pim.employee.ContactDetailPageUI;
import pojoData.orangehrm.EmployeeData;

public class ContactDetailPO extends EmployeeTabs{
    WebDriver driver;

    public ContactDetailPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void enterToStreet1Textbox(String street1) {
        //wait
        waitForElementVisible(driver, ContactDetailPageUI.STREET_1_TEXTBOX);
        //enter
        sendkeysToElement(driver, ContactDetailPageUI.STREET_1_TEXTBOX, street1);
    }

    public void enterToStreet2Textbox(String street2) {
        //wait
        waitForElementVisible(driver, ContactDetailPageUI.STREET_2_TEXTBOX);
        //enter
        sendkeysToElement(driver, ContactDetailPageUI.STREET_2_TEXTBOX, street2);
    }

    public void enterToCityTextbox(String cityName) {
        //wait
        waitForElementVisible(driver, ContactDetailPageUI.CITY_TEXTBOX);
        //enter
        sendkeysToElement(driver, ContactDetailPageUI.CITY_TEXTBOX, cityName);
    }

    public void enterToStateProvinceTextbox(String stateProvince) {
        //wait
        waitForElementVisible(driver, ContactDetailPageUI.STATE_PROVINCE_TEXTBOX);
        //enter
        sendkeysToElement(driver, ContactDetailPageUI.STATE_PROVINCE_TEXTBOX, stateProvince);
    }
    public void enterToZipPostalCodeTextbox(String postalCode) {
        //wait
        waitForElementVisible(driver, ContactDetailPageUI.ZIP_POSTAL_CODE_TEXTBOX);
        //enter
        sendkeysToElement(driver, ContactDetailPageUI.ZIP_POSTAL_CODE_TEXTBOX, postalCode);
    }

    public void selectToCountryDropdown(String country) {
        //wait clickable
        waitForElementClickable(driver, ContactDetailPageUI.COUNTRY_DROPDOWN_PARENT);
        selectItemInCustomDropdown(driver, ContactDetailPageUI.COUNTRY_DROPDOWN_PARENT, ContactDetailPageUI.COUNTRY_DROPDOWN_CHILD,country);
    }

    public void enterToHomePhoneTextbox(String homePhoneNumber) {
        //wait
        waitForElementVisible(driver, ContactDetailPageUI.HOME_PHONE_TEXTBOX);
        //enter
        sendkeysToElement(driver, ContactDetailPageUI.HOME_PHONE_TEXTBOX, homePhoneNumber);
    }

    public void enterToMobilePhoneTextbox(String mobilePhoneNumber) {
        //wait
        waitForElementVisible(driver, ContactDetailPageUI.MOBILE_PHONE_TEXTBOX);
        //enter
        sendkeysToElement(driver, ContactDetailPageUI.MOBILE_PHONE_TEXTBOX, mobilePhoneNumber);
    }

    public void enterToWorkPhoneTextbox(String workPhoneNumber) {
        //wait
        waitForElementVisible(driver, ContactDetailPageUI.WORK_PHONE_TEXTBOX);
        //enter
        sendkeysToElement(driver, ContactDetailPageUI.WORK_PHONE_TEXTBOX, workPhoneNumber);
    }

    public void enterToWorkEmailTextbox(String workEmail) {
        //wait
        waitForElementVisible(driver, ContactDetailPageUI.WORK_EMAIL_TEXTBOX);
        //enter
        sendkeysToElement(driver, ContactDetailPageUI.WORK_EMAIL_TEXTBOX, workEmail);
    }

    public void clickToSaveButtonInContactDetails() {
        //wait
        waitForElementClickable(driver, ContactDetailPageUI.SAVE_BUTTON_IN_CONTACT_DETAIL);
        //click
        clickToElement(driver, ContactDetailPageUI.SAVE_BUTTON_IN_CONTACT_DETAIL);
    }

    public String getStreet1TextboxValue() {
        waitForElementVisible(driver, ContactDetailPageUI.STREET_1_TEXTBOX);
        return getElementAttribute(driver, ContactDetailPageUI.STREET_1_TEXTBOX,"value");
    }

    public String getStreet2TextboxValue() {
        waitForElementVisible(driver, ContactDetailPageUI.STREET_2_TEXTBOX);
        return getElementAttribute(driver, ContactDetailPageUI.STREET_2_TEXTBOX,"value");
    }

    public String getCityTextboxValue() {
        waitForElementVisible(driver, ContactDetailPageUI.CITY_TEXTBOX);
        return getElementAttribute(driver, ContactDetailPageUI.CITY_TEXTBOX,"value");
    }

    public String getStateProvinceTextboxValue() {
        waitForElementVisible(driver, ContactDetailPageUI.STATE_PROVINCE_TEXTBOX);
        return getElementAttribute(driver, ContactDetailPageUI.STATE_PROVINCE_TEXTBOX,"value");
    }

    public String getCountrySelectedDropdownValue() {
        waitForElementVisible(driver, ContactDetailPageUI.COUNTRY_DROPDOWN_SELECTED);
        return getElementText(driver, ContactDetailPageUI.COUNTRY_DROPDOWN_SELECTED);
    }


    public String getHomePhoneTextboxValue() {
        waitForElementVisible(driver, ContactDetailPageUI.HOME_PHONE_TEXTBOX);
        return getElementAttribute(driver, ContactDetailPageUI.HOME_PHONE_TEXTBOX,"value");
    }

    public String getMobilePhoneTextboxValue() {
        waitForElementVisible(driver, ContactDetailPageUI.MOBILE_PHONE_TEXTBOX);
        return getElementAttribute(driver, ContactDetailPageUI.MOBILE_PHONE_TEXTBOX,"value");
    }

    public String getWorkPhoneTextboxValue() {
        waitForElementVisible(driver, ContactDetailPageUI.WORK_PHONE_TEXTBOX);
        return getElementAttribute(driver, ContactDetailPageUI.WORK_PHONE_TEXTBOX,"value");
    }

    public String getWorkEmailTextboxValue() {
        waitForElementVisible(driver, ContactDetailPageUI.WORK_EMAIL_TEXTBOX);
        return getElementAttribute(driver, ContactDetailPageUI.WORK_EMAIL_TEXTBOX,"value");
    }


    public void setContactDetail(EmployeeData employeeData) {
        enterToStreet1Textbox(employeeData.getStreet1());
        enterToStreet2Textbox(employeeData.getStreet2());
        enterToCityTextbox(employeeData.getCity());
        enterToStateProvinceTextbox(employeeData.getState());
        enterToZipPostalCodeTextbox(employeeData.getPostalCode());
        selectToCountryDropdown(employeeData.getCountry());
        enterToHomePhoneTextbox(employeeData.getHomePhone());
        enterToMobilePhoneTextbox(employeeData.getMobilePhone());
        enterToWorkPhoneTextbox(employeeData.getWorkPhone());
        enterToWorkEmailTextbox(employeeData.getWorkEmail());

    }
}
