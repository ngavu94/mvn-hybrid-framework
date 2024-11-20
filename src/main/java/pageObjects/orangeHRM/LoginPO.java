package pageObjects.orangeHRM;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.orangeHRM.LoginPageUI;

public class LoginPO extends BasePage {
    WebDriver driver;

    public LoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToUsernameTextbox(String username) {

        waitForElementVisible(driver, LoginPageUI.USERNAME_TEXTBOX);
        senkeysToElement(driver, LoginPageUI.USERNAME_TEXTBOX,username);
    }

    public void enterToPasswordTextbox(String password) {

        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        senkeysToElement(driver, LoginPageUI.PASSWORD_TEXTBOX,password);
    }

    public DashboardPO clickToLoginButton() {
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getDashboardPage(driver);
    }
}
