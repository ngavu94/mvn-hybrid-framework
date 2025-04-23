package pageObjects.nopCommerce.demo;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.demo.MyAccountPageUIs;
import pageUIs.nopCommerce.demo.RegisterPageUIs;

public class MyAccountPageObject extends BasePage {
    WebDriver driver;

    public MyAccountPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void selectToFemaleGender() {
        waitForElementClickable(driver, MyAccountPageUIs.MALE_GENDER_RADIO_BUTTON);
        checkToCheckboxOrRadio(driver, MyAccountPageUIs.MALE_GENDER_RADIO_BUTTON);
    }

    public void enterToFirstnameTextbox(String firstName) {
        waitForElementClickable(driver, MyAccountPageUIs.FIRST_NAME_TEXTBOX);
        senkeysToElement(driver, MyAccountPageUIs.FIRST_NAME_TEXTBOX, firstName);
    }
    public void enterToLastnameTextbox(String lastName) {
        waitForElementClickable(driver, MyAccountPageUIs.LAST_NAME_TEXTBOX);
        senkeysToElement(driver, MyAccountPageUIs.LAST_NAME_TEXTBOX, lastName);
    }
    public void enterToEmailTextbox(String email) {
        waitForElementVisible(driver, MyAccountPageUIs.EMAIL_TEXTBOX);
        senkeysToElement(driver, MyAccountPageUIs.EMAIL_TEXTBOX, email);
    }

    public void enterToCompanyNameTextbox(String companyName) {
        waitForElementVisible(driver, MyAccountPageUIs.COMPANY_NAME_TEXTBOX);
        senkeysToElement(driver, MyAccountPageUIs.COMPANY_NAME_TEXTBOX, companyName);
    }

    public String getMessageUpdateSuccess() {
        waitForElementVisible(driver, MyAccountPageUIs.MESSAGE_SUCCESS);
        return getElementText(driver, MyAccountPageUIs.MESSAGE_SUCCESS);

    }

    public void clickToSaveButton() {
        waitForElementClickable(driver, MyAccountPageUIs.SAVE_BUTTON);
        clickToElement(driver, MyAccountPageUIs.SAVE_BUTTON);
    }

    public boolean isMaleGenderChecked() {

        return isElementSelected(driver, MyAccountPageUIs.MALE_GENDER_RADIO_BUTTON);
    }

    public String getFirstNameText() {
        waitForElementVisible(driver, MyAccountPageUIs.FIRST_NAME_TEXTBOX);
        return getElementAttribute(driver, MyAccountPageUIs.FIRST_NAME_TEXTBOX,"value");
    }
    public String getLastNameText() {
        waitForElementVisible(driver, MyAccountPageUIs.LAST_NAME_TEXTBOX);
        return getElementAttribute(driver, MyAccountPageUIs.LAST_NAME_TEXTBOX,"value");
    }

    public String getEmailText() {
        waitForElementVisible(driver, MyAccountPageUIs.EMAIL_TEXTBOX);
        return getElementAttribute(driver, MyAccountPageUIs.EMAIL_TEXTBOX,"value");
    }

    public String getCompanyNameText() {
        waitForElementVisible(driver, MyAccountPageUIs.COMPANY_NAME_TEXTBOX);
        return getElementAttribute(driver, MyAccountPageUIs.COMPANY_NAME_TEXTBOX,"value");
    }
}
