package pageObjects.nopCommerce.users;

import commons.BasePage;
import jsonData.nopCommerce.UserDataJson;
import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.PageGenerator;
import pageUIs.nopCommerce.users.UserHomePageUI;
import pageUIs.nopCommerce.users.UserRegisterPageUI;
import pojoData.nopcomerce.UserInfor;

public class UserRegisterPO extends BasePage {
    private WebDriver driver;

    public UserRegisterPO(WebDriver driver){
        this.driver = driver;
    }
    public void clickToMaleRadio() {
        waitForElementClickable(driver, UserRegisterPageUI.GENDER_MALE_RADIO);
        clickToElement(driver, UserRegisterPageUI.GENDER_MALE_RADIO);
    }

    public void enterToFirstNameTextbox(String firstName) {
        sendkeysToElement(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX,firstName);
    }

    public void enterToLastNameTextbox(String lastName) {
        sendkeysToElement(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX,lastName);
    }

//    public void selectDayDropdown(String number) {
//    }
//
//    public void selectMonthDropdown(String number) {
//    }
//
//    public void selectYearDropdown(String number) {
//    }

    public void enterToEmailTextbox(String email) {
        sendkeysToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX,email);
    }

    public void enterToCompanyTextbox(String companyName) {
        sendkeysToElement(driver, UserRegisterPageUI.COMPANY_NAME_TEXTBOX,companyName);
    }

    public void enterToPasswordTextbox(String password) {
        sendkeysToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX,password);
    }

    public void enterToPasswordConfirmTextbox(String confirmPassword) {
        sendkeysToElement(driver, UserRegisterPageUI.PASSWORD_CONFIRMED_TEXTBOX,confirmPassword);
    }

    public void clickRegisterButton() {
        waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
    }

    public String getRegisterSuccessMessage() {
        return getElementText(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
    }

    public UserLoginPO clickToLoginButton() {
        waitForElementClickable(driver, UserHomePageUI.LOGIN_LINK);
        clickToElement(driver, UserHomePageUI.LOGIN_LINK);
        return PageGenerator.getUserLoginPage(driver);
    }
    public void clickToLogoutButton(){
        waitForElementClickable(driver, UserHomePageUI.LOGOUT_LINK);
        clickToElement(driver, UserHomePageUI.LOGOUT_LINK);
    }

    public String getRegisterPageTitle(WebDriver driver) {
        waitForElementVisible(driver, UserRegisterPageUI.REGISTER_PAGE_TITLE);
        return getElementText(driver, UserRegisterPageUI.REGISTER_PAGE_TITLE);
    }

    public void enterToRegisterForm(UserInfor userInfor){
        enterToFirstNameTextbox(userInfor.getFirstName());
        enterToEmailTextbox(userInfor.getEmailAddress());
        enterToLastNameTextbox(userInfor.getLastName());
        enterToCompanyTextbox(userInfor.getCompanyName());
        enterToPasswordTextbox(userInfor.getPassword());
        enterToPasswordConfirmTextbox(userInfor.getPassword());
    }
    public void setToRegisterForm(UserDataJson userInfor){
        enterToFirstNameTextbox(userInfor.getFirstname());
        enterToEmailTextbox(userInfor.getEmail());
        enterToLastNameTextbox(userInfor.getLastname());
        enterToCompanyTextbox(userInfor.getCompanyname());
        enterToPasswordTextbox(userInfor.getPassword());
        enterToPasswordConfirmTextbox(userInfor.getPassword());
    }
}
