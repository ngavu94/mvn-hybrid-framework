package pageObjects.saucelab;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.saucelab.LoginPageUIs;

public class LoginPageObject extends BasePage {
    private WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToUserNameTextbox(String username) {
        waitForElementVisible(driver, LoginPageUIs.USERNAME_TEXTBOX);
        senkeysToElement(driver, LoginPageUIs.USERNAME_TEXTBOX,username);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, LoginPageUIs.PASSWORD_TEXTBOX);
        senkeysToElement(driver, LoginPageUIs.PASSWORD_TEXTBOX,password);
    }

    public ProductPageObject clickToLoginButton() {
        waitForElementClickable(driver, LoginPageUIs.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUIs.LOGIN_BUTTON);
        return PageGeneratorManager.getProductPage(driver);
    }
}
