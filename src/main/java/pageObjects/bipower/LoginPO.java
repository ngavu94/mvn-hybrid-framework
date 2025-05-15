package pageObjects.bipower;


import org.openqa.selenium.WebDriver;
import commons.BasePage;
import pageUIs.bipower.LoginPageUI;

public class LoginPO extends BasePage {
    private WebDriver driver;

    public LoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToEmailTextbox(String email) {
        waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
        sendkeysToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
    }

    public void inputToPasswordTextbox(String password) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendkeysToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public void clickToLoginButton() {
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
    }

    public void loginAsUser(String email, String password) {
        inputToEmailTextbox(email);
        inputToPasswordTextbox(password);
        clickToLoginButton();
        // Không return page object mới vì không có màn mặc định
    }

    public boolean isLogoutButtonDisplayed() {
        clickToElement(driver, LoginPageUI.LINK_NAME);
        waitForElementVisible(driver,LoginPageUI.LOGOUT_BUTTON);
        return isElementDisplayed(driver, LoginPageUI.LOGOUT_BUTTON);
    }


    public void clickLogoutButton() {
        clickToElement(driver, LoginPageUI.LINK_NAME);
        waitForElementVisible(driver,LoginPageUI.LOGOUT_BUTTON);
        clickToElement(driver, LoginPageUI.LOGOUT_BUTTON);
    }

    public String isEmailErrorMessageDisplayed() {
        return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
    }
    public String isPasswordErrorMessageDisplayed() {
        return getElementText(driver, LoginPageUI.PASSWORD_ERROR_MESSAGE);
    }
}


