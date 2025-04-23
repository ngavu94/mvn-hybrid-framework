package pageObjects.nopCommerce.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.PageGenerator;
import pageUIs.nopCommerce.users.UserLoginPageUI;

public class UserLoginPO extends BasePage {
    private WebDriver driver;
    public UserLoginPO(WebDriver driver){
        this.driver = driver;
    }

    public void enterToEmailTextbox(String email) {
        waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
        senkeysToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, email);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
        senkeysToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public UserHomePO clickLoginToSystem() {
        waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
        return PageGenerator.getUserHomePage(driver);
    }
}
