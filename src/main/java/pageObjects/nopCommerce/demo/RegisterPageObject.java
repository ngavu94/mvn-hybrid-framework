package pageObjects.nopCommerce.demo;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.demo.RegisterPageUIs;

public class RegisterPageObject extends BasePage {
    WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void selectToMaleGender() {
        waitForElementClickable(driver, RegisterPageUIs.MALE_GENDER_RADIO_BUTTON);
        checkToCheckboxOrRadio(driver, RegisterPageUIs.MALE_GENDER_RADIO_BUTTON);
    }
    public void selectToFemaleGender() {
        waitForElementClickable(driver, RegisterPageUIs.FEMALE_GENDER_RADIO_BUTTON);
        checkToCheckboxOrRadio(driver, RegisterPageUIs.FEMALE_GENDER_RADIO_BUTTON);
    }

    public void enterToFirstnameTextbox(String firstName) {
        waitForElementClickable(driver, RegisterPageUIs.FIRST_NAME_TEXTBOX);
        sendkeysToElement(driver, RegisterPageUIs.FIRST_NAME_TEXTBOX, firstName);
    }

    public void enterToLastnameTextbox(String lastName) {
        waitForElementClickable(driver, RegisterPageUIs.LAST_NAME_TEXTBOX);
        sendkeysToElement(driver, RegisterPageUIs.LAST_NAME_TEXTBOX, lastName);
    }

    public void selectDayToDateOfBirth(String birthDay) {
        waitForElementClickable(driver, RegisterPageUIs.BIRTH_DAY_DROPDOWN_LIST);
        selectItemInDropdown(driver, RegisterPageUIs.BIRTH_DAY_DROPDOWN_LIST, birthDay);
    }

    public void selectMonthToDateOfBirth(String birthMonth) {
        waitForElementClickable(driver, RegisterPageUIs.BIRTH_MONTH_DROPDOWN_LIST);
        selectItemInDropdown(driver, RegisterPageUIs.BIRTH_MONTH_DROPDOWN_LIST, birthMonth);
    }

    public void selectYearToDateOfBirth(String birthYear) {
        waitForElementClickable(driver, RegisterPageUIs.BIRTH_YEAR_DROPDOWN_LIST);
        selectItemInDropdown(driver, RegisterPageUIs.BIRTH_YEAR_DROPDOWN_LIST, birthYear);
    }

    public void enterToEmailTextbox(String email) {
        waitForElementVisible(driver, RegisterPageUIs.EMAIL_TEXTBOX);
        sendkeysToElement(driver, RegisterPageUIs.EMAIL_TEXTBOX, email);
    }

    public void enterToCompanyNameTextbox(String companyName) {
        waitForElementVisible(driver, RegisterPageUIs.COMPANY_NAME_TEXTBOX);
        sendkeysToElement(driver, RegisterPageUIs.COMPANY_NAME_TEXTBOX, companyName);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, RegisterPageUIs.PASSWORD_TEXTBOX);
        sendkeysToElement(driver, RegisterPageUIs.PASSWORD_TEXTBOX, password);
    }

    public void enterToPasswordConfirmTextbox(String passwordConfirm) {
        waitForElementVisible(driver, RegisterPageUIs.PASSWORD_CONFIRM_TEXTBOX);
        sendkeysToElement(driver, RegisterPageUIs.PASSWORD_CONFIRM_TEXTBOX, passwordConfirm);
    }
    public void clickToRegisterButton() {
        waitForElementClickable(driver, RegisterPageUIs.REGISTER_BUTTON);
        clickToElement(driver, RegisterPageUIs.REGISTER_BUTTON);
    }

    public String getFirstNameErrorMessageDisplayed() {
        return getElement(driver, RegisterPageUIs.FIRST_NAME_ERROR_MESSAGE).getText();
    }
    public String getLastNameErrorMessageDisplayed() {
        return getElement(driver, RegisterPageUIs.LAST_NAME_ERROR_MESSAGE).getText();
    }

    public String getEmailErrorMessageDisplayed() {
        return getElement(driver, RegisterPageUIs.EMAIL_ERROR_MESSAGE).getText();
    }
    public String getPasswordErrorMessageDisplayed() {
        return getElement(driver, RegisterPageUIs.CONFIRM_PASSWORD_ERROR_MESSAGE).getText();
    }


    public String getMessageRegisterSuccess() {
        waitForElementVisible(driver, RegisterPageUIs.SUCCESS_MESSAGE);
        return  getElementText(driver, RegisterPageUIs.SUCCESS_MESSAGE);
    }

    public String getMessageExistedEmail() {
        waitForElementVisible(driver, RegisterPageUIs.EXISTED_EMAIL_MESSAGE);
        return getElementText(driver, RegisterPageUIs.EXISTED_EMAIL_MESSAGE);
    }

    public void clickToLogoutLink() {
        waitForElementClickable(driver, RegisterPageUIs.LOGOUT_LINK);
        clickToElement(driver, RegisterPageUIs.LOGOUT_LINK);
    }

    public String getMessagePasswordLessThan6Chacs() {
        waitForElementVisible(driver, RegisterPageUIs.PASSWORD_ERROR_MESSAGE);
        return getElementText(driver, RegisterPageUIs.PASSWORD_ERROR_MESSAGE);
    }
}
