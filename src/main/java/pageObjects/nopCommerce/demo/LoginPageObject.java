package pageObjects.nopCommerce.demo;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.demo.LoginPageUIs;

public class LoginPageObject extends BasePage {
    private WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToEmailTextbox(String email) {
        waitForElementVisible(driver, LoginPageUIs.EMAIL_TEXTBOX);
        sendkeysToElement(driver, LoginPageUIs.EMAIL_TEXTBOX,email);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, LoginPageUIs.PASSWORD_TEXTBOX);
        sendkeysToElement(driver, LoginPageUIs.PASSWORD_TEXTBOX,password);
    }

    public void clickToLoginButton() {
        waitForElementClickable(driver, LoginPageUIs.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUIs.LOGIN_BUTTON);
    }

    public String getErrorMessageEmail() {
        return getElementText(driver, LoginPageUIs.EMAIL_ERROR_MESSAGE);
    }

    public String getErrorMessagePassword() {
        return getElementText(driver, LoginPageUIs.PASSWORD_ERROR_MESSAGE);
    }

    public String getErrorMessageValidationSummary() {
//        String mess = getElementText(driver, LoginPageUIs.ERROR_MESSAGE_VALIDATION_SUMMARY);;
        //System.out.println("error mess"+mess);
        return getElementText(driver, LoginPageUIs.ERROR_MESSAGE_VALIDATION_SUMMARY);
    }

    public String getSubErrorMessageValidationSummary() {
        return getElementText(driver, LoginPageUIs.SUB_ERROR_MESSAGE_VALIDATION_SUMMARY);
    }

    public String getHomePageAfterLoginSuccess() {
        return getElementText(driver, LoginPageUIs.TEXT_IN_HOME_PAGE);
    }
}
